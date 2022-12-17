package com.example.virtualwardrobe.screens.wardrobe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.Clothe;

import java.util.ArrayList;
import java.util.List;

public class WardrobeViewModel extends ViewModel {

    MutableLiveData<List<Clothe>> clothes;



    public WardrobeViewModel() {

        clothes = new MutableLiveData<>();
        clothes.setValue(new ArrayList<>());
    }



    public void save(){
        //TODO
    }

    public void addCloth(Clothe clothes)
    {
        this.clothes.getValue().add(clothes);
    }

    public boolean isCorrect()
    {
        return clothes.getValue().size() > 0;
    }

}