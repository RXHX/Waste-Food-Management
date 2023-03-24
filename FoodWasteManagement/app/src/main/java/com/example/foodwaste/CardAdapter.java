package com.example.foodwaste;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    public String[] restaurantName = {"Subway","Mcdonalds"};
    public String[] details = {"Buy Subway","Buy Mcdonalds"};
    public  int [] images = {R.drawable.subway,R.drawable.mcdo};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_restaurants,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(restaurantName[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return restaurantName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;
        TextView Fake;  // remove it asap


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                   // Snackbar.make(v, "Click Detected on Item" + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    Intent intent = new Intent(itemView.getContext(), RestaurantMenu.class);
                    itemView.getContext().startActivity(intent);
                }
            });


}
    }
}
