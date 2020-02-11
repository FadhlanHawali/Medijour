package com.fadhlanhawali.medijour.Time;

public interface TimeContract {
    interface View{
        void initV();

        void onGetLastMedication();

    }

    interface Presenter{
        void initP();

        void getLastMedication();

    }
}
