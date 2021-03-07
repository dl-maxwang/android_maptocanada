package com.zhen.maptocanada.ui.crs.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;

import com.zhen.maptocanada.BR;

public class CrsUserData extends BaseObservable {
    /*
    Crs Age
     */
    public ObservableField<String> crsAge = new ObservableField<>();

    public String getCrsAge() {
        return crsAge.get();
    }

    public int crsEngReadingClbLevel = 0;
    public int crsEngListeningClbLevel = 0;
    public int crsEngWritingClbLevel = 0;
    public int crsEngSpeakingClbLevel = 0;

    public void setCrsAge(String age) {
        if (String.valueOf(crsAge.get()).equalsIgnoreCase(age)) {
            return;
        }
        crsAge.set(age);
    }

    ObservableBoolean hasCanEdu = new ObservableBoolean(false);

    public boolean getHasCanEdu() {
        return hasCanEdu.get();
    }

    public void setHasCanEdu(boolean has) {
        hasCanEdu.set(has);

    }

    ObservableBoolean hasFrTestResult = new ObservableBoolean();

    public boolean getHasFrTestResult() {
        return hasFrTestResult.get();
    }

    public void setHasFrTestResult(boolean has) {
        hasFrTestResult.set(has);
    }

    public int crsFrReadingClbLevel = 0;
    public int crsFrListeningClbLevel = 0;
    public int crsFrWritingClbLevel = 0;
    public int crsFrSpeakingClbLevel = 0;

}
