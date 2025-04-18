package com.example.navshowcase.ui.scifi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SciFiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SciFiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}