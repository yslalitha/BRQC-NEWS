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
import com.brqc.app.jnj.adapter.ChooseRegionsAdapter;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseRegionsFragment extends Fragment {

    private static Configuration mRegionsConfiguration;
    private static Context mRegionsContext;

    private RecyclerView mChooseRegionsRV;
    private ChooseRegionsAdapter mChooseRegionsAdapter;
    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.Region> listener;

    public static ChooseRegionsFragment newInstance(Context mContext, Configuration mConfiguration) {
        mRegionsConfiguration = mConfiguration;
        mRegionsContext = mContext;
        return new ChooseRegionsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_regions_screen, container, false);

        // SetUp Views and Adapter
        setUpAndInitViews(view);

        return view;
    }

    private void setUpAndInitViews(View view) {
        //SetUp and Initialise Adapter
        mChooseRegionsRV = view.findViewById(R.id.choose_region_rcv);
        mChooseRegionsAdapter = new ChooseRegionsAdapter(getContext(), listener);
        ItemOffsetDecoration mItemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.standard_global_layout_padding_half);
        mChooseRegionsAdapter.setList(mRegionsConfiguration.getRegions());
        mChooseRegionsAdapter.setClickListener(listener);
        mChooseRegionsRV.addItemDecoration(mItemOffsetDecoration);
        mChooseRegionsRV.setAdapter(mChooseRegionsAdapter);
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mChooseRegionsRV.setLayoutManager(layoutManager);
        mChooseRegionsRV.setHasFixedSize(true);
    }

}
