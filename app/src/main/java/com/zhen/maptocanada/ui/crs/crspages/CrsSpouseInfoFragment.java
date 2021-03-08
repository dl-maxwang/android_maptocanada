package com.zhen.maptocanada.ui.crs.crspages;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsSpouseInfoBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsSpouseInfoFragment extends BaseCrsFragment<ViewpagerCrsSpouseInfoBinding> {
    public CrsSpouseInfoFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_spouse_info;
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
