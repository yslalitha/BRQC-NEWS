package com.brqc.app.jnj.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;

import com.brqc.app.jnj.R;

/**
 * Created by admin on 10/01/18.
 */

public class CustomTransparentDialog {

    private static Context mContext;

    public CustomTransparentDialog(Context mContext){
        this.mContext = mContext;
    }

    public static ProgressDialog getProgressDoalog(){
        View view = View.inflate(mContext, R.layout.progress_dialog,null);
        ProgressDialog mDialog = new ProgressDialog(mContext, R.style.TransparentDialog);
        mDialog.setContentView(view);
        return mDialog;
    }
}
