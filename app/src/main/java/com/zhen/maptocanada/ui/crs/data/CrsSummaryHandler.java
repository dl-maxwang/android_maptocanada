package com.zhen.maptocanada.ui.crs.data;

import android.app.Activity;

import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;

import com.zhen.maptocanada.data.Consts;
import com.zhen.maptocanada.data.crsdata.CrsDataModel;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * fuck cyclomatic complexity
 */
public class CrsSummaryHandler {
    private final CrsDataModel scoreLookup;
    CrsUserData userData;
    private Map<String, Integer> finalScoreItem = new LinkedHashMap<>();
    private int engAsFirstLanguageClbLevel;
    private int frAsFirstLanguageClbLevel;
    private CrsSummary summaryData;

    public CrsSummaryHandler(CrsUserData userData, CrsDataModel scoreLookup) {
        this.userData = userData;
        this.scoreLookup = scoreLookup;
    }

    @WorkerThread
    public void cookFinalCrsSummary(Activity activity, CrsSummary summaryData) {
        this.summaryData = summaryData;
        summaryData.reset();
        int age = userData.getCrsAge().equals("") ? 0 : Integer.parseInt(userData.getCrsAge());
        int educationLevel = userData.basicEducationalLevel;
        int canadaEducationLevel = userData.canadaEducationalLevel;

        int foreignWorkExp = userData.foreignWorkExp;

        int engListeningLevel = userData.crsEngListeningClbLevel;
        int engReadingLevel = userData.crsEngReadingClbLevel;
        int engWritingLevel = userData.crsEngWritingClbLevel;
        int engSpeakingLevel = userData.crsEngSpeakingClbLevel;

        int frListeningLevel = userData.crsFrListeningClbLevel;
        int frReadingLevel = userData.crsFrReadingClbLevel;
        int frWritingLevel = userData.crsFrWritingClbLevel;
        int frSpeakingLevel = userData.crsFrSpeakingClbLevel;

        int canadaWorkExp = userData.canWorkExp;

        boolean withSpouse = userData.spouseComeAlong;

        int spouseEduLevel = userData.spouseEducationLevel;

        int spouseEngListeningLevel = userData.spouseEngListeningLevel;
        int spouseEngReadingLevel = userData.spouseEngReadingLevel;
        int spouseEngWritingLevel = userData.spouseEngWritingLevel;
        int spouseEngSpeakingLevel = userData.spouseEngSpeakingLevel;

        int spouseFrListeningLevel = userData.spouseFrListeningLevel;
        int spouseFrReadingLevel = userData.spouseFrReadingLevel;
        int spouseFrWritingLevel = userData.spouseFrWritingLevel;
        int spouseFrSpeakingLevel = userData.spouseFrSpeakingLevel;

        boolean hasProvincialNomination = userData.hasPN;

        Integer[] ageScores = getAgeScore(age);

        finalScoreItem.put(Consts.KEY_CRS_AGE, ageScores[getSpouseIdx()]);
        summaryData.ageScore = finalScoreItem.get(Consts.KEY_CRS_AGE);
        summaryData.totalScore += summaryData.ageScore;

        Integer[] educationScore = scoreLookup.EducationLookupTable.get(userData.basicEducationalLevel);

        finalScoreItem.put(Consts.KEY_CRS_EDU, educationScore[getSpouseIdx()]);

        summaryData.eduScore = educationScore[getSpouseIdx()];
        summaryData.totalScore += educationScore[getSpouseIdx()];

        int EngAsFirstLanguageScore = getEngAsFirstLanguageScore();
        int FrAsFirstLanguageScore = getFrAsFirstLanguageScore();

        finalScoreItem.put(Consts.KEY_CRS_FIRST_LANGUAGE_SCORE,
                Math.max(EngAsFirstLanguageScore, FrAsFirstLanguageScore));

        summaryData.firstLanguageScore = finalScoreItem.get(Consts.KEY_CRS_FIRST_LANGUAGE_SCORE);
        summaryData.totalScore += summaryData.firstLanguageScore;

        int secondaryLanguageScore = EngAsFirstLanguageScore > FrAsFirstLanguageScore ?
                getFrAsSecondaryLanguageScore() : getEngAsSecondaryLanguageScore();

        finalScoreItem.put(Consts.KEY_CRS_SECONDARY_LANGUAGE_SCORE, secondaryLanguageScore);
        summaryData.secondLanguageScore = secondaryLanguageScore;
        summaryData.totalScore += secondaryLanguageScore;

        int canadianWorkExperienceScore = getCanadianWorkExperienceScore();
        finalScoreItem.put(Consts.KEY_CRS_CANADIAN_WORK_EXP, canadianWorkExperienceScore);
        summaryData.canadianWorkExpScore = canadianWorkExperienceScore;
        summaryData.totalScore += canadianWorkExperienceScore;

        if (userData.spouseComeAlong) {
            summaryData.hasSpouse = true;
            int spouseEduScore = getSpouseEduScore();
            finalScoreItem.put(Consts.KEY_CRS_SPOUSE_EDU_SCORE, spouseEduScore);
            summaryData.spouseEduScore = spouseEduScore;
            summaryData.totalScore += spouseEduScore;

            int spouseLanguageScore = getSpouseLanguageScore();
            finalScoreItem.put(Consts.KEY_CRS_SPOUSE_LANGUAGE_SCORE, spouseLanguageScore);
            summaryData.spouseLanguageScore = spouseLanguageScore;
            summaryData.totalScore += spouseLanguageScore;

            int spouseCanadianWorkExpScore = getSpouseCanadianWorkExpScore();
            finalScoreItem.put(Consts.KEY_CRS_SPOUSE_WORK_EXP_SCORE, spouseCanadianWorkExpScore);
            summaryData.totalScore += spouseCanadianWorkExpScore;
        }

        // skill transferability
        int firstLanguageClbLevel = Math.max(engAsFirstLanguageClbLevel, frAsFirstLanguageClbLevel);
        // language and edu
        int goodLanguageAndEduScore = getGoodLanguageAndEduScore(firstLanguageClbLevel);
        if (goodLanguageAndEduScore != 0) {
            finalScoreItem.put(Consts.KEY_CRS_GOOD_LANGUAGE_AND_HIGH_EDU, goodLanguageAndEduScore);
            summaryData.goodLanguageAndEduScore = goodLanguageAndEduScore;

        }
        // canadian work exp and high edu
        int canadianWorkExpAndHighEdu = getCanadianWorkExpAndHighEdu();
        if (canadianWorkExpAndHighEdu > 0) {
            finalScoreItem.put(Consts.KEY_CRS_CANADIAN_WORK_EXP_AND_HIGH_EDU, canadianWorkExpAndHighEdu);
            summaryData.canadianWorkExpAndHighEdu = canadianWorkExpAndHighEdu;

        }

        summaryData.totalScore += Math.min(50, goodLanguageAndEduScore + canadianWorkExpAndHighEdu);


        int foreignWorkExpScore = getForeignWorkExpScore();
        if (foreignWorkExp > 0) {
            finalScoreItem.put(Consts.KEY_CRS_FOREIGN_WORK_EXP, foreignWorkExpScore);
            summaryData.foreignWorkExpScore = foreignWorkExpScore;
        }

        int foreignWorkExpWithCanWorkExp = getForeignWOrkExpWithCanadianWorkExp();
        if (foreignWorkExpWithCanWorkExp > 0) {
            finalScoreItem.put(Consts.KEY_CRS_FOREIGN_EXP_WITH_CAN_EXP, foreignWorkExpWithCanWorkExp);
            summaryData.foreignWorkExpWithCanWorkExp = foreignWorkExpWithCanWorkExp;
        }

        summaryData.totalScore += Math.min(50, foreignWorkExpScore + foreignWorkExpWithCanWorkExp);
        // todo trade occupation

        // additional points
        int additionalPoints = 0;
        if (userData.hasPRRelatives) {
            additionalPoints += 15;
        }

        // additional languages
        int userFrNclc = min(userData.crsFrListeningClbLevel,
                userData.crsFrReadingClbLevel,
                userData.crsFrWritingClbLevel,
                userData.crsFrSpeakingClbLevel);
        if (userFrNclc >= 7) {
            if (engAsFirstLanguageClbLevel >= 5) {
                finalScoreItem.put(Consts.KEY_CRS_ADDTIONAL_FR, 50);
                additionalPoints += 50;
            } else {
                finalScoreItem.put(Consts.KEY_CRS_ADDTIONAL_FR, 25);
                additionalPoints += 25;
            }
        }

        if (userData.canadaEducationalLevel == 1) {
            finalScoreItem.put(Consts.KEY_CRS_CAN_EDU_EXP, 15);
            additionalPoints += 15;
            summaryData.addtionalCanEduScore = 15;
        } else if (userData.canadaEducationalLevel > 1) {
            finalScoreItem.put(Consts.KEY_CRS_CAN_EDU_EXP, 30);
            additionalPoints += 30;
            summaryData.addtionalCanEduScore = 30;
        }

        if (userData.hasLmia && userData.lmiaJobType == 0) {
            finalScoreItem.put(Consts.KEY_CRS_LIMA_SCORE, 200);
            additionalPoints += 200;
            summaryData.lmiaScore = 200;
        } else if (userData.hasLmia && userData.lmiaJobType > 0 && userData.lmiaJobType < 2) {
            finalScoreItem.put(Consts.KEY_CRS_LIMA_SCORE, 50);
            additionalPoints += 50;
            summaryData.lmiaScore = 50;
        }
        if (userData.hasPN) {
            finalScoreItem.put(Consts.KEY_CRS_HAS_PN, 600);
            additionalPoints += 600;
            summaryData.pnScore = 600;
        }
        summaryData.hasPrRelatives = userData.hasPRRelatives;
        additionalPoints = Math.min(additionalPoints, 600);
        summaryData.totalScore += additionalPoints;
    }

