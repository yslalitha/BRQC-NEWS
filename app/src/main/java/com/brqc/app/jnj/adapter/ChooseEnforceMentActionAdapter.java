package com.brqc.app.jnj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;

/**
 * Created by ajay on 1/10/2018.
 */

public class ChooseEnforceMentActionAdapter extends GenericRecyclerViewAdapter<Configuration.EnforcementAction> {
    public ChooseEnforceMentActionAdapter(Context context) {
        super(context);
    }

    public ChooseEnforceMentActionAdapter(Context context, OnViewHolderClick<Configuration.EnforcementAction> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.choose_region_item, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(Configuration.EnforcementAction item, GenericRecyclerViewAdapter.ViewHolder viewHolder) {
        Button regionButton ;

        if(item!=null){
            regionButton = (Button) viewHolder.getView(R.id.choose_region_item_button);
            regionButton.setText(item.getEActionValue());
        }
    }

}
