package com.example.virtualwardrobe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter {
    Context context;
    List<User> list;

    class MyHolderView extends RecyclerView.ViewHolder {

        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.login);
            button = itemView.findViewById(R.id.tv_add);
            status = itemView.findViewById(R.id.user_status);
            //image = itemView.findViewById(R.id.profile_image);
        }

        EditText name;
        EditText status;
        Button button;
    }

    public UsersAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.friend_card, parent, false);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolderView view = (MyHolderView) holder;

        // view.photo(list.get(position).);
        view.name.setText(list.get(position).username);
        view.status.setText(list.get(position).password);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

