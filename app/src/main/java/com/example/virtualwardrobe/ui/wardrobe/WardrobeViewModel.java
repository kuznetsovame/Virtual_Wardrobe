package com.example.virtualwardrobe.ui.wardrobe;

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

        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void save(){
        //TODO
    }

    public boolean isCorrect()
    {
        return clothes.getValue().size() > 0;
    }

}