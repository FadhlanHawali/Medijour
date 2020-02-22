package com.fadhlanhawali.medijour.Time;

import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.util.List;

public interface TimeContract {
    interface View{
        void initV();

        void onGetLastMedication(List<TimeModel> timeModelList);

    }

    interface Presenter{
        void initP();

        void getLastMedication();

    }
}
