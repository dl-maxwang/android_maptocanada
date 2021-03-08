package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public abstract class BaseCrsFragment<T extends ViewDataBinding> extends Fragment {

    private CrsUserData userData;

    public CrsUserData getUserData() {
        return userData;
    }

    public T getBindedView() {
        return bindedView;
    }

    private T bindedView;

    public BaseCrsFragment(CrsUserData userData) {
        this.userData = userData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        bindedView = DataBindingUtil.inflate(inflater, getLayoutId(), null, false);
        doSomethingOnViewCreation(bindedView);
        return bindedView.getRoot();
    }

    protected void doSomethingOnViewCreation(T bindedView){};

    protected abstract int getLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setBindingData(userData);
    }

    protected abstract void setBindingData(CrsUserData userData);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
