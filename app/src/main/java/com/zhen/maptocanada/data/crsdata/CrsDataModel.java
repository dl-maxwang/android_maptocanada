package com.zhen.maptocanada.data.crsdata;

import android.content.Context;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.Consts;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CrsDataModel {

    private final Context context;
    private LinkedHashMap<String, RankingItem> rankingItems = new LinkedHashMap<>();

    /**
     * First Language Score
     * language level, score if single, score if with spouse
     */
    public LinkedHashMap<Integer, Integer[]> FirstLanguageTable = new LinkedHashMap<>();
    public LinkedHashMap<Integer, Integer[]> SecondaryLanguageTable = new LinkedHashMap<>();
    public LinkedHashMap<Integer, Integer[]> CanadianWorkExpTable = new LinkedHashMap<>();
    public LinkedHashMap<Integer, Integer[]> AgeLookupTable = new LinkedHashMap<>();
    public LinkedHashMap<TransferableSkillPair, Integer[]> TransferableSkillLookupTable = new LinkedHashMap<>();


    public CrsDataModel(Context context) {
        this.context = context;
    }

    public void init() {
        // AGE
        RankingItem crsAgeItem = cookAgeRankingItem();
        RankingItem crsEduItem = cookEducationItem();
        rankingItems.put(Consts.KEY_CRS_AGE, crsAgeItem);
        rankingItems.put(Consts.KEY_CRS_EDU, crsEduItem);
        rankingItems.put(Consts.KEY_LANGUAGE_TEST1_LISTENING, cookLanguage1ListeningItem());
        rankingItems.put(Consts.KEY_LANGUAGE_TEST1_READING, cookLanguage1ReadingItem());
        rankingItems.put(Consts.KEY_LANGUAGE_TEST1_SPEAKING, cookLanguage1SpeakingItem());
        rankingItems.put(Consts.KEY_LANGUAGE_TEST1_WRITING, cookLanguage1WritingItem());
        rankingItems.put(Consts.KEY_CRS_CANADIAN_WORK_EXP, cookCanadianWorkExpItem());
        rankingItems.put(Consts.KEY_CRS_PARTENER_EDU, cookingSpouseEduItem());
        rankingItems.put(Consts.KEY_CRS_FR_LISTENING, cookFrLanguageListeningItem());
        rankingItems.put(Consts.KEY_CRS_FR_READING, cookFrLanguageReadingItem());
        rankingItems.put(Consts.KEY_CRS_FR_WRITING, cookFrLanguageWritingItem());
        rankingItems.put(Consts.KEY_CRS_FR_SPEAKING, cookFrLanguageSpeakingItem());

        // first language score lookup table
        FirstLanguageTable.put(3, new Integer[]{0, 0});
        FirstLanguageTable.put(4, new Integer[]{6, 6});
        FirstLanguageTable.put(5, new Integer[]{6, 6});
        FirstLanguageTable.put(6, new Integer[]{8, 9});
        FirstLanguageTable.put(7, new Integer[]{16, 17});
        FirstLanguageTable.put(8, new Integer[]{22, 23});
        FirstLanguageTable.put(9, new Integer[]{29, 31});
        FirstLanguageTable.put(10, new Integer[]{32, 34});

        // secondary language score lookup table
        SecondaryLanguageTable.put(4, new Integer[]{0, 0});
        SecondaryLanguageTable.put(5, new Integer[]{1, 1});
        SecondaryLanguageTable.put(6, new Integer[]{1, 1});
        SecondaryLanguageTable.put(7, new Integer[]{3, 3});
        SecondaryLanguageTable.put(8, new Integer[]{3, 3});
        SecondaryLanguageTable.put(9, new Integer[]{6, 6});

        // Canada Work Exp
        CanadianWorkExpTable.put(0, new Integer[]{0, 0});
        CanadianWorkExpTable.put(1, new Integer[]{35, 40});
        CanadianWorkExpTable.put(2, new Integer[]{46, 53});
        CanadianWorkExpTable.put(3, new Integer[]{56, 64});
        CanadianWorkExpTable.put(4, new Integer[]{63, 72});
        CanadianWorkExpTable.put(5, new Integer[]{70, 80});


    }

    private RankingItem cookFrLanguageReadingItem() {
        return null;
    }

    private RankingItem cookFrLanguageWritingItem() {
        return null;
    }

    private RankingItem cookFrLanguageSpeakingItem() {
        return null;
    }

    private RankingItem cookingSpouseEduItem() {
        RankingItem crsPartnerEdu = new RankingItem();
        crsPartnerEdu.title = getString(R.string.crs_partener_edu_title);
        return crsPartnerEdu;
    }

    private RankingItem cookCanadianWorkExpItem() {
        RankingItem crsCanadianExp = new RankingItem();
        crsCanadianExp.title = getString(R.string.crs_canadian_exp_title);
        crsCanadianExp.description = getString(R.string.crs_canadian_exp_desc);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_less_one_year), 0, 0);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_one_year), 35, 40);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_two_year), 46, 53);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_three_year), 56, 64);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_four_year), 63, 72);
        crsCanadianExp.put(getString(R.string.crs_candian_exp_five_more_year), 70, 80);
        return crsCanadianExp;
    }

    private RankingItem cookFrLanguageListeningItem() {
        RankingItem crsFrListening = new RankingItem();
        crsFrListening.tag = "CRS_FRENCH_LISTENING";

        return crsFrListening;
    }

    private RankingItem cookLanguage1ListeningItem() {
        RankingItem crsLanguage1 = new RankingItem();
        crsLanguage1.tag = "CRS_LANGUAGE1_LISTENING";
        crsLanguage1.title = getString(R.string.crs_language1_listening_title);
        crsLanguage1.description = getString(R.string.crs_language1_listening_description);
        crsLanguage1.put(getString(R.string.crs_language1_listening_less_clb4), 0, 0);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb5), 6, 6);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb6), 8, 9);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb7), 16, 17);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb8), 22, 23);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb9), 29, 31);
        crsLanguage1.put(getString(R.string.crs_language1_listening_clb10), 32, 34);
        return crsLanguage1;
    }

    private RankingItem cookLanguage1ReadingItem() {
        RankingItem crsLan1Reading = new RankingItem();
        crsLan1Reading.tag = "CRS_LANGUAGE1_READING";
        crsLan1Reading.title = getString(R.string.crs_language1_reading_title);
        crsLan1Reading.description = getString(R.string.crs_language1_reading_description);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_less_clb4), 0, 0);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb5), 6, 6);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb6), 8, 9);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb7), 16, 17);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb8), 22, 23);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb9), 29, 31);
        crsLan1Reading.put(getString(R.string.crs_language1_reading_clb10), 32, 34);
        return crsLan1Reading;
    }

    private RankingItem cookLanguage1SpeakingItem() {
        RankingItem crsLan1Speaking = new RankingItem();
        crsLan1Speaking.tag = "CRS_LANGUAGE1_SPEAKING";
        crsLan1Speaking.title = getString(R.string.crs_language1_speaking_title);
        crsLan1Speaking.description = getString(R.string.crs_language1_speaking_description);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_less_clb4), 0, 0);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb5), 6, 6);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb6), 8, 9);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb7), 16, 17);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb8), 22, 23);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb9), 29, 31);
        crsLan1Speaking.put(getString(R.string.crs_language1_speaking_clb10), 32, 34);
        return crsLan1Speaking;
    }

    private RankingItem cookLanguage1WritingItem() {
        RankingItem crsLan1Writing = new RankingItem();
        crsLan1Writing.tag = "CRS_LANGUAGE1_WRITING";
        crsLan1Writing.title = getString(R.string.crs_language1_writing_title);
        crsLan1Writing.description = getString(R.string.crs_language1_writing_description);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_less_clb4), 0, 0);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb5), 6, 6);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb6), 8, 9);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb7), 16, 17);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb8), 22, 23);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb9), 29, 31);
        crsLan1Writing.put(getString(R.string.crs_language1_writing_clb10), 32, 34);
        return crsLan1Writing;
    }

    private RankingItem cookEducationItem() {
        RankingItem crsEdu = new RankingItem();
        crsEdu.tag = "CRS_EDU";
        crsEdu.title = getString(R.string.crs_edu_title);
        crsEdu.description = getString(R.string.crs_edu_description);
        crsEdu.optionsScorePair.put(getString(R.string.crs_edu_item_less_than_highschool), new Integer[]{0, 0});
        crsEdu.put(getString(R.string.crs_edu_item_highschool), 28, 30);
        crsEdu.put(getString(R.string.crs_edu_item_one_year_post_secondary), 84, 90);
        crsEdu.put(getString(R.string.crs_edu_item_two_year_post_secondary), 91, 98);
        crsEdu.put(getString(R.string.crs_edu_item_three_year_post_secondary), 112, 120);
        crsEdu.put(getString(R.string.crs_edu_item_two_more_cert), 119, 128);
        crsEdu.put(getString(R.string.crs_edu_item_master), 126, 135);
        crsEdu.put(getString(R.string.crs_edu_item_phd), 140, 150);
        return crsEdu;
    }

    private RankingItem cookAgeRankingItem() {
        RankingItem crsAge = new RankingItem();
        crsAge.tag = "CRS_AGE";
        crsAge.title = getString(R.string.crs_age_title);
        crsAge.description = getString(R.string.crs_age_description);
        crsAge.optionsScorePair.put("0-17", new Integer[]{0, 0});
        crsAge.optionsScorePair.put("18", new Integer[]{90, 99});
        crsAge.optionsScorePair.put("19", new Integer[]{95, 105});
        crsAge.optionsScorePair.put("20-29", new Integer[]{100, 110});
        crsAge.optionsScorePair.put("30", new Integer[]{95, 105});
        crsAge.optionsScorePair.put("31", new Integer[]{90, 99});
        crsAge.optionsScorePair.put("32", new Integer[]{85, 94});
        crsAge.optionsScorePair.put("33", new Integer[]{80, 88});
        crsAge.optionsScorePair.put("34", new Integer[]{75, 83});
        crsAge.optionsScorePair.put("35", new Integer[]{70, 77});
        crsAge.optionsScorePair.put("36", new Integer[]{65, 72});
        crsAge.optionsScorePair.put("37", new Integer[]{60, 66});
        crsAge.optionsScorePair.put("38", new Integer[]{55, 61});
        crsAge.optionsScorePair.put("39", new Integer[]{50, 55});
        crsAge.optionsScorePair.put("40", new Integer[]{45, 50});
        crsAge.optionsScorePair.put("41", new Integer[]{35, 39});
        crsAge.optionsScorePair.put("42", new Integer[]{25, 28});
        crsAge.optionsScorePair.put("43", new Integer[]{15, 17});
        crsAge.optionsScorePair.put("44", new Integer[]{5, 6});
        crsAge.optionsScorePair.put(">=45", new Integer[]{0, 0});
        return crsAge;
    }

    private String getString(int id) {
        return context.getResources().getString(id);
    }

    static class RankingItem {

        public String group;
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
         * option and score, score[0] without spouse, score[1] with spouse
         */
        Map<String, Integer[]> optionsScorePair = new LinkedHashMap<>();

        public void put(String optionName, int scoreSingle, int scoreSpouse) {
            optionsScorePair.put(optionName, new Integer[]{scoreSingle, scoreSpouse});
        }


    }

    public enum EducationalLevel {
        LESS_THAN_SECONDARY(0),
        SECONDARY(1),
        ONE_YEAR_DIPLOMA(2),
        TWO_YEAR_DIPLOMA(3),
        BACHELOR_DIPLOMA(4),
        TWO_CERTIFICATES(5),
        MASTER_DEGREE(6),
        PHD(7);

        private final int value;

        EducationalLevel(int level) {
            this.value = level;
        }

        public int getValue() {
            return value;
        }
    }

    public enum LanguageLevel {
        CLB_LESS4(3),
        CLB4(4),
        CLB5(5),
        CLB6(6),
        CLB7(7),
        CLB8(8),
        CLB9(9),
        CLB10_OR_GREATER(10);

        private final int value;

        LanguageLevel(int level) {
            this.value = level;
        }

        public int getValue() {
            return value;
        }
    }

    public static class TransferableSkillPair{
        public int languageLevel = 0;
        public int educationalLevel = 0;

        public TransferableSkillPair() {
        }

        public TransferableSkillPair(int languageLevel, int educationalLevel) {
            this.languageLevel = languageLevel;
            this.educationalLevel = educationalLevel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TransferableSkillPair that = (TransferableSkillPair) o;
            return languageLevel == that.languageLevel &&
                    educationalLevel == that.educationalLevel;
        }

        @Override
        public int hashCode() {
            return Objects.hash(languageLevel, educationalLevel);
        }
    }



}
