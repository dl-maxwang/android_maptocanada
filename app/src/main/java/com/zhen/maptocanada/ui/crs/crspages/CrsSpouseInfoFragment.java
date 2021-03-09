package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsSpouseInfoBinding;
import com.zhen.maptocanada.ui.crs.CrsRankingActivity;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

import java.util.Objects;

public class CrsSpouseInfoFragment extends BaseCrsFragment<ViewpagerCrsSpouseInfoBinding> implements View.OnClickListener {
    public CrsSpouseInfoFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBindedView().btnCrsCalculateScore.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_crs_spouse_info;
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_crs_calculate_score:
                ((CrsRankingActivity) requireActivity()).doCrsSummary();
                break;
        }
    }
}
