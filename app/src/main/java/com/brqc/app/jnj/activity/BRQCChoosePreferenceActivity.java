package com.brqc.app.jnj.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.adapter.BRQCViewPagerAdapter;
import com.brqc.app.jnj.app.BRQCApplication;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.rest.BRQCServiceFactory;
import com.brqc.app.jnj.rest.BRQCServiceInterface;
import com.brqc.app.jnj.utils.ConnectivityReciever;
import com.brqc.app.jnj.utils.CustomTransparentDialog;
import com.brqc.app.jnj.utils.NetworkConnectionListener;
import com.brqc.app.jnj.utils.NetworkSnackBar;
import com.rd.PageIndicatorView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ajay on 1/7/2018.
 */

public class BRQCChoosePreferenceActivity extends AppCompatActivity implements NetworkConnectionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private BRQCViewPagerAdapter adapter;
    private CustomTransparentDialog mCustomTransparentDialog;
    private ProgressDialog mProgressDialog;
    private ActionBar mToolbar;
    private TextView mTitle;

    private String[] titles = {
            "Choose Regions", "Functional Area", "Health Authority", "EnforcementAction", "Notification"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = getSupportActionBar();
        mToolbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mToolbar.setCustomView(R.layout.pref_actionbar);
        View view = mToolbar.getCustomView();
        mTitle = view.findViewById(R.id.pref_title);
        mCustomTransparentDialog = new CustomTransparentDialog(this);
        mProgressDialog = mCustomTransparentDialog.getProgressDoalog();


        //Make Service call
        boolean isConnected = ConnectivityReciever.isNetworkConnected();
        if(isConnected){
            makeServiceCall();
        }else {
            NetworkSnackBar.showToast(isConnected);
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        BRQCApplication.getInstance().setConnectivityListener(this);
    }

    private void makeServiceCall() {
        mProgressDialog.show();
        BRQCServiceInterface mBrqcServiceInterface = BRQCServiceFactory.makeBRQCService().create(BRQCServiceInterface.class);
        Call<Configuration> call = mBrqcServiceInterface.getBRQCConfiguration();
        call.enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                mProgressDialog.dismiss();


                Log.d(TAG, "Number of movies received: " + response);
                Configuration mConfiguration = response.body();
                Log.d(TAG, String.valueOf(mConfiguration.getEnforcementAction()));
                setContentView(R.layout.brqc_preference_screen_container);
                setUpView(mConfiguration ,mToolbar);
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
                mProgressDialog.dismiss();


                Log.d(TAG, "Number of movies received: " + call.toString());
            }
        });
    }


    private void setUpView(Configuration mConfiguration, final ActionBar mToolbar){
        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(4); // specify total count of indicators
        pageIndicatorView.setSelection(0);
        mViewPager =  findViewById(R.id.brqc_preference_screen_viewpager);
        adapter = new BRQCViewPagerAdapter(getApplicationContext(),getSupportFragmentManager(),mConfiguration ,mToolbar);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mViewPager.setCurrentItem(position);
                switch(position) {
                    case 0:
                        mTitle.setText(titles[position]);
                        break;
                    case 1:
                        mTitle.setText(titles[position]);
                        break;
                    case 2:
                        mTitle.setText(titles[position]);
                        break;
                    case 3:
                        mTitle.setText(titles[position]);
                        break;
                    case 4:
                        mTitle.setText(titles[position]);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pageIndicatorView.setViewPager(mViewPager);
        pageIndicatorView.setUnselectedColor(R.drawable.white_boundry_circle);
        pageIndicatorView.setPadding(10);
        pageIndicatorView.setRadius(10);
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        if(isConnected){
            mProgressDialog.show();
            makeServiceCall();
        }else {
            NetworkSnackBar.showToast(isConnected);
        }
    }

}
