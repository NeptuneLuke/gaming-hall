package com.github.neptuneluke.gaminghall.access;

import com.github.neptuneluke.gaminghall.R;
import com.google.android.material.textfield.TextInputLayout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
    }
}
