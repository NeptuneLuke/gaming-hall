package com.github.neptuneluke.gaminghall.datasource;

import static com.github.neptuneluke.gaminghall.Constants.FIREBASE_REALTIME_DATABASE;
import static com.github.neptuneluke.gaminghall.Constants.FIREBASE_USERS_COLLECTION;

import android.util.Log;

import androidx.annotation.NonNull;

import com.github.neptuneluke.gaminghall.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Class that gets the user information using Firebase Realtime Database.
 */
public class UserDataRemoteDataSource extends BaseUserDataRemoteDataSource {

    private static final String TAG = UserDataRemoteDataSource.class.getSimpleName();

    private final DatabaseReference database_reference;


    public UserDataRemoteDataSource() {
        FirebaseDatabase firebase_database = FirebaseDatabase.getInstance(FIREBASE_REALTIME_DATABASE);
        database_reference = firebase_database.getReference().getRef();
    }

    @Override
    public void saveUserData(User user) {

        database_reference
                .child(FIREBASE_USERS_COLLECTION)
                .child(user.getGoogleToken()).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.e(TAG, "dfsdfs");
                if (snapshot.exists()) {
                    Log.d(TAG, "USER ALREADY FOUND IN FIREBASE REALTIME DATABASE");
                    user_response_callback.onSuccessFromRemoteDatabase(user);
                }
                else {
                    Log.d(TAG, "USER NOT FOUND IN FIREBASE REALTIME DATABASE");
                    database_reference.child(FIREBASE_USERS_COLLECTION)
                            .child(user.getGoogleToken()).setValue(user)

                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    user_response_callback.onSuccessFromRemoteDatabase(user);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    user_response_callback.onFailureFromRemoteDatabase(e.getLocalizedMessage());
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                user_response_callback.onFailureFromRemoteDatabase(error.getMessage());
            }
        });
    }
}
