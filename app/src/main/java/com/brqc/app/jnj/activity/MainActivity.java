package com.brqc.app.jnj.activity;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        BRQCServiceInterface mBrqcServiceInterface = BRQCServiceFactory.makeBRQCService().create(BRQCServiceInterface.class);
        Call<Configuration> call = mBrqcServiceInterface.getBRQCConfiguration();
        call.enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                Log.d(TAG, "Number of movies received: " + response);
                Configuration mConfiguration = response.body();
                Log.d(TAG, String.valueOf(mConfiguration.getEnforcementAction()));
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {

                Log.d(TAG, "Number of movies received: " + call.toString());
            }
        });
    }*/


}
