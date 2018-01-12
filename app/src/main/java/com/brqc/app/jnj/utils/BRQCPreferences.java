package com.brqc.app.jnj.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.brqc.app.jnj.constants.BRQCConstants;

/**
 * Created by ajay on 1/9/2018.
 */

public class BRQCPreferences {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    public void set(String key, String value) {
        this.editor.putString(key, value);
        this.editor.commit();
    }

    public String get(String key) {
        return this.sharedPreferences.getString(key, null);
    }

    public void clear(String key) {
        this.editor.remove(key);
        this.editor.commit();
    }

    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }

    public static SharedPreferences getMySharedPreferencesInstance(Context mContext){

        if(mContext!=null && sharedPreferences == null){
           return sharedPreferences = mContext.getSharedPreferences(BRQCConstants.USERCREDENTIALSPREF,Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedPrefEditorInstance(Context mContext){

        if(mContext !=null && editor == null ){
           return editor = mContext.getSharedPreferences(BRQCConstants.USERCREDENTIALSPREF,Context.MODE_PRIVATE).edit();
        }
        return editor;
    }
}
