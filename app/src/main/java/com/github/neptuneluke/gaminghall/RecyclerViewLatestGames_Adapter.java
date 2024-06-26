package com.github.neptuneluke.gaminghall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewLatestGames_Adapter extends RecyclerView.Adapter<RecyclerViewLatestGames_Adapter.StringViewHolder> {

    private final Context context;
    private final List<String> items = new ArrayList<>();

    public RecyclerViewLatestGames_Adapter(Context context) {
        this.context = context;
    }

    public class StringViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        StringViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_in_recyclerview_item); // Adjust ID as needed
        }
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false); // Adjust layout as needed
        return new StringViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(String newItem) {
        items.add(newItem);
        notifyItemInserted(items.size() - 1);
    }
}