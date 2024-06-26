package com.github.neptuneluke.gaminghall;

import static com.github.neptuneluke.gaminghall.Util.LOG_MESSAGE_D;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private NestedScrollView nested_scrollview;
    private RecyclerView recyclerview_latest_games, recyclerview_latest_best_games;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nested_scrollview = view.findViewById(R.id.nested_scrollview);
        recyclerview_latest_games = view.findViewById(R.id.recyclerview_latest_games);
        recyclerview_latest_best_games = view.findViewById(R.id.recyclerview_latest_best_games);

        recyclerview_latest_games.setNestedScrollingEnabled(false);
        recyclerview_latest_best_games.setNestedScrollingEnabled(false);

        RecyclerViewLatestGames_Adapter adapter = new RecyclerViewLatestGames_Adapter(this.getContext());

        recyclerview_latest_games.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_latest_games.setAdapter(adapter);
        recyclerview_latest_best_games.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_latest_best_games.setAdapter(adapter);

        adapter.addItem("1");
        adapter.addItem("2");
        adapter.addItem("3");
        adapter.addItem("4");
        adapter.addItem("5");
        adapter.addItem("11");
        adapter.addItem("22");
        adapter.addItem("33");
        adapter.addItem("44");
        adapter.addItem("55");
        adapter.addItem("a");
        adapter.addItem("b");
        adapter.addItem("c");
        adapter.addItem("d");
        adapter.addItem("e");


        LOG_MESSAGE_D(TAG,"Inserted: " + adapter.getItemCount() + " items");
    }

}
