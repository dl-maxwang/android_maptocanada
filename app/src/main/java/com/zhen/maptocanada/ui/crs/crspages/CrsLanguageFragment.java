package com.zhen.maptocanada.ui.crs.crspages;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsLanguageBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsLanguageFragment extends BaseCrsFragment<ViewpagerCrsLanguageBinding> {
    public CrsLanguageFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_language;
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
