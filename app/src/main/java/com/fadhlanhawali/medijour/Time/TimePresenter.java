package com.fadhlanhawali.medijour.Time;

import android.content.Context;

import java.sql.Time;

public class TimePresenter implements TimeContract.Presenter {

    private Context mContext;
    private TimeContract.View mView;

    public TimePresenter(Context context, TimeContract.View view) {
        this.mContext = context;
        this.mView = view;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getLastMedication() {

    }
}
