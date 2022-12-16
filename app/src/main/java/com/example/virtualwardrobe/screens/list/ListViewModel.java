package com.example.virtualwardrobe.screens.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.Clothe;

import java.util.List;

public class ListViewModel extends ViewModel {
    LiveData<List<Clothe>> clothes_list = new LiveData<List<Clothe>>() {
    };
    public ListViewModel() {

    }
}