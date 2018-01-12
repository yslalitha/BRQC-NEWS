package com.brqc.app.jnj.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;

import com.brqc.app.jnj.fragments.ChooseEnforcementActionFragment;
import com.brqc.app.jnj.fragments.ChooseFunctionalAreaFragment;
import com.brqc.app.jnj.fragments.ChooseHealthAuthorityFragment;
import com.brqc.app.jnj.fragments.ChooseNotifictionPreferenceFragment;
import com.brqc.app.jnj.fragments.ChooseRegionsFragment;
import com.brqc.app.jnj.model.Configuration;

/**
 * Created by admin on 09/01/18.
 */

public class BRQCViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public static int totalPage = 5;
    private Configuration mConfiguration;
    private ActionBar mToolbar;




    public BRQCViewPagerAdapter(Context context, FragmentManager fm , Configuration mConfiguration,ActionBar mToolbar) {
        super(fm);
        mContext = context;
        this.mConfiguration = mConfiguration;
        this.mToolbar = mToolbar;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment mFragment = new Fragment();
        switch (position) {
            case 0:
                mFragment = ChooseRegionsFragment.newInstance(mContext,mConfiguration);
                break;
            case 1:

                mFragment = ChooseFunctionalAreaFragment.newInstance(mContext,mConfiguration);
                break;
            case 2:

                mFragment = ChooseHealthAuthorityFragment.newInstance(mContext,mConfiguration);

                break;
            case 3:

                mFragment = ChooseEnforcementActionFragment.newInstance(mContext,mConfiguration);
                break;
            case 4:

                mFragment = ChooseNotifictionPreferenceFragment.newInstance(mContext,mConfiguration);
                break;
            default:
        }
        return mFragment;
    }

    @Override
    public int getCount() {
        return totalPage;
    }

}
