package com.brqc.app.jnj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brqc.app.jnj.R;

/**
 * Created by ajay on 1/7/2018.
 */

public class FilterFragment extends Fragment {

    public static FilterFragment newInstance() {

        return new FilterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_filter_screen, container, false);



        return view;
    }
}
