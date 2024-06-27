package com.github.neptuneluke.gaminghall;

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
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private ImageView image_profile;
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
        textview_email = view.findViewById(R.id.textview_email);
        textview_password = view.findViewById(R.id.textview_password);
        textview_number_favorite = view.findViewById(R.id.textview_number_favorite);
        textview_number_review = view.findViewById(R.id.textview_number_review);
        spinner_language = view.findViewById(R.id.spinner_language);
        button_language = view.findViewById(R.id.button_language);
        button_logout = view.findViewById(R.id.button_logout);
        button_delete_account = view.findViewById(R.id.button_delete_account);
    }
}
