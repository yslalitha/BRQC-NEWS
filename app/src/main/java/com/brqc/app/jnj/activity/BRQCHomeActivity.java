package com.brqc.app.jnj.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.app.BRQCApplication;
import com.brqc.app.jnj.fragments.FavoritesFragment;
import com.brqc.app.jnj.fragments.FilterFragment;
import com.brqc.app.jnj.fragments.HomeFragment;
import com.brqc.app.jnj.fragments.NotificationFragment;
import com.brqc.app.jnj.model.GetNewsFeedForUser;
import com.brqc.app.jnj.rest.BRQCServiceFactory;
import com.brqc.app.jnj.rest.BRQCServiceInterface;
import com.brqc.app.jnj.utils.ConnectivityReciever;
import com.brqc.app.jnj.utils.CustomTransparentDialog;
import com.brqc.app.jnj.utils.NetworkConnectionListener;
import com.brqc.app.jnj.utils.NetworkSnackBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ajay on 1/7/2018.
 */

public class BRQCHomeActivity extends AppCompatActivity implements NetworkConnectionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView mBottomNavigationView;
    private ProgressDialog mProgressDialog;
    private CustomTransparentDialog mCustomTransparentDialog;
    private GetNewsFeedForUser mGetNewsFeedForUser;
    private Bundle mBundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brqc_home_activity);
        mBundle = savedInstanceState;

        //Show Progress Dialog
        mCustomTransparentDialog = new CustomTransparentDialog(this);
        mProgressDialog = mCustomTransparentDialog.getProgressDoalog();

        //Make Service Call
        boolean isConnected = ConnectivityReciever.isNetworkConnected();
        if (isConnected) {
            makeServiceCall();

        } else {
            NetworkSnackBar.showToast(isConnected);
        }

        //If Bundle is null then load home fragment by default
       /*
        }*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        BRQCApplication.getInstance().setConnectivityListener(this);
    }


    /**
     * @param mGetNewsFeedForUser
     */
    private void setupBottomNavigation(final GetNewsFeedForUser mGetNewsFeedForUser) {
        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        loadHomeFragment(mGetNewsFeedForUser);
                        return true;
                    case R.id.fav:
                        loadFavFragment(mGetNewsFeedForUser);
                        return true;
                    case R.id.notification:
                        loadNotificationFragment(mGetNewsFeedForUser);
                        return true;
                    case R.id.filter:
                        loadFilterFragment(mGetNewsFeedForUser);
                        return true;
                }
                return false;
            }
        });
    }

    /**
     * @param mGetNewsFeedForUser
     */
    private void loadFilterFragment(GetNewsFeedForUser mGetNewsFeedForUser) {
        FilterFragment fragment = FilterFragment.newInstance();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.home_fragment_container, fragment);
        ft.commit();
    }


    /**
     * @param mGetNewsFeedForUser
     */
    private void loadHomeFragment(GetNewsFeedForUser mGetNewsFeedForUser) {

        HomeFragment fragment = HomeFragment.newInstance(mGetNewsFeedForUser);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.home_fragment_container, fragment);
        ft.commit();
    }


    /**
     * @param mGetNewsFeedForUser
     */
    private void loadFavFragment(GetNewsFeedForUser mGetNewsFeedForUser) {

        FavoritesFragment fragment = FavoritesFragment.newInstance(mGetNewsFeedForUser);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.home_fragment_container, fragment);
        ft.commit();
    }

    /**
     * @param mGetNewsFeedForUser
     */
    private void loadNotificationFragment(GetNewsFeedForUser mGetNewsFeedForUser) {

        NotificationFragment fragment = NotificationFragment.newInstance(mGetNewsFeedForUser);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.home_fragment_container, fragment);
        ft.commit();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (isConnected) {
            makeServiceCall();
        } else {
            NetworkSnackBar.showToast(isConnected);
        }
    }


    /**
     *
     */
    public void makeServiceCall() {
        mProgressDialog.show();
        BodyParams bodyParams = new BodyParams();
        bodyParams.Username = "phubball";
        bodyParams.EmailId = "phubball@its.jnj.com";
        bodyParams.CurrentDateTimestamp = "/Date(1515138632000)/";
        bodyParams.NewsFeedType = "Delta";

        BRQCServiceInterface mBrqcServiceInterface = BRQCServiceFactory.makeBRQCService().create(BRQCServiceInterface.class);
        Call<GetNewsFeedForUser> mGetNewsFeedForUserCall = mBrqcServiceInterface.getNewsFeedForUser(bodyParams);
        mGetNewsFeedForUserCall.enqueue(new Callback<GetNewsFeedForUser>() {
            @Override
            public void onResponse(Call<GetNewsFeedForUser> call, Response<GetNewsFeedForUser> response) {
                mProgressDialog.dismiss();
                Log.d(TAG, "Number of movies received: " + response);
                mGetNewsFeedForUser = response.body();
                setupBottomNavigation(mGetNewsFeedForUser);

                if (mBundle == null) {
                    loadHomeFragment(mGetNewsFeedForUser);
                }

            }

            @Override
            public void onFailure(Call<GetNewsFeedForUser> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "Number of movies received: " + call.toString());

            }
        });
    }


    /**
     *
     */
    public class BodyParams {
        public String Username;
        public String EmailId;
        public String CurrentDateTimestamp;
        public String NewsFeedType;
    }
}
