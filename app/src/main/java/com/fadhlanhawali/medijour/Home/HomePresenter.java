package com.fadhlanhawali.medijour.Home;

import android.content.Context;

import com.fadhlanhawali.medijour.Home.Model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.Presenter {

    private final Context mContext;
    HomeContract.View mView;

    public HomePresenter(Context mContext, HomeContract.View mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void populateData() {
        List<HomeModel> homeModelList = new ArrayList<>();

        for(int i = 0; i<5 ; i++){
            HomeModel homeModel = new HomeModel(
                    "Judul "+i,
                    "http:",
                    "content "+i
            );
            homeModelList.add(homeModel);
        }

        mView.onPopulateData(homeModelList);
    }
}
