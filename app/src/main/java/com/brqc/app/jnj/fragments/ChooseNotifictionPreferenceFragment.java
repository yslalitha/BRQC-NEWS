package com.brqc.app.jnj.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.activity.BRQCChoosePreferenceActivity;
import com.brqc.app.jnj.activity.BRQCHomeActivity;
import com.brqc.app.jnj.adapter.ChooseNotifAdapter;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.model.GetNewsFeedForUser;
import com.brqc.app.jnj.model.SaveDetailsForUser;
import com.brqc.app.jnj.rest.BRQCServiceFactory;
import com.brqc.app.jnj.rest.BRQCServiceInterface;
import com.brqc.app.jnj.utils.ConnectivityReciever;
import com.brqc.app.jnj.utils.GenericRecyclerViewAdapter;
import com.brqc.app.jnj.utils.ItemOffsetDecoration;
import com.brqc.app.jnj.utils.NetworkSnackBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ajay on 1/7/2018.
 */

public class ChooseNotifictionPreferenceFragment extends Fragment implements View.OnClickListener {

    private static Configuration mConfiguration;
    private RecyclerView mNotifPrefRV;
    private ChooseNotifAdapter mChooseNotifAdapter;
    private GenericRecyclerViewAdapter.OnViewHolderClick<Configuration.NotificationPreference> listener;
    private Button mContinueBtn;
    SharedPreferences prefs;
    private Context mContext;
    private SaveDetailsForUser mResponse;

    public static ChooseNotifictionPreferenceFragment newInstance(Context mContext , Configuration mNotiConfiguration) {
        mContext = mContext;
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
            //Make Service Call
            boolean isConnected = ConnectivityReciever.isNetworkConnected();
            if (isConnected) {
                makeServiceCall();

            } else {
                NetworkSnackBar.showToast(isConnected);
            }
            Intent mIntent = new Intent(getContext(), BRQCHomeActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putParcelable(BRQCConstants.CONFIGURATION_KEY,mConfiguration);
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        }
    }
    public void makeServiceCall() {
        //   mProgressDialog.show();

        ChooseNotifictionPreferenceFragment.BodyParams bodyParams = new ChooseNotifictionPreferenceFragment.BodyParams();


        prefs = getActivity().getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        String regiondata = prefs.getString("regionsettings","");
        List<Region> regionlist =null;
        List<FunctionalArea> functionallist = null;
        if(!regiondata.equals(""))
        {
            String[] regions = regiondata.split(",");
            regionlist = new ArrayList<Region>() ;
            for (String region : regions)
            {
                regionlist.add(new Region(region));
            }
        }
       // String EAdata = prefs.getString("enforcementsettings","");
        String functionaldata = prefs.getString("functionalsettings","");
        if(!functionaldata.equals(""))
        {
            String[] functions = functionaldata.split(",");
            functionallist = new ArrayList<FunctionalArea>() ;
            for (String functionArea : functions)
            {
                functionallist.add(new FunctionalArea(functionArea));
            }
        }
        //temp data to be removed with new WS
      //  String HAdata = prefs.getString("HAsettings","");
        List<HealthAuthority> HAlist = new ArrayList<HealthAuthority>() ;
        HAlist.add(new HealthAuthority("AR:Ministry of Health"));
        //temp data end

        String notiddata = prefs.getString("notifsettings","");

        bodyParams.Username = "phubball";
        bodyParams.EmailId = "phubball@its.jnj.com";
        bodyParams.Regions = regionlist;
        bodyParams.FunctionalAreas = functionallist;
      //  bodyParams.Authorities = HAlist;
        bodyParams.NotificationPreference = notiddata;
        bodyParams.DeviceToken = "14526asfdadff:dsfs:dvddfsf";
        bodyParams.DeviceType = "Android";

        BRQCServiceInterface mBrqcServiceInterface = BRQCServiceFactory.makeBRQCService().create(BRQCServiceInterface.class);
        Call<SaveDetailsForUser> mSendPreferenceDetailsForUser = mBrqcServiceInterface.SendPreferenceDetailsForUser(bodyParams);
        mSendPreferenceDetailsForUser.enqueue(new Callback<SaveDetailsForUser>() {
            @Override
            public void onResponse(Call<SaveDetailsForUser> call, Response<SaveDetailsForUser> response) {
                //   mProgressDialog.dismiss();
             //   Log.d(TAG, "Number of movies received: " + response);
                mResponse = response.body();
              //  setupBottomNavigation(mSendPreferenceDetailsForUser);

                /*if (mBundle == null) {
                    loadHomeFragment(mGetNewsFeedForUser);
                }*/

            }

            @Override
            public void onFailure(Call<SaveDetailsForUser> call, Throwable t) {
             //   mProgressDialog.dismiss();
               // Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                //Log.d(TAG, "Number of movies received: " + call.toString());

            }
        });
    }
    public class BodyParams {
        public String Username;
        public String EmailId;
        public List<Region> Regions;
        public List<FunctionalArea> FunctionalAreas;
      //  public List<HealthAuthority> Authorities;
        public String NotificationPreference;
        public String DeviceToken;
        public String DeviceType;
    }
    public class Region {
        String RegionValue;
        public Region(String region){
            this.RegionValue = region;
        }
    }
    public class FunctionalArea{
        String FAValue;
        public FunctionalArea(String FAValue){
            this.FAValue = FAValue;
        }
    }
    public class HealthAuthority{
        String HAValue;
        public HealthAuthority(String HAValue){
            this.HAValue = HAValue;
        }
    }

}
