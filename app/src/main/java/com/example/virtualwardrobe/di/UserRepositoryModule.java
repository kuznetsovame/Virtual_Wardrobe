package com.example.virtualwardrobe.di;


import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.repository.UserReopository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UserRepositoryModule {

    @Provides
    public UserReopository userReopository(WardrobeApi wardrobeApi) {
        return new UserReopository(wardrobeApi);
    }
}
