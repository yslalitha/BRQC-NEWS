package com.brqc.app.jnj.app;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.brqc.app.jnj.utils.ConnectivityReciever;
import com.brqc.app.jnj.utils.NetworkConnectionListener;

/**
 * Created by ajay on 1/5/2018.
 */

public class BRQCApplication extends Application {

    private static BRQCApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new ConnectivityReciever(), intentFilter);
    }

    public static synchronized BRQCApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(NetworkConnectionListener listener) {
        ConnectivityReciever.mNetworkConnectionListener = listener;
    }
}
