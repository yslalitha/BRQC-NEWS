package com.brqc.app.jnj.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.brqc.app.jnj.app.BRQCApplication;

/**
 * Created by admin on 10/01/18.
 */

public class ConnectivityReciever extends BroadcastReceiver {

    public static NetworkConnectionListener mNetworkConnectionListener;

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        if (mNetworkConnectionListener != null) {
            mNetworkConnectionListener.onNetworkConnectionChanged(isConnected);
        }
    }


    public static boolean isNetworkConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) BRQCApplication.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }
}
