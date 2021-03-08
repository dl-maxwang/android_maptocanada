package com.zhen.maptocanada.ui.crs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ActivityCrsRankingBinding;
import com.zhen.maptocanada.ui.crs.data.CrsRankingVPAdatper;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;

public class CrsRankingActivity extends AppCompatActivity {

    // todo: write and restore sp

    private CrsUserData userData = new CrsUserData();
    private CrsRankingVPAdatper adapter;
    private ViewPager2 vpCrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCrsRankingBinding crsRankingBinding = DataBindingUtil.inflate(
                getLayoutInflater(), R.layout.activity_crs_ranking,
                null, false);
        setContentView(crsRankingBinding.getRoot());

        vpCrs = crsRankingBinding.vpCrsRanking;
        adapter = new CrsRankingVPAdatper(this, userData);
        vpCrs.setAdapter(adapter);
    }

    public void nextViewpage() {
        if (vpCrs == null) {
            return;
        }
        vpCrs.setCurrentItem(vpCrs.getCurrentItem() + 1);

    }
}