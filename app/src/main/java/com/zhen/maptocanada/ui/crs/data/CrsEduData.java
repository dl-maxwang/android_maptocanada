package com.zhen.maptocanada.ui.crs.data;

import androidx.databinding.ObservableBoolean;

public class CrsEduData {
    ObservableBoolean hasCanEdu = new ObservableBoolean(false);

    public boolean getHasCanEdu() {
        return hasCanEdu.get();
    }

    public void setHasCanEdu(boolean has) {
        hasCanEdu.set(has);
    }
}
