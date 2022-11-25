package com.example.virtualwardrobe.screens.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.Clothes;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    LiveData<List<Clothes>> clothes_list = new LiveData<List<Clothes>>() {
    };
    public ListViewModel() {

    }
}