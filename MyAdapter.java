package com.example.recyclerview;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<item> itemList; // Change ClipData.Item to your custom Item class

    public MyAdapter(List<item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_complaint, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current item
        item item = itemList.get(position);

        // Bind the data to the views
        holder.titleText.setText(item.getTitle()); // Set the complaint title
        holder.descriptionText.setText(item.getDescription()); // Set the complaint description

        // Set an OnClickListener for the button
        holder.button.setOnClickListener(v -> {
            // Show a Toast when the button is clicked
            Toast.makeText(v.getContext(), "Action taken for: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        // Return the size of the item list
        return itemList.size();
    }

    // ViewHolder class to hold the views for each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;
        public TextView descriptionText;
        public Button button;

        // Constructor to initialize the views
        public ViewHolder(View itemView) {
            super(itemView);
            // Find the views by their IDs
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.description);
            button = itemView.findViewById(R.id.complaint);
        }
    }
}