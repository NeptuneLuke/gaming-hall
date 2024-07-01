package com.github.neptuneluke.gaminghall;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private ImageView image_profile, image_visibility_password;
    private TextView textview_username, textview_email, textview_password, textview_number_favorite, textview_number_review;
    private Spinner spinner_language;
    private Button button_language, button_logout, button_delete_account;

    public static final String[] languages = {"Select language", "English", "Italiano"};


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image_profile = view.findViewById(R.id.image_profile);
        textview_username = view.findViewById(R.id.textview_username);

        textview_number_favorite = view.findViewById(R.id.textview_number_favorite);
        textview_number_review = view.findViewById(R.id.textview_number_review);

        textview_email = view.findViewById(R.id.textview_email);
        textview_password = view.findViewById(R.id.textview_password);
        image_visibility_password = view.findViewById(R.id.image_visibility);

        spinner_language = view.findViewById(R.id.spinner_language);
        button_language = view.findViewById(R.id.button_language);
        button_logout = view.findViewById(R.id.button_logout);
        button_delete_account = view.findViewById(R.id.button_delete_account);

        String plain_password = textview_password.getText().toString(); // save the plain password

        // set a string of hidden chars
        int password_length = plain_password.length();
        String hidden_password = "";
        for(int i=0; i < password_length; ++i) {
            hidden_password += "*";
        }
        final String final_hidden_password = hidden_password;   // textview text needs to be final

        image_visibility_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textview_password.getText().toString().equals(final_hidden_password)) {
                    textview_password.setText(plain_password);
                    image_visibility_password.setImageResource(R.drawable.ic_visibility_off_gray);
                }
                else {
                    textview_password.setText(final_hidden_password);
                    image_visibility_password.setImageResource(R.drawable.ic_visibility_on_gray);
                }
            }
        });
    }
}
