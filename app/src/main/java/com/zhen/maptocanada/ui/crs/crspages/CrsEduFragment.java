package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsEduBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsEduFragment extends BaseCrsFragment<ViewpagerCrsEduBinding> {
    public CrsEduFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_edu;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
