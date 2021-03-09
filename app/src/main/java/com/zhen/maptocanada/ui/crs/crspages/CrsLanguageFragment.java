package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // english language
        getBindedView().spinChooseListeningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsEngListeningClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseReadingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsEngReadingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseWritingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsEngWritingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseSpeakingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsEngSpeakingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getBindedView().spinChooseFrListeningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsFrListeningClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrReadingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsFrReadingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrWritingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsFrWritingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrSpeakingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().crsFrSpeakingClbLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void setBindingData(CrsUserData userData) {
        getBindedView().setUserData(getUserData());
    }
}
