package com.zhen.maptocanada.ui.crs.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.zhen.maptocanada.BR;

public class CrsUserData extends BaseObservable {
    /*
    Crs Age
     */
    public String crsAge = "";

    @Bindable
    public String getCrsAge() {
        return crsAge;
    }

    public int crsEngReadingClbLevel = 0;
    public int crsEngListeningClbLevel = 0;
    public int crsEngWritingClbLevel = 0;
    public int crsEngSpeakingClbLevel = 0;

    public void setCrsAge(String age) {
        if (String.valueOf(crsAge).equalsIgnoreCase(age)) {
            return;
        }
        crsAge = age;
        notifyPropertyChanged(BR.crsAge);
    }

    boolean hasCanEdu = false;

    @Bindable
    public boolean getHasCanEdu() {
        return hasCanEdu;
    }

    public void setHasCanEdu(boolean has) {
        this.hasCanEdu = has;
        notifyPropertyChanged(BR.hasCanEdu);
    }

    boolean hasFrTestResult = false;

    @Bindable
    public boolean getHasFrTestResult() {
        return hasFrTestResult;
    }

    public void setHasFrTestResult(boolean has) {
        hasFrTestResult = has;
        notifyPropertyChanged(BR.hasFrTestResult);
    }

    public int crsFrReadingClbLevel = 0;
    public int crsFrListeningClbLevel = 0;
    public int crsFrWritingClbLevel = 0;
    public int crsFrSpeakingClbLevel = 0;

    @Bindable
    public boolean isHasLmia() {
        return hasLmia;
    }

    public void setHasLmia(boolean hasLmia) {
        this.hasLmia = hasLmia;
        notifyPropertyChanged(BR.hasLmia);
    }

    public boolean hasLmia = false;

    public boolean hasPN = false;

    @Bindable
    public boolean isHasPN() {
        return hasPN;
    }

    public void setHasPN(boolean hasPN) {
        this.hasPN = hasPN;
        notifyPropertyChanged(BR.hasPN);
    }

    public boolean hasPRRelatives = false;

    @Bindable
    public boolean isHasPRRelatives() {
        return hasPRRelatives;
    }

    public void setHasPRRelatives(boolean hasPRRelatives) {
        this.hasPRRelatives = hasPRRelatives;
        notifyPropertyChanged(BR.hasPRRelatives);
    }

    @Bindable
    public boolean getSpouseComeAlong() {
        return spouseComeAlong;
    }

    public void setSpouseComeAlong(boolean spouseComeAlong) {
        this.spouseComeAlong = spouseComeAlong;
        notifyPropertyChanged(BR.spouseComeAlong);
    }

    public boolean spouseComeAlong = false;


    @Bindable
    public boolean getSpouseHasFrTestScore() {
        return spouseHasFrTestScore;
    }

    public void setSpouseHasFrTestScore(boolean spouseHasFrTestScore) {
        this.spouseHasFrTestScore = spouseHasFrTestScore;
        notifyPropertyChanged(BR.spouseHasFrTestScore);
    }

    public boolean spouseHasFrTestScore = false;


}
