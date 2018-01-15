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

public class ChooseFunctionalAreaAdapter extends GenericRecyclerViewAdapter<Configuration.FunctionalArea> {

    private Context mContext;
    boolean isPreferenceItemClicked = false;
    SharedPreferences prefs;

    public ChooseFunctionalAreaAdapter(Context context) {
        super(context);
        mContext = context;
    }

    public ChooseFunctionalAreaAdapter(Context context, OnViewHolderClick<Configuration.FunctionalArea> listener) {
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
    protected void bindView(final Configuration.FunctionalArea item, GenericRecyclerViewAdapter.ViewHolder viewHolder) {
        final Button regionButton ;

        if(item!=null){
            regionButton = (Button) viewHolder.getView(R.id.choose_region_item_button);
            regionButton.setText(item.getFAreaValue());
            regionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Region Item clicked !!",Toast.LENGTH_LONG).show();
                    prefs = mContext.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
                    String data = prefs.getString("functionalsettings","");
                    SharedPreferences.Editor editor= prefs.edit();
                    if(view != null) {
                        if (!item.getSelected()) {
                            data += item.getFAreaValue() +",";
                            editor.putString("functionalsettings",data).commit();
                            item.setSelected(true);
                            regionButton.setBackground(mContext.getDrawable(R.drawable.region_item_bg_selected));
                            regionButton.setTextColor(mContext.getResources().getColor(R.color.black));
                            isPreferenceItemClicked = true;

                        } else {
                            data =data.replace(item.getFAreaValue() +",", "");
                            editor.putString("functionalsettings",data).commit();
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