    private int getForeignWOrkExpWithCanadianWorkExp() {
        int score = 0;
        if (userData.canWorkExp >= 1 && userData.canWorkExp < 2) {
            switch (userData.foreignWorkExp) {
                case 0:
                    break;
                case 1:
                case 2:
                    score = 13;
                    break;
                case 3:
                    score = 25;
                    break;
            }
        } else if (userData.canWorkExp >= 2) {
            switch (userData.foreignWorkExp) {
                case 0:
                    break;
                case 1:
                case 2:
                    score = 25;
                    break;
                case 3:
                    score = 50;
                    break;
            }
        }
        return score;
    }

    private int getForeignWorkExpScore() {
        int score = 0;
        int useLanguageClb = Math.max(engAsFirstLanguageClbLevel, frAsFirstLanguageClbLevel);
        if (useLanguageClb >= 7 && useLanguageClb < 9) {
            switch (userData.foreignWorkExp) {
                case 0:
                    break;
                case 1:
                case 2:
                    score = 13;
                    break;
                case 3:
                    score = 25;
                    break;
            }
        } else if (useLanguageClb >= 9) {
            switch (userData.foreignWorkExp) {
                case 0:
                    break;
                case 1:
                case 2:
                    score = 25;
                    break;
                case 3:
                    score = 50;
                    break;
            }
        }
        summaryData.extraFrScore = score;
        return score;
    }

