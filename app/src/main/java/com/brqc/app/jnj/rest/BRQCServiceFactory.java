package com.brqc.app.jnj.rest;

import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.constants.BuildConfig;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ajay on 1/5/2018.
 * <p>
 * BRQC service class to consume services
 */


public class BRQCServiceFactory {

    private static Retrofit retrofit = null;

    /**
     * creating retorfit service to consume data
     *
     * @return
     */
    public static Retrofit makeBRQCService() {

        OkHttpClient okHttpClient = makeOkHttpClient(makeLoggingInterceptor());
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BRQCConstants.BRQCBASEURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            return retrofit;
        } else {
            return retrofit;
        }
    }


    /**
     * creating OkHttpClient service
     *
     * @param httpLoggingInterceptor
     * @return OkHttpsClient service
     */
    public static OkHttpClient makeOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    /**
     * Creating Logging interceptor
     *
     * @return HttpLoggingInterceptor
     */
    public static HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }
}
