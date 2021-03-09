package com.zhen.maptocanada.ui.crs.data;

import androidx.databinding.BaseObservable;

import com.zhen.maptocanada.data.crsdata.CrsDataModel;

public class CrsSummary extends BaseObservable {

    public Integer userAge = 0;
    public CrsDataModel.EducationalLevel educationalLevel;
    public CrsDataModel.EducationalLevel spouseEducationalLevel;
    public boolean hasSpouse = false;
}
