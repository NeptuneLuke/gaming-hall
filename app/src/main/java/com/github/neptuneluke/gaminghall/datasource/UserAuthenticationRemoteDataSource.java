package com.github.neptuneluke.gaminghall.datasource;

import static com.github.neptuneluke.gaminghall.Constants.INVALID_CREDENTIALS_ERROR;
import static com.github.neptuneluke.gaminghall.Constants.INVALID_USER_ERROR;
import static com.github.neptuneluke.gaminghall.Constants.UNEXPECTED_ERROR;
import static com.github.neptuneluke.gaminghall.Constants.USER_COLLISION_ERROR;
import static com.github.neptuneluke.gaminghall.Constants.WEAK_PASSWORD_ERROR;

import android.util.Log;

import androidx.annotation.NonNull;

import com.github.neptuneluke.gaminghall.model.User;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


/**
 * Class that manages the user authentication using Firebase Authentication.
 */
public class UserAuthenticationRemoteDataSource extends BaseUserAuthenticationRemoteDataSource {

    private static final String TAG = UserAuthenticationRemoteDataSource.class.getSimpleName();

    private final FirebaseAuth firebase_auth;

    public UserAuthenticationRemoteDataSource() {
        firebase_auth = FirebaseAuth.getInstance();
    }

    @Override
    public User getLoggedUser() {

        FirebaseUser firebase_user = firebase_auth.getCurrentUser();
        if (firebase_user == null) {
            return null;
        } else {
            return new User(firebase_user.getDisplayName(), firebase_user.getEmail(), firebase_user.getUid());
        }
    }

    @Override
    public void logout() {

        FirebaseAuth.AuthStateListener auth_state_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    firebaseAuth.removeAuthStateListener(this);
                    Log.d(TAG, "USER LOGGED OUT");
                    user_response_callback.onSuccessLogout();
                }
            }
        };
        firebase_auth.addAuthStateListener(auth_state_listener);
        firebase_auth.signOut();
    }

    @Override
    public void signUp(String email, String password) {

        firebase_auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

                FirebaseUser firebase_user = firebase_auth.getCurrentUser();

                if (firebase_user != null) {
                    Log.e(TAG, "no error");
                    user_response_callback.onSuccessFromAuthentication(
                            new User(firebase_user.getDisplayName(), email, firebase_user.getUid())
                    );
                }
                else {
                    Log.e(TAG, "error 1");
                    user_response_callback.onFailureFromAuthentication(getErrorMessage(task.getException()));

                }
            }
            else {
                Log.e(TAG, "error 2");
                user_response_callback.onFailureFromAuthentication(getErrorMessage(task.getException()));

            }
        });
    }

    @Override
    public void signIn(String email, String password) {

        firebase_auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {

                FirebaseUser firebase_user = firebase_auth.getCurrentUser();
                if (firebase_user != null) {
                    user_response_callback.onSuccessFromAuthentication(
                            new User(firebase_user.getDisplayName(), email, firebase_user.getUid())
                    );
                }
                else {
                    user_response_callback.onFailureFromAuthentication(getErrorMessage(task.getException()));
                }
            }
            else {
                user_response_callback.onFailureFromAuthentication(getErrorMessage(task.getException()));
            }
        });
    }

    @Override
    public void signInWithGoogle(String googleToken) {

        if (googleToken !=  null) {
            // Got an ID token from Google. Use it to authenticate with Firebase.

            AuthCredential firebase_credential = GoogleAuthProvider.getCredential(googleToken, null);

            firebase_auth.signInWithCredential(firebase_credential).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success");
                    FirebaseUser firebase_user = firebase_auth.getCurrentUser();

                    if (firebase_user != null) {
                        user_response_callback.onSuccessFromAuthentication(
                                new User(firebase_user.getDisplayName(),
                                        firebase_user.getEmail(),
                                        firebase_user.getUid()
                                )
                        );
                    }
                    else {
                        user_response_callback.onFailureFromAuthentication(
                                getErrorMessage(task.getException()));
                    }
                }
                else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    user_response_callback.onFailureFromAuthentication(getErrorMessage(task.getException()));
                }
            });
        }
    }

    private String getErrorMessage(Exception exception) {
        if (exception instanceof FirebaseAuthWeakPasswordException) {
            return WEAK_PASSWORD_ERROR;
        } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
            return INVALID_CREDENTIALS_ERROR;
        } else if (exception instanceof FirebaseAuthInvalidUserException) {
            return INVALID_USER_ERROR;
        } else if (exception instanceof FirebaseAuthUserCollisionException) {
            return USER_COLLISION_ERROR;
        }
        return UNEXPECTED_ERROR;
    }
}
