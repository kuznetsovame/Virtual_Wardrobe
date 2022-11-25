package com.example.virtualwardrobe.di;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.virtualwardrobe.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
class WardrobeModule {
    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(@ApplicationContext Context context) {
        return context.getSharedPreferences(
                context.getString(R.string.app_name),
                Context.MODE_PRIVATE
        );
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return logging;
    }


    @Provides
    @Singleton
    public OkHttpClient httpClient(
            HttpLoggingInterceptor httpLoggingInterceptor,
            SharedPreferences sharedPreferences) {
        return new OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                    .addHeader(
//                        "Authorization",
//                        "Bearer ${sharedPreferences.getString("API_KEY", "").orEmpty()}"
//                    )
//                    .build()
//
//                return@addInterceptor chain.proceed(request)
//            }
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    @Provides
    @Singleton

    public Retrofit wardrobeApi(OkHttpClient okHttpClient) {
      return  new Retrofit.Builder()
                .baseUrl("")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
