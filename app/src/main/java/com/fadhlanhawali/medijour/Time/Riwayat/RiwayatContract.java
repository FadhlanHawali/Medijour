package com.fadhlanhawali.medijour.Time.Riwayat;

import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.util.List;

public interface RiwayatContract {

    interface View{
        void initV();

        void onGetLastMedication(List<TimeModel> timeModelList);
    }

    interface Presenter{
        void initP();

        void getLastMedication();
    }

}
