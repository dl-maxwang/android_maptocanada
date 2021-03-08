package com.zhen.maptocanada.ui.crs.crspages;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsPrRelativesBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsCanadianRelativesFragment extends BaseCrsFragment<ViewpagerCrsPrRelativesBinding> {
    public CrsCanadianRelativesFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_pr_relatives;
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
