package com.fadhlanhawali.medijour.Login;

import android.content.Context;

import com.fadhlanhawali.medijour.Database.DAO.UserDao;

public class LoginPresenter implements LoginContract.Presenter {

    private Context mContext;
    private LoginContract.View mView;
    private UserDao userDao;

    public LoginPresenter(Context mContext, LoginContract.View mView, UserDao userDao) {
        this.mContext = mContext;
        this.mView = mView;
        this.userDao = userDao;
    }

    @Override
    public void checkUsername(String username) {
        UserModel userModel = userDao.findUser(username);
        if(userModel == null){
            mView.onCheckUsername(false);
        }else {
            mView.onCheckUsername(true);
        }

    }

    @Override
    public void initP() {
        mView.initV();
    }
}
