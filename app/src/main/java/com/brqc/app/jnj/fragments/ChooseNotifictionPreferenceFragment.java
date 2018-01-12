package com.brqc.app.jnj.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.activity.BRQCHomeActivity;
import com.brqc.app.jnj.adapter.ChooseNotifAdapter;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseNotifictionPreferenceFragment extends Fragment implements View.OnClickListener {

    private static Configuration mConfiguration;
    private RecyclerView mNotifPrefRV;
    private ChooseNotifAdapter mChooseNotifAdapter;
    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.NotificationPreference> listener;
    private Button mContinueBtn;

    public static ChooseNotifictionPreferenceFragment newInstance(Context mContext , Configuration mNotiConfiguration) {

        mConfiguration = mNotiConfiguration;
        return new ChooseNotifictionPreferenceFragment();
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
        mContinueBtn = view.findViewById(R.id.pref_continue_button);
        mContinueBtn.setOnClickListener(this);
        mContinueBtn.setVisibility(View.VISIBLE);
        mNotifPrefRV = view.findViewById(R.id.choose_region_rcv);
        mChooseNotifAdapter = new ChooseNotifAdapter(getContext(), listener);
        ItemOffsetDecoration mItemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.standard_global_layout_padding_half);
        mChooseNotifAdapter.setList(mConfiguration.getNotificationPreference());
        mChooseNotifAdapter.setClickListener(listener);
        mNotifPrefRV.addItemDecoration(mItemOffsetDecoration);
        mNotifPrefRV.setAdapter(mChooseNotifAdapter);
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mNotifPrefRV.setLayoutManager(layoutManager);
        mNotifPrefRV.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        if(v == mContinueBtn){
            Intent mIntent = new Intent(getContext(), BRQCHomeActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putParcelable(BRQCConstants.CONFIGURATION_KEY,mConfiguration);
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        }
    }
}
