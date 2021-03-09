package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;

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
        getBindedView().spinCanWorkYears.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().canWorkExp = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinForeignWorkExp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().foreignWorkExp = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getBindedView().spinLmiaJobType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().lmiaJobType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
