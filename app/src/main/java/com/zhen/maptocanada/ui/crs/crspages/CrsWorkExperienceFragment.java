package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;

import androidx.annotation.Nullable;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsCanadianWorkExpBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsWorkExperienceFragment extends BaseCrsFragment<ViewpagerCrsCanadianWorkExpBinding> {
    public CrsWorkExperienceFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_canadian_work_exp;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void doSomethingOnViewCreation(ViewpagerCrsCanadianWorkExpBinding bindedView) {
        super.doSomethingOnViewCreation(bindedView);
        // make link clickable
        bindedView.tvCrsCanadianWorkExpDesc.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
