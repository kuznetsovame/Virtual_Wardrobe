package com.example.virtualwardrobe.network;

import com.example.virtualwardrobe.model.User;

import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WardrobeApi {

    @POST("/user/reg")

    void regUser(User user);

    @GET("/user/auth")
    User authUser(User user);

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

}
