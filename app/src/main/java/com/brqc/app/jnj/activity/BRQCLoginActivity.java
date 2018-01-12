package com.brqc.app.jnj.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.app.BRQCApplication;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.fragments.BRQCLoginFragment;
import com.brqc.app.jnj.utils.NetworkConnectionListener;
import com.brqc.app.jnj.utils.NetworkSnackBar;

/**
 * Created by ajay on 1/9/2018.
 */

public class BRQCLoginActivity extends AppCompatActivity implements NetworkConnectionListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brqc_login_activity);

        //Setting Default Value to SharedPreferences
        SharedPreferences mSharedPreferences = getSharedPreferences(BRQCConstants.USERCREDENTIALSPREF , Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor  = mSharedPreferences.edit();
        mEditor.putString(BRQCConstants.USERNAME ,"AJAY");
        mEditor.putString(BRQCConstants.PASSWORD , "AJAY");
        mEditor.commit();



        FragmentTransaction mFragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, BRQCLoginFragment.newInstance(this));
        mFragmentTransaction.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        BRQCApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        NetworkSnackBar.showToast(isConnected);
    }

}
