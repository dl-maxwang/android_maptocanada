package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.Nullable;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsAgeBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsAgeFragment extends BaseCrsFragment<ViewpagerCrsAgeBinding> {
    public CrsAgeFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBindedView().etCrsAge.setImeOptions(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_age;
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
