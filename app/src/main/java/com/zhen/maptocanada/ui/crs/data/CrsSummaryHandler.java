package com.zhen.maptocanada.ui.crs.data;

import android.app.Activity;

import androidx.annotation.WorkerThread;

/**
 * fuck cyclomatic complexity
 */
public class CrsSummaryHandler {
    CrsUserData userData;

    public CrsSummaryHandler(CrsUserData userData) {
        this.userData = userData;
    }

    @WorkerThread
    public void cookFinalCrsSummary(Activity activity, CrsSummary summaryData) {
        int age = Integer.parseInt(userData.getCrsAge());

    }
}
