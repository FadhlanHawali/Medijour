package com.fadhlanhawali.medijour.Time.Alarm;

import android.content.Context;

import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;

public class AlarmPresenter implements AlarmContract.Presenter {

    private Context mContext;
    private AlarmContract.View mView;
    private AlarmDao alarmDao;

    public AlarmPresenter(Context mContext, AlarmContract.View mView, AlarmDao alarmDao) {
        this.mContext = mContext;
        this.mView = mView;
        this.alarmDao = alarmDao;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getAlarm() {
        mView.onGetAlarm(alarmDao.getListAlarm());
    }
}