    private int getCanadianWorkExpAndHighEdu() {
        int skillTransferScore = 0;
        if (userData.canWorkExp == 1) {
            switch (userData.basicEducationalLevel) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    skillTransferScore = 13;
                    break;
                case 5:
                case 6:
                case 7:
                    skillTransferScore = 25;
            }
        } else if (userData.canWorkExp >= 2) {
            switch (userData.basicEducationalLevel) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    skillTransferScore = 25;
                    break;
                case 5:
                case 6:
                case 7:
                    skillTransferScore = 50;
            }
        }
        return skillTransferScore;
    }

    private int getGoodLanguageAndEduScore(int firstLanguageClbLevel) {
        int goodLanguageAndEduScore = 0;
        if (firstLanguageClbLevel >= 7 && firstLanguageClbLevel < 9) {
            switch (userData.basicEducationalLevel) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    goodLanguageAndEduScore = 13;
                    break;
                case 5:
                case 6:
                case 7:
                    goodLanguageAndEduScore = 25;
            }
        } else if (firstLanguageClbLevel >= 9) {
            switch (userData.basicEducationalLevel) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    goodLanguageAndEduScore = 25;
                    break;
                case 5:
                case 6:
                case 7:
                    goodLanguageAndEduScore = 50;
            }
        }
        return goodLanguageAndEduScore;
    }

    private int getSpouseCanadianWorkExpScore() {
        return scoreLookup.SpouseCanadianWorkExpTable.get(userData.spouseCanadaWorkExp);
    }

    private int getSpouseLanguageScore() {
        Integer spouseEngListeningScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseEngListeningLevel);
        Integer spouseEngReadingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseEngReadingLevel);
        Integer spouseEngWritingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseEngWritingLevel);
        Integer spouseEngSpeakingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseEngSpeakingLevel);

        int spouseEngScore = spouseEngListeningScore + spouseEngReadingScore +
                spouseEngWritingScore + spouseEngSpeakingScore;

        Integer spouseFrListeningScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseFrListeningLevel);
        Integer spouseFrReadingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseFrReadingLevel);
        Integer spouseFrWritingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseFrWritingLevel);
        Integer spouseFrSpeakingScore = scoreLookup.SpouseLanguageLookupTable.get(userData.spouseFrSpeakingLevel);

        int spouseFrScore = spouseFrListeningScore + spouseFrReadingScore +
                spouseFrWritingScore + spouseFrSpeakingScore;
        return Math.max(spouseEngScore, spouseFrScore);
    }

    private int getSpouseEduScore() {
        return scoreLookup.SpouseEducationLookupTable.get(userData.spouseEducationLevel);
    }

    private int getCanadianWorkExperienceScore() {
        Integer[] canadianWorkExpScore = scoreLookup.CanadianWorkExpTable.get(userData.canWorkExp);
        return canadianWorkExpScore[getSpouseIdx()];
    }

    private int getFrAsSecondaryLanguageScore() {
        Integer[] secondaryFrListeningScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrListeningClbLevel);
        if (secondaryFrListeningScore == null) {
            secondaryFrListeningScore = new Integer[]{0, 0};
        }
        Integer[] secondaryFrReadingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrReadingClbLevel);
        if (secondaryFrReadingScore == null) {
            secondaryFrReadingScore = new Integer[]{0, 0};
        }
        Integer[] secondaryFrWritingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrWritingClbLevel);
        if (secondaryFrWritingScore == null) {
            secondaryFrWritingScore = new Integer[]{0, 0};
        }
        Integer[] secondaryFrSpeakingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrSpeakingClbLevel);
        if (secondaryFrSpeakingScore == null) {
            secondaryFrSpeakingScore = new Integer[]{0, 0};
        }
        return secondaryFrListeningScore[getSpouseIdx()] +
                secondaryFrReadingScore[getSpouseIdx()] +
                secondaryFrWritingScore[getSpouseIdx()] +
                secondaryFrSpeakingScore[getSpouseIdx()];
    }

    private int getEngAsSecondaryLanguageScore() {
        Integer[] secondaryFrListeningScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrListeningClbLevel);
        Integer[] secondaryFrReadingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrReadingClbLevel);
        Integer[] secondaryFrWritingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrWritingClbLevel);
        Integer[] secondaryFrSpeakingScore = scoreLookup.SecondaryLanguageTable.get(userData.crsFrSpeakingClbLevel);
        return secondaryFrListeningScore[getSpouseIdx()] +
                secondaryFrReadingScore[getSpouseIdx()] +
                secondaryFrWritingScore[getSpouseIdx()] +
                secondaryFrSpeakingScore[getSpouseIdx()];
    }

    private int getFrAsFirstLanguageScore() {
        frAsFirstLanguageClbLevel = 0;
        Integer[] firstLanguageFrListeningScore = scoreLookup.FirstLanguageTable.get(userData.crsFrListeningClbLevel);
        if (firstLanguageFrListeningScore == null) {
            firstLanguageFrListeningScore = new Integer[]{0, 0};
        }
        Integer[] firstLanguageFrReadingScore = scoreLookup.FirstLanguageTable.get(userData.crsFrReadingClbLevel);
        if (firstLanguageFrReadingScore == null) {
            firstLanguageFrReadingScore = new Integer[]{0, 0};
        }
        Integer[] firstLanguageFrWritingScore = scoreLookup.FirstLanguageTable.get(userData.crsFrWritingClbLevel);
        if (firstLanguageFrWritingScore == null) {
            firstLanguageFrWritingScore = new Integer[]{0, 0};
        }
        Integer[] firstLanguageFrSpeakingScore = scoreLookup.FirstLanguageTable.get(userData.crsFrSpeakingClbLevel);
        if (firstLanguageFrSpeakingScore == null) {
            firstLanguageFrSpeakingScore = new Integer[]{0, 0};
        }

        frAsFirstLanguageClbLevel = min(userData.crsFrListeningClbLevel,
                userData.crsFrReadingClbLevel,
                userData.crsFrWritingClbLevel,
                userData.crsFrSpeakingClbLevel);

        return firstLanguageFrListeningScore[getSpouseIdx()] +
                firstLanguageFrReadingScore[getSpouseIdx()] +
                firstLanguageFrWritingScore[getSpouseIdx()] +
                firstLanguageFrSpeakingScore[getSpouseIdx()];
    }

    private int min(Integer... array) {
        int min = array[0];
        for (Integer e : array) {
            if (e < min) {
                min = e;
            }
        }
        return min;
    }

    @NotNull
    private Integer[] getAgeScore(int age) {
        String strAge = String.valueOf(age);

        CrsDataModel.RankingItem ageLookupTable = scoreLookup.rankingItems.get(Consts.KEY_CRS_AGE);

        Integer[] ageScores = ageLookupTable.optionsScorePair.get(strAge);
        if (ageScores == null) {
            ageScores = new Integer[]{0, 0};
        }
        return ageScores;
    }

    private int getEngAsFirstLanguageScore() {
        engAsFirstLanguageClbLevel = 0;
        Integer[] firstLanguageEngListeningScore = scoreLookup.FirstLanguageTable.get(userData.crsEngListeningClbLevel);
        if (firstLanguageEngListeningScore == null) {
            firstLanguageEngListeningScore = new Integer[]{0, 0};
        }

        Integer[] firstLanguageEngReadingScore = {0, 0};
        try {
            firstLanguageEngReadingScore = scoreLookup.FirstLanguageTable.get(userData.crsEngReadingClbLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer[] firstLanguageEngWritingScore = {0, 0};
        try {
            firstLanguageEngWritingScore = scoreLookup.FirstLanguageTable.get(userData.crsEngWritingClbLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer[] firstLanguageSpeakingScore = scoreLookup.FirstLanguageTable.get(userData.crsEngSpeakingClbLevel);
        if (firstLanguageSpeakingScore == null) {
            firstLanguageSpeakingScore = new Integer[]{0, 0};
        }

        engAsFirstLanguageClbLevel = min(userData.crsEngListeningClbLevel
                , userData.crsEngReadingClbLevel
                , userData.crsEngWritingClbLevel
                , userData.crsEngSpeakingClbLevel);

        return firstLanguageEngListeningScore[getSpouseIdx()]
                + firstLanguageEngReadingScore[getSpouseIdx()]
                + firstLanguageEngWritingScore[getSpouseIdx()]
                + firstLanguageSpeakingScore[getSpouseIdx()];
    }

    private int getSpouseIdx() {
        return userData.spouseComeAlong ? 0 : 1;
    }
}
