package com.fadhlanhawali.medijour.Time.AddAlarm;

import android.content.Context;

import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;
import com.fadhlanhawali.medijour.Time.Alarm.AlarmContract;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

public class AddAlarmPresenter implements AlarmContract.AddAlarmPresenter {

    private Context mContext;
    private AlarmContract.AddAlarmView mView;
    private AlarmDao alarmDao;

    public AddAlarmPresenter(Context mContext, AlarmContract.AddAlarmView mView, AlarmDao alarmDao) {
        this.mContext = mContext;
        this.mView = mView;
        this.alarmDao = alarmDao;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void addAlarm(AlarmModel alarmModel) {
        alarmDao.insertAlarm(alarmModel);
        mView.onAddAlarm();
    }
}
