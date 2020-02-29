package com.fadhlanhawali.medijour.SignUp;

import com.fadhlanhawali.medijour.BasePresenter;
import com.fadhlanhawali.medijour.BaseView;
import com.fadhlanhawali.medijour.Login.UserModel;

public interface SignUpContract {

    interface View extends BaseView {
        void onAddUser();
    }

    interface Presenter extends BasePresenter{
        void addUser(UserModel userModel);
    }
}
