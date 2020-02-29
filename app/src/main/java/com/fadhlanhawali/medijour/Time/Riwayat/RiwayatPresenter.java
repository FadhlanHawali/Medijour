package com.fadhlanhawali.medijour.Time.Riwayat;

import android.content.Context;

import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.util.ArrayList;
import java.util.List;

public class RiwayatPresenter implements RiwayatContract.Presenter {

    private Context mContext;
    private RiwayatContract.View mView;

    public RiwayatPresenter(Context mContext, RiwayatContract.View mView) {
        this.mContext = mContext;
        this.mView = mView;
    }


    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getLastMedication() {
        List<TimeModel> timeModelList = new ArrayList<>();
        for (int i = 0;i<20;i++){
            TimeModel timeModel = new TimeModel(
                    System.currentTimeMillis(),
                    true
            );

            timeModelList.add(timeModel);
        }

        mView.onGetLastMedication(timeModelList);
    }
}
