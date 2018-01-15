package com.brqc.app.jnj.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;

/**
 * Created by ajay on 1/10/2018.
 */

public class ChooseEnforceMentActionAdapter extends GenericRecyclerViewAdapter<Configuration.EnforcementAction> {

    private Context mContext;
    boolean isPreferenceItemClicked = false;
    private SharedPreferences prefs;

    public ChooseEnforceMentActionAdapter(Context context) {
        super(context);
        mContext = context;
    }

    public ChooseEnforceMentActionAdapter(Context context, OnViewHolderClick<Configuration.EnforcementAction> listener) {
        super(context, listener);
        mContext = context;
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.choose_region_item, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(final Configuration.EnforcementAction item, GenericRecyclerViewAdapter.ViewHolder viewHolder) {
       final Button regionButton ;

        if(item!=null){
            regionButton = (Button) viewHolder.getView(R.id.choose_region_item_button);
            regionButton.setText(item.getEActionValue());
            regionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Region Item clicked !!",Toast.LENGTH_LONG).show();
                    prefs = mContext.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
                    String data = prefs.getString("enforcementsettings","");
                    SharedPreferences.Editor editor= prefs.edit();

                    if(view != null) {
                        if (!item.getSelected()) {
                            regionButton.setBackground(mContext.getDrawable(R.drawable.region_item_bg_selected));
                            regionButton.setTextColor(mContext.getResources().getColor(R.color.black));
                            isPreferenceItemClicked = true;
                            item.setSelected(true);
                            data += item.getEActionValue() +",";
                            editor.putString("enforcementsettings",data).commit();
                        } else {
                            data =data.replace(item.getEActionValue() +",", "");
                            editor.putString("enforcementsettings",data).commit();
                            item.setSelected(false);
                            regionButton.setBackground(mContext.getDrawable(R.drawable.region_item_bg_unselected));
                            regionButton.setTextColor(mContext.getResources().getColor(R.color.white));
                            isPreferenceItemClicked = false;
                        }
                    }else {
                        Toast.makeText(getContext(),"View Not Null!!",Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }

}
