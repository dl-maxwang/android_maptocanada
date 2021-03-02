package com.zhen.maptocanada.ui.search;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        searchViewModel = new SearchViewModel("hello search");
        FragmentSearchBinding searchBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_search, container, false);
        // set binding view model
        searchBinding.setSearchModel(searchViewModel);
        searchViewModel.setSearchTitle("This is Search Fragment");
        return searchBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}