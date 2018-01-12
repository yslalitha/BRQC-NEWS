package com.brqc.app.jnj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.model.GetNewsFeedForUser;

/**
 * Created by ajay on 1/7/2018.
 */

public class FavoritesFragment extends Fragment {

    private static GetNewsFeedForUser mGetNewsFeedForUser;

    public static FavoritesFragment newInstance( GetNewsFeedForUser mGetNewsFeedForUserDetails) {
        mGetNewsFeedForUser = mGetNewsFeedForUserDetails;
        return new FavoritesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brqc_home_news_fragment, container, false);
        return view;
    }
}
