package com.github.neptuneluke.gaminghall;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewLatestGames_Adapter extends RecyclerView.Adapter<RecyclerViewLatestGames_Adapter.TestViewHolder> {

    private final Context context;
    private List<String> text_items = new ArrayList<>();
    private List<Drawable> image_items = new ArrayList<>();

    public RecyclerViewLatestGames_Adapter(Context context) {
        this.context = context;
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        ImageView imageview;

        TestViewHolder(View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textview_in_recyclerview_item); // Adjust ID as needed
            imageview = itemView.findViewById(R.id.imageview_in_recyclerview_item);
        }
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false); // Adjust layout as needed
        return new TestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        holder.textview.setText(text_items.get(position));
        // holder.imageView.setImageResource(R.drawable.cover_not_found);
        holder.imageview.setImageDrawable(image_items.get(position));
    }

    @Override
    public int getItemCount() {
        return text_items.size();
    }

    public void addItem(String newItem) {
        text_items.add(newItem);
        Drawable d = ContextCompat.getDrawable(context, R.drawable.cover_not_found); //this.context.getResources().getDrawable(R.drawable.cover_not_found);
        image_items.add(d);
        notifyItemInserted(text_items.size() - 1);
    }

}