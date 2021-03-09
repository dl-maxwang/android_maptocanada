package com.zhen.maptocanada.ui.crs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.service.autofill.UserData;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.databinding.ActivityCrsRankingBinding;
import com.zhen.maptocanada.databinding.DialogCrsSummaryBinding;
import com.zhen.maptocanada.ui.crs.data.CrsRankingVPAdatper;
import com.zhen.maptocanada.ui.crs.data.CrsSummary;
import com.zhen.maptocanada.ui.crs.data.CrsSummaryHandler;
import com.zhen.maptocanada.ui.crs.data.CrsUserData;
import com.zhen.maptocanada.utility.WorkerPool;

public class CrsRankingActivity extends AppCompatActivity {

    // todo: write and restore sp

    private CrsUserData userData = new CrsUserData();
    private CrsRankingVPAdatper adapter;
    private ViewPager2 vpCrs;
    private DialogCrsSummaryBinding dialogBinding;
    private Dialog summaryDialog;
    private CrsSummary summaryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCrsRankingBinding crsRankingBinding = DataBindingUtil.inflate(
                getLayoutInflater(), R.layout.activity_crs_ranking,
                null, false);
        setContentView(crsRankingBinding.getRoot());
        setSummaryDialog();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpCrs = crsRankingBinding.vpCrsRanking;
        adapter = new CrsRankingVPAdatper(this, userData);
        vpCrs.setAdapter(adapter);
    }

    private void setSummaryDialog() {
        summaryData = new CrsSummary();
        dialogBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_crs_summary, null, false);
        summaryDialog = new Dialog(this);
        summaryDialog.setCancelable(false);
        summaryDialog.setCanceledOnTouchOutside(false);
        dialogBinding.setCrsSummary(summaryData);
        dialogBinding.ivCloseDialog.setOnClickListener(v -> {
            summaryDialog.dismiss();
        });
        dialogBinding.btnCloseDialog.setOnClickListener(v -> {
            summaryDialog.dismiss();
        });
        summaryDialog.setContentView(dialogBinding.getRoot());
    }

    public void nextViewpage() {
        if (vpCrs == null) {
            return;
        }
        vpCrs.setCurrentItem(vpCrs.getCurrentItem() + 1);
    }

    public void doCrsSummary() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage(getString(R.string.progress_summarizing));
        pd.show();
        WorkerPool.getInstance().execute1(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CrsSummaryHandler summaryHandler = new CrsSummaryHandler(userData);
            summaryHandler.cookFinalCrsSummary(CrsRankingActivity.this, summaryData);
            this.runOnUiThread(() -> {
                summaryDialog.show();
                pd.dismiss();
            });
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return true;
    }
}