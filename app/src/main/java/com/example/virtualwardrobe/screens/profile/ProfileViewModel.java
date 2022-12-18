package com.example.virtualwardrobe.screens.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.repository.UserReopository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProfileViewModel extends ViewModel {
    UserReopository userReopository;

    private final MutableLiveData<String> mText;
    private final MutableLiveData<User> user;
    private final MutableLiveData<List<User>> friends;
    public final MutableLiveData<Boolean> isFriend;

    public ProfileViewModel(UserReopository userReopository) {
        mText = new MutableLiveData<>();
        isFriend = new MutableLiveData<>(false );
        mText.setValue("This is home fragment");
        user = new MutableLiveData<>();
        friends = new MutableLiveData<>();
        this.userReopository = userReopository;

    }

    public void addFriend() {
        //wardrobeApi.sendFriedRequest();
    }

    public LiveData<List<User>> getFriends() {
        return friends;
    }

    public LiveData<String> getText() {
        return mText;
    }

//    public List<User> showFriends() {
//        return (List<User>) wardrobeApi.getFriends(new User());
//    }

    public void setUser(User user) {
        this.user.setValue(user);
        User main = userReopository.getMainUser();
        userReopository.getFriends(user)
                .subscribe(users -> {
                    friends.setValue(users);
                    for (User u : friends.getValue()) {
                        if(main.mail.equals(u.mail))
                        {
                            isFriend.setValue(true);
                            break;
                        }
                    }
                });


    }

    public LiveData<User> getUser() {
        return user;
    }

    private void initFirend() {
        if (user.getValue() == null)
            return;
        User value1 = user.getValue();
    }


}