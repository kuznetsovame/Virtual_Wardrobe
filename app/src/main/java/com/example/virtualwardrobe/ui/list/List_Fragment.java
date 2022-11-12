package com.example.virtualwardrobe.ui.list;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.adapters.ClothesAdapter;
import com.example.virtualwardrobe.model.Clothes;

import java.util.List;

public class List_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private ListViewModel mViewModel;
    private List<Clothes> list;

    public static List_Fragment newInstance() {
        return new List_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_list_, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ClothesAdapter(getContext(), list));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        // TODO: Use the ViewModel
    }

}