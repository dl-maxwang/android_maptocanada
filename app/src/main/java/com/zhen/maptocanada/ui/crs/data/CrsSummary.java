package com.zhen.maptocanada.ui.crs.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.zhen.maptocanada.data.crsdata.CrsDataModel;

import java.lang.reflect.Field;

public class CrsSummary extends BaseObservable {

    public boolean hasSpouse = false;
    public int ageScore = 0;

    public int totalScore = 0;

    public int lmiaScore;
    public int addtionalCanEduScore = 0;
    public int pnScore = 0;
    public int addtionalPrRelativeScore;
    public boolean hasTradeOccupation = false;
    public boolean hasPrRelatives;

    @Bindable
    public String getStrTotalScore() {
        return String.valueOf(totalScore);
    }

    @Bindable
    public String getStrAgeScore() {
        return String.valueOf(ageScore);
    }


    @Bindable
    public String getStrEduScore() {
        return String.valueOf(eduScore);
    }


    @Bindable
    public String getStrLanguageScore() {
        return String.valueOf(firstLanguageScore + secondLanguageScore);
    }

    @Bindable
    public String getStrCanadaWorkExp() {
        return String.valueOf(canadianWorkExpScore);
    }

    @Bindable
    public String getHighLanguageAndHighEdu() {
        return String.valueOf(goodLanguageAndEduScore);
    }

    @Bindable
    public String getCanWorkExpAndHighEdu() {
        return String.valueOf(canadianWorkExpAndHighEdu);
    }

    @Bindable
    public String getForeignWorkExpScore() {
        return String.valueOf(foreignWorkExpScore);
    }

    @Bindable
    public String getCanWorkExpAndForeignWorkExpScore() {
        return String.valueOf(foreignWorkExpWithCanWorkExp);
    }

    @Bindable
    public String getTradeOccupationScore() {
        return String.valueOf(hasTradeOccupation ? 50 : 0);
    }

    @Bindable
    public String getCanRelativeScore() {
        return String.valueOf(addtionalPrRelativeScore);
    }

    public String getExtraFrScore() {
        return String.valueOf(extraFrScore);
    }

    @Bindable
    public String getExtraCanadianEduScore(){
        return String.valueOf(addtionalCanEduScore);
    }

    @Bindable
    public String getLmiaScore() {
        return String.valueOf(lmiaScore);
    }

    @Bindable
    public String getPnScore(){
        return String.valueOf(pnScore);
    }



    public int extraFrScore;
    public int eduScore = 0;
    public int firstLanguageScore = 0;
    public int secondLanguageScore = 0;
    public int canadianWorkExpScore;
    public int spouseEduScore;
    public int spouseLanguageScore;
    public int goodLanguageAndEduScore;
    public int canadianWorkExpAndHighEdu;
    public int foreignWorkExpScore;
    public int foreignWorkExpWithCanWorkExp;

    public void reset() {
        Class<? extends CrsSummary> aClass = this.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields) {

            try {
                Object value = f.get(this);
                if (value instanceof Integer) {
                    f.set(this, 0);
                } else if (value instanceof Boolean) {
                    f.set(this, false);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
