package com.zhen.maptocanada.ui.crs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CrsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Comprehensive Ranking System\n技术移民个人评分系统");
    }

    public LiveData<String> getText() {
        return mText;
    }
}