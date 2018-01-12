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
import com.brqc.app.jnj.adapter.ChooseFunctionalAreaAdapter;
import com.brqc.app.jnj.adapter.ChooseRegionsAdapter;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseFunctionalAreaFragment extends Fragment {


    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.FunctionalArea> listener;
    private RecyclerView mChooseFunctionAreaRV;
    private ChooseFunctionalAreaAdapter mChooseFunctionalAreaAdapter;
    private static Configuration mConfiguration ;


    public static ChooseFunctionalAreaFragment newInstance(Context mContext , Configuration mFunctionalAreaConfiguration) {

        mConfiguration = mFunctionalAreaConfiguration;
        return new ChooseFunctionalAreaFragment();
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
        mChooseFunctionAreaRV = view.findViewById(R.id.choose_region_rcv);
        mChooseFunctionalAreaAdapter = new ChooseFunctionalAreaAdapter(getContext(),listener);
        ItemOffsetDecoration mItemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.standard_global_layout_padding_half);
        mChooseFunctionalAreaAdapter.setList(mConfiguration.getFunctionalArea());
        mChooseFunctionalAreaAdapter.setClickListener(listener);
        mChooseFunctionAreaRV.setAdapter(mChooseFunctionalAreaAdapter);
        mChooseFunctionAreaRV.addItemDecoration(mItemOffsetDecoration);
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mChooseFunctionAreaRV.setLayoutManager(layoutManager);
        mChooseFunctionAreaRV.setHasFixedSize(true);
    }
}
