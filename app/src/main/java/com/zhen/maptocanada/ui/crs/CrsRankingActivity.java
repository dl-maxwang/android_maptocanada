package com.zhen.maptocanada.ui.crs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ActivityCrsRankingBinding;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsRankingActivity extends AppCompatActivity {

    private CrsUserData userData = new CrsUserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCrsRankingBinding crsRankingBinding = DataBindingUtil.inflate(
                getLayoutInflater(), R.layout.activity_crs_ranking,
                null, false);
        setContentView(crsRankingBinding.getRoot());
    }
}