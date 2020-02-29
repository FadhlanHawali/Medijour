package com.fadhlanhawali.medijour.Login;

import com.fadhlanhawali.medijour.BasePresenter;
import com.fadhlanhawali.medijour.BaseView;

public interface LoginContract {

    interface View extends BaseView{
        void onCheckUsername(Boolean flag);
    }

    interface Presenter extends BasePresenter{
        void checkUsername(String username);
    }
}
