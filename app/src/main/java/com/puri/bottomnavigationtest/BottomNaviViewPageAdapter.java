package com.puri.bottomnavigationtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 *
 */
public class BottomNaviViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<PageFragment> fragments = new ArrayList<>();
    private PageFragment currentFragment;

    public BottomNaviViewPageAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(PageFragment.newInstance(0));
        fragments.add(PageFragment.newInstance(1));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((PageFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * Get the current fragment
     */
    public PageFragment getCurrentFragment() {
        return currentFragment;
    }
}