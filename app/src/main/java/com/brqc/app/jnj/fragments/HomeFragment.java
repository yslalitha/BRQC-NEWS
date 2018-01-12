package com.brqc.app.jnj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.adapter.HomeNewsListAdapter;
import com.brqc.app.jnj.model.GetNewsFeedForUser;

import java.util.ArrayList;

/**
 * Created by ajay on 1/7/2018.
 */

public class HomeFragment extends Fragment {

    private RecyclerView mNewsRecyclerView;
    private HomeNewsListAdapter mHomeNewsListAdapter;
    private static GetNewsFeedForUser mGetNewsFeedForUser;



    public static HomeFragment newInstance(GetNewsFeedForUser mGetNewsFeedForUserDetail) {
        mGetNewsFeedForUser = mGetNewsFeedForUserDetail;
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.brqc_home_news_fragment, container, false);
        setUpAndInitialise(view);
        return view;
    }

    private void setUpAndInitialise(View view) {

        mNewsRecyclerView = view.findViewById(R.id.brqc_home_news_rcv);
        mHomeNewsListAdapter = new HomeNewsListAdapter(getContext(), (ArrayList<GetNewsFeedForUser.NewsFeed>) mGetNewsFeedForUser.getNewsFeed());
        mNewsRecyclerView.setAdapter(mHomeNewsListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mNewsRecyclerView.setLayoutManager(layoutManager);
        mNewsRecyclerView.setHasFixedSize(true);
    }

}
