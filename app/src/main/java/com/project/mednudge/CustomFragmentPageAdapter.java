package com.project.mednudge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MEGHA on 24-10-2017.
 */

public class CustomFragmentPageAdapter extends FragmentPagerAdapter {
    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SignUpP();
            case 1:
                return new SignUpD();
        }
        return null;

    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "As Patient";
            case 1:
                return "As Doctor";

        }
        return null;
    }
}

