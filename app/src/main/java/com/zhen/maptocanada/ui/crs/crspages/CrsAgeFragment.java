package com.zhen.maptocanada.ui.crs.crspages;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ViewpagerCrsAgeBinding;
import com.zhen.maptocanada.ui.crs.CrsRankingActivity;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsAgeFragment extends BaseCrsFragment<ViewpagerCrsAgeBinding> {
    public CrsAgeFragment(CrsUserData userData) {
        super(userData);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void doSomethingOnViewCreation(ViewpagerCrsAgeBinding bindedView) {
        super.doSomethingOnViewCreation(bindedView);
    }

    @Override
    public void onResume() {
        super.onResume();
        getBindedView().etCrsAge.post(() -> {
            getBindedView().etCrsAge.requestFocus();
            getBindedView().etCrsAge.setOnEditorActionListener((v, id, e) -> {
                Toast.makeText(CrsAgeFragment.this.getContext(), "get the ime action!", Toast.LENGTH_LONG).show();
                Log.d("Test EditTest", "doSomethingOnViewCreationg: " + id);
                if (id == EditorInfo.IME_ACTION_NEXT) {
                    // switch to next fragment
                    ((CrsRankingActivity) getActivity()).nextViewpage();
                }
                return true;
            });
        });
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
