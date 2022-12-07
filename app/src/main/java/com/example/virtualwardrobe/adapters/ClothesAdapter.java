package com.example.virtualwardrobe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.model.Clothes;

import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter {

    List<Clothes> list;

    class MyHolderView extends RecyclerView.ViewHolder {
        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            descriptionText = itemView.findViewById(R.id.text_descrp);
            photo = itemView.findViewById(R.id.picture);
            type = itemView.findViewById(R.id.type);
        }

        TextView name;
        TextView type;
        TextView descriptionText;
        ImageView photo;
    }

    public ClothesAdapter(  List<Clothes> list) {

        this.list = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothes_card, parent,false);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolderView view = (MyHolderView) holder;
        // view.photo(list.get(position).);
        view.name.setText(list.get(position).name);
        view.descriptionText.setText(list.get(position).description);
        view.type.setText(list.get(position).category);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
