package com.zhen.maptocanada.ui.crs.crspages;

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
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
