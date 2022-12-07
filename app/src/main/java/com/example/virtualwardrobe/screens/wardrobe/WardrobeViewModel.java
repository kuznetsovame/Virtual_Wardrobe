package com.example.virtualwardrobe.screens.wardrobe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.Clothes;

import java.util.ArrayList;
import java.util.List;

public class WardrobeViewModel extends ViewModel {

    MutableLiveData<List<Clothes>> clothes;

    private final MutableLiveData<String> mText;

    public WardrobeViewModel() {
        mText = new MutableLiveData<>();
        clothes = new MutableLiveData<>();

        clothes.setValue(new ArrayList<>());
        for(int i =0; i< 5; i++)
         clothes.getValue().add(new Clothes("name" +i, "" ,"desasdasdasdasdasdasdasdas" + i, "2"));


        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void save(){
        //TODO
    }

    public void addCloth(Clothes clothes)
    {
        this.clothes.getValue().add(clothes);
    }

    public boolean isCorrect()
    {
        return clothes.getValue().size() > 0;
    }

}