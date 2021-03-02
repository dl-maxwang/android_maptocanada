package com.zhen.maptocanada.ui.search;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel  {
    ObservableField<String> searchTitle;

    public SearchViewModel(String searchTitle) {
        this.searchTitle = new ObservableField<>();
        this.searchTitle.set(searchTitle);
    }

    public String getSearchTitle() {
        return searchTitle.get();
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle.set(searchTitle);
    }
}