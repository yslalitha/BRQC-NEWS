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
import com.brqc.app.jnj.adapter.ChooseEnforceMentActionAdapter;
import com.brqc.app.jnj.adapter.ChooseRegionsAdapter;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseEnforcementActionFragment extends Fragment {

    private RecyclerView mChooseEnforcementRV;
    private ChooseEnforceMentActionAdapter mChooseEnforcementAdapter;
    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.EnforcementAction> listener;

    private static Configuration mConfiguration ;

    public static ChooseEnforcementActionFragment newInstance(Context mContext , Configuration mEAConfiguration) {

        mConfiguration = mEAConfiguration;

        return new ChooseEnforcementActionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_functional_area_screen, container, false);
        setUpAndInitViews(view);

        return view;
    }


    private void setUpAndInitViews(View view) {
        //SetUp and Initialise Adapter
        mChooseEnforcementRV = view.findViewById(R.id.choose_functional_area_rcv);
        ItemOffsetDecoration mItemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.standard_global_layout_padding_half);
        mChooseEnforcementAdapter = new ChooseEnforceMentActionAdapter(getContext(),listener);
        mChooseEnforcementAdapter.setList(mConfiguration.getEnforcementAction());
        mChooseEnforcementAdapter.setClickListener(listener);
        mChooseEnforcementRV.addItemDecoration(mItemOffsetDecoration);
        mChooseEnforcementRV.setAdapter(mChooseEnforcementAdapter);
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mChooseEnforcementRV.setLayoutManager(layoutManager);
        mChooseEnforcementRV.setHasFixedSize(true);
    }

}
