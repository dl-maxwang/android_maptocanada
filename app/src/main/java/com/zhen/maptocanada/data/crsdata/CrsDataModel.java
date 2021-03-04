package com.zhen.maptocanada.data.crsdata;

import java.util.LinkedHashMap;
import java.util.Map;

public class CrsDataModel {

    private LinkedHashMap<String, RankingItem> rankingItems = new LinkedHashMap<>();

    public CrsDataModel() {

    }

    public void init(){

    }

    static class RankingItem{
        public String tag;
        public String title;
        public int score = 0;
        Map<String, Integer> optionsScorePair = new LinkedHashMap<>();
    }
}
