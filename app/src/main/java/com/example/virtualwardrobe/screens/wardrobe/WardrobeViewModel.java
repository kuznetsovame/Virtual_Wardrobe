package com.example.virtualwardrobe.screens.wardrobe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.Clothe;

import java.util.ArrayList;
import java.util.List;

public class WardrobeViewModel extends ViewModel {

    MutableLiveData<List<Clothe>> clothes;

    private final MutableLiveData<String> mText;

    public WardrobeViewModel() {
        mText = new MutableLiveData<>();
        clothes = new MutableLiveData<>();

        clothes.setValue(new ArrayList<>());



        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
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