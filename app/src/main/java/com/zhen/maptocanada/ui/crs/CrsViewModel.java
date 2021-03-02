package com.zhen.maptocanada.ui.crs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CrsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is CRS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}