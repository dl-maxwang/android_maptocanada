package com.zhen.maptocanada.ui.crs.crspages;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

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

        // fr levels
        getBindedView().spinChooseFrListeningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseFrListeningLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrReadingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseFrReadingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrWritingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseFrWritingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseFrSpeakingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseFrSpeakingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // eng levels
        getBindedView().spinChooseListeningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseEngListeningLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseReadingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseEngReadingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseWritingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseEngWritingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getBindedView().spinChooseSpeakingLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseEngSpeakingLevel = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // educational level
        getBindedView().spinCrsSpouseEdu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseEducationLevel = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // spouse canada work exp
        getBindedView().spinCrsSpouseCanExp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getUserData().spouseCanadaWorkExp = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
