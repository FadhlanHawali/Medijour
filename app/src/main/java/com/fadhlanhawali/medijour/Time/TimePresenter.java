package com.fadhlanhawali.medijour.Time;

import android.app.AlarmManager;
import android.content.Context;

import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
}
