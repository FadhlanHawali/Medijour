package com.fadhlanhawali.medijour.Home;

import com.fadhlanhawali.medijour.Home.Model.HomeModel;

import java.util.List;

public interface HomeContract {

    interface Presenter{
        void initP();
        void populateData();
    }

    interface View{
        void initV();
        void onPopulateData(List<HomeModel> homeModelList);
    }
}
