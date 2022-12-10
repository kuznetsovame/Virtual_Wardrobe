package com.example.virtualwardrobe.network;

import com.example.virtualwardrobe.model.User;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WardrobeApi {

    @POST("./user/reg")
    Single<User> regUser(@Body User user);

    @POST("./user/auth")
    Single<User> authUser(@Body User user);

    @GET("/user/getUserById/{id}")
    User getUserById(int id);

    @GET("/friend/get")
    User getFriends(User user);

    @POST("/friend/sendRequest")
    void sendFriedRequest(User user1, User user2);

    @POST("/friend/acceptRequest")
    void acceptFriendRequest(User user1, User user2);

    @POST("/friend/denyRequest")
    void denyFriendRequest(User user1, User user2);

    @GET("./hello")
    Single<String> hello();

}
