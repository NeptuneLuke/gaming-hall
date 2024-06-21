package com.github.neptuneluke.gaminghall.access;

import com.github.neptuneluke.gaminghall.R;
import com.google.android.material.textfield.TextInputLayout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.getSimpleName();

    private TextInputLayout text_input_email, text_input_password;
    private Button button_login;
    private ImageView button_google_login;
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
        button_google_login = view.findViewById(R.id.button_google_login);
        textview_registration_link = view.findViewById(R.id.textview_registration_link);
    }
}
