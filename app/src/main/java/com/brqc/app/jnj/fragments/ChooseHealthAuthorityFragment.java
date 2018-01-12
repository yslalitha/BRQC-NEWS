package com.brqc.app.jnj.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.adapter.ChooseHealthAuthorityAdapter;
import com.brqc.app.jnj.adapter.ChooseRegionsAdapter;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseHealthAuthorityFragment extends Fragment {

    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.HealthAuthority> listener;
    private RecyclerView mChooseHealthAuthorityRV;
    private ChooseHealthAuthorityAdapter mChooseHealthAuthorityAdapter;
    private static Configuration mConfiguration;


    public static ChooseHealthAuthorityFragment newInstance(Context mContext , Configuration mHealthAuthorityConfiguration) {

        mConfiguration =  mHealthAuthorityConfiguration;
        return new ChooseHealthAuthorityFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_regions_screen, container, false);
        setUpAndInitViews(view);
        return view;
    }


    private void setUpAndInitViews(View view) {
        //SetUp and Initialise Adapter
        mChooseHealthAuthorityRV = view.findViewById(R.id.choose_region_rcv);
        ItemOffsetDecoration mItemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.standard_global_layout_padding_half);
        mChooseHealthAuthorityAdapter = new ChooseHealthAuthorityAdapter(getContext(),listener);
        mChooseHealthAuthorityAdapter.setList(mConfiguration.getHealthAuthority());
        mChooseHealthAuthorityRV.setAdapter(mChooseHealthAuthorityAdapter);
        mChooseHealthAuthorityRV.addItemDecoration(mItemOffsetDecoration);
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mChooseHealthAuthorityRV.setLayoutManager(layoutManager);
        mChooseHealthAuthorityRV.setHasFixedSize(true);
    }
}
