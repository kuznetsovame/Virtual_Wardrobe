package com.example.virtualwardrobe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.list.List_Fragment;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>   {

    OnClick onClick;

    private final List<User> list;

    public UsersAdapter(List<User> list,OnClick clickInterface) {
        this.list = list;
        this.onClick = clickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new RecyclerView.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.friend_card, parent, false))
        {};
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TextView status = holder.itemView.findViewById(R.id.user_status);
        TextView name = holder.itemView.findViewById(R.id.user_name);
        name.setText(list.get(position).username);
        status.setText(list.get(position).mail);
        holder.itemView.setOnClickListener(view -> onClick.onClickUserCard(list.get(position)));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnClick{
        void onClickUserCard(User user);
        void onClickAddUser(User user);
    }
}

