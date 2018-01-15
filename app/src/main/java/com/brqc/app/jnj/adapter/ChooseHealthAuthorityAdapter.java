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

public class ChooseHealthAuthorityAdapter extends GenericRecyclerViewAdapter<Configuration.HealthAuthority> {

    private Context mContext;
    boolean isPreferenceItemClicked = false;
    SharedPreferences prefs;

    public ChooseHealthAuthorityAdapter(Context context) {
        super(context);
        mContext = context;
    }

    public ChooseHealthAuthorityAdapter(Context context, OnViewHolderClick<Configuration.HealthAuthority> listener) {
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
    protected void bindView(final Configuration.HealthAuthority item, GenericRecyclerViewAdapter.ViewHolder viewHolder) {
        final Button regionButton ;

        if(item!=null){
            regionButton = (Button) viewHolder.getView(R.id.choose_region_item_button);
            regionButton.setText(item.getHAuthorityValue());
            regionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Region Item clicked !!",Toast.LENGTH_LONG).show();
                    prefs = mContext.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
                    String data = prefs.getString("HAsettings","");
                    SharedPreferences.Editor editor= prefs.edit();
                    if(view != null) {
                        if (!item.getSelected()) {
                            data += item.getHAuthorityValue() +",";
                            editor.putString("HAsettings",data).commit();
                            item.setSelected(true);
                            regionButton.setBackground(mContext.getDrawable(R.drawable.region_item_bg_selected));
                            regionButton.setTextColor(mContext.getResources().getColor(R.color.black));
                            isPreferenceItemClicked = true;
                        } else {
                            item.setSelected(false);
                            data =data.replace(item.getHAuthorityValue() +",", "");
                            editor.putString("HAsettings",data).commit();
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
