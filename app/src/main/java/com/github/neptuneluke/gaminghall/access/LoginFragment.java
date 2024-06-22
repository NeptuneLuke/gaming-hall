package com.github.neptuneluke.gaminghall.access;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.neptuneluke.gaminghall.MainActivity;
import com.github.neptuneluke.gaminghall.R;
import com.github.neptuneluke.gaminghall.Util;
import com.google.android.material.textfield.TextInputLayout;


public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.getSimpleName();

    private TextInputLayout text_input_email, text_input_password;
    private Button button_login;
    private ImageView image_google_login;
    private TextView textview_registration_link;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text_input_email = view.findViewById(R.id.text_input_layout_email);
        text_input_password = view.findViewById(R.id.text_input_layout_password);
        button_login = view.findViewById(R.id.button_login);
        image_google_login = view.findViewById(R.id.image_google_login);
        textview_registration_link = view.findViewById(R.id.textview_registration_link);

        button_login.setOnClickListener(v -> {
            Util.LOG_MESSAGE_D(TAG,"TRYING LOGIN WITH EMAIL-PASSWORD");

            String email = text_input_email.getEditText().getText().toString().trim();
            String password = text_input_password.getEditText().getText().toString().trim();

            if(checkEmail(email) && checkPassword(password)) {
                Util.LOG_MESSAGE_D(TAG,"EMAIL/PASSWORD VALID");

                logInWith_Email_Password();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Util.LOG_MESSAGE_D(TAG,"STARTING ACTIVITY: MAIN_ACTIVITY");
            }
            else {
                Util.LOG_MESSAGE_D(TAG,"EMAIL/PASSWORD NOT VALID");
            }
        });

        image_google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.LOG_MESSAGE_D(TAG,"TRYING LOGIN WITH GOOGLE");

                logInWith_Google();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Util.LOG_MESSAGE_D(TAG,"STARTING ACTIVITY: MAIN_ACTIVITY");
            }
        });

        textview_registration_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.LOG_MESSAGE_D(TAG,"STARTING FRAGMENT: REGISTRATIONG_FRAGMENT");

                RegistrationFragment reg_fragment = new RegistrationFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, reg_fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    private void logInWith_Email_Password() {

        Util.LOG_MESSAGE_D(TAG,"LOGGED IN WITH EMAIL-PASSWORD");
    }

    private void logInWith_Google() {

        Util.LOG_MESSAGE_D(TAG,"LOGGED IN WITH GOOGLE");
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
