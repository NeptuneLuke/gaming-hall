package com.github.neptuneluke.gaminghall.access;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.neptuneluke.gaminghall.MainActivity;
import com.github.neptuneluke.gaminghall.R;
import com.github.neptuneluke.gaminghall.Util;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationFragment extends Fragment {

    private static final String TAG = RegistrationFragment.class.getSimpleName();

    private TextInputLayout text_input_username, text_input_email, text_input_password;
    private Button button_registration;
    private TextView textview_login_link;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text_input_username = view.findViewById(R.id.text_input_layout_username);
        text_input_email = view.findViewById(R.id.text_input_layout_email);
        text_input_password = view.findViewById(R.id.text_input_layout_password);
        button_registration = view.findViewById(R.id.button_registration);
        textview_login_link = view.findViewById(R.id.textview_login_link);

        button_registration.setOnClickListener(v -> {
            Util.LOG_MESSAGE_D(TAG,"TRYING REGISTRATION WITH USERNAME-EMAIL-PASSWORD");

            String username = text_input_username.getEditText().getText().toString().trim();
            String email = text_input_email.getEditText().getText().toString().trim();
            String password = text_input_password.getEditText().getText().toString().trim();

            if(checkUsername(username) && checkEmail(email) && checkPassword(password)) {
                Util.LOG_MESSAGE_D(TAG,"USERNAME/EMAIL/PASSWORD VALID");

                signUpWith_Username_Email_Password();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Util.LOG_MESSAGE_D(TAG,"STARTING ACTIVITY: MAIN_ACTIVITY");
            }
            else {
                Util.LOG_MESSAGE_D(TAG,"USERNAME/EMAIL/PASSWORD NOT VALID");
            }
        });

        textview_login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.LOG_MESSAGE_D(TAG,"STARTING FRAGMENT: LOGIN_FRAGMENT");

                LoginFragment login_fragment = new LoginFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, login_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void signUpWith_Username_Email_Password() {

        Util.LOG_MESSAGE_D(TAG,"SIGNED UP WITH USERNAME-EMAIL-PASSWORD");
    }

    private boolean checkUsername(String username) {
        if(!Util.isValidUsername(username)) {
            String error = Resources.getSystem().getString(R.string.error_username_invalid);
            text_input_username.setError(error);
            return false;
        }
        return true;
    }

    private boolean checkEmail(String email) {
        if(!Util.isValidEmail(email)) {
            String error = Resources.getSystem().getString(R.string.error_email_invalid);
            text_input_email.setError(error);
            return false;
        }
        return true;
    }

    private boolean checkPassword(String password) {
        if(!Util.isValidPassword(password)) {
            String error = Resources.getSystem().getString(R.string.error_password_invalid);
            text_input_password.setError(error);
            return false;
        }
        return true;
    }
}
