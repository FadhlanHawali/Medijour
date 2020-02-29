package com.fadhlanhawali.medijour.Time.Alarm;

import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

import java.util.List;

public interface AlarmContract {

    interface View{
        void initV();

        void onGetAlarm(List<AlarmModel> alarmModels);
    }

    interface Presenter{
        void initP();

        void getAlarm();
    }

    interface AddAlarmView{
        void initV();

        void onAddAlarm();
    }

    interface AddAlarmPresenter{
        void initP();

        void addAlarm(AlarmModel alarmModel);
    }

}
