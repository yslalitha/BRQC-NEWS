package com.brqc.app.jnj.utils;

import android.widget.Toast;

import com.brqc.app.jnj.app.BRQCApplication;

/**
 * Created by admin on 10/01/18.
 */

public class NetworkSnackBar {

    // Showing the status in Snackbar
    public static void showToast(boolean isConnected) {
        String message;
        if (!isConnected) {
            message = "Sorry!!!!! Not connected to internet please try again later";
            Toast.makeText(BRQCApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_LONG).show();

        }

    }
}
