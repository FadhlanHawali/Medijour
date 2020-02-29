package com.fadhlanhawali.medijour.SignUp;

import android.content.Context;

import com.fadhlanhawali.medijour.Database.DAO.UserDao;
import com.fadhlanhawali.medijour.Login.UserModel;

public class SignUpPresenter implements SignUpContract.Presenter {

    private Context mContext;
    private SignUpContract.View mView;
    private UserDao userDao;

    public SignUpPresenter(Context mContext, SignUpContract.View mView, UserDao userDao) {
        this.mContext = mContext;
        this.mView = mView;
        this.userDao = userDao;
    }

    @Override
    public void addUser(UserModel userModel) {
        userDao.insertUser(userModel);
        mView.onAddUser();
    }

    @Override
    public void initP() {
        mView.initV();
    }
}
