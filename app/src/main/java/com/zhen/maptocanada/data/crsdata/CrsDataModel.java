package com.zhen.maptocanada.data.crsdata;

import com.zhen.maptocanada.data.DataKVBean;

import java.util.LinkedHashMap;
import java.util.Map;

public class CrsDataModel {

    private LinkedHashMap<String, RankingItem> rankingItems = new LinkedHashMap<>();

    public CrsDataModel() {

    }

    public void init(){
        RankingItem crsAge = new RankingItem();
        
        rankingItems.put(DataKVBean.KEY_CRS_AGE, new RankingItem())
    }

    static class RankingItem{
        /**
         * 评分项目
         */
        public String tag;
        /**
         * 评分项目标题
         */
        public String title;

        /**
         * 评分项目描述
         */
        public String description;
        /**
         * 选项与分值
         */
        Map<String, Integer> optionsScorePair = new LinkedHashMap<>();
    }
}
