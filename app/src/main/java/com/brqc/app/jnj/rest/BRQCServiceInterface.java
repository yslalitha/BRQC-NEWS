package com.brqc.app.jnj.rest;

import com.brqc.app.jnj.activity.BRQCChoosePreferenceActivity;
import com.brqc.app.jnj.activity.BRQCHomeActivity;
import com.brqc.app.jnj.fragments.ChooseNotifictionPreferenceFragment;
import com.brqc.app.jnj.fragments.HomeFragment;
import com.brqc.app.jnj.model.Configuration;
import com.brqc.app.jnj.model.GetNewsFeedForUser;
import com.brqc.app.jnj.model.SaveDetailsForUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ajay on 1/5/2018.
 */

public interface BRQCServiceInterface {

    @GET("GetConfiguration")
    Call<Configuration> getBRQCConfiguration();

    @POST("GetNewsFeedForUser")
    Call<GetNewsFeedForUser> getNewsFeedForUser(@Body BRQCHomeActivity.BodyParams bodyParams);

    @POST("SaveUserDetailsPost")
    Call<SaveDetailsForUser> SendPreferenceDetailsForUser(@Body ChooseNotifictionPreferenceFragment.BodyParams bodyParams);


}
