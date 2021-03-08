package com.zhen.maptocanada.ui.crs.data;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.ui.crs.crspages.BaseCrsFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsAgeFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsCanadianRelativesFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsEduFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsLanguageFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsSpouseInfoFragment;
import com.zhen.maptocanada.ui.crs.crspages.CrsWorkExperienceFragment;

public class CrsRankingVPAdatper extends FragmentStateAdapter {
    private final int[] views = {
            R.layout.viewpager_crs_age,
            R.layout.viewpager_crs_edu,
            R.layout.viewpager_crs_language,
            R.layout.viewpager_crs_canadian_work_exp,
            R.layout.viewpager_crs_pr_relatives,
            R.layout.viewpager_crs_spouse_info
    };
    CrsUserData userData;

    public CrsRankingVPAdatper(FragmentActivity act, CrsUserData userData) {
        super(act);
        this.userData = userData;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        BaseCrsFragment frag = null;
        switch (position) {
            case 0:
                frag = new CrsAgeFragment(userData);
                break;
            case 1:
                frag = new CrsEduFragment(userData);
                break;
            case 2:
                frag = new CrsLanguageFragment(userData);
                break;
            case 3:
                frag = new CrsWorkExperienceFragment(userData);
                break;
            case 4:
                frag = new CrsCanadianRelativesFragment(userData);
                break;
            case 5:
                frag = new CrsSpouseInfoFragment(userData);
                break;
        }
        return frag;
    }

    @Override
    public int getItemCount() {
        return views.length;
    }
}
