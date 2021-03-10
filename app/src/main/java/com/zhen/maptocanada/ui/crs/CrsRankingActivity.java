package com.zhen.maptocanada.ui.crs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.service.autofill.UserData;

import com.google.android.material.snackbar.Snackbar;
import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.crsdata.CrsDataModel;
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
    private ActivityCrsRankingBinding crsRankingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crsRankingBinding = DataBindingUtil.inflate(
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
//        dialogBinding.setCrsSummary(summaryData);
        dialogBinding.ivCloseDialog.setOnClickListener(v -> {
            summaryDialog.dismiss();
        });
        dialogBinding.btnAnalysisYourScore.setOnClickListener(v -> {
            summaryDialog.dismiss();
            Snackbar snackbar = Snackbar.make(crsRankingBinding.getRoot(), "点什么，还没做呢", Snackbar.LENGTH_SHORT);
            snackbar.show();
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
            CrsDataModel scoreLookup = new CrsDataModel(CrsRankingActivity.this);
            scoreLookup.init();
            CrsSummaryHandler summaryHandler = new CrsSummaryHandler(userData, scoreLookup);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            summaryHandler.cookFinalCrsSummary(CrsRankingActivity.this, summaryData);
            dialogBinding.setCrsSummary(summaryData);
            this.runOnUiThread(() -> {
                summaryDialog.show();
                pd.dismiss();
            });
        });


    }

    @Override
    public void onBackPressed() {
        if (summaryDialog.isShowing()) {
            summaryDialog.dismiss();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return true;
    }
}