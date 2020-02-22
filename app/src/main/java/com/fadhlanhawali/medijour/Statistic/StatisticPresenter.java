package com.fadhlanhawali.medijour.Statistic;

import android.content.Context;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.fadhlanhawali.medijour.Statistic.Model.StatisticModel;

import java.util.ArrayList;
import java.util.List;

public class StatisticPresenter implements StatisticContract.Presenter{
    StatisticContract.View mView;
    Context mContext;

    public StatisticPresenter(Context mContext, StatisticContract.View mView) {
        this.mView = mView;
        this.mContext = mContext;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getChartData() {
        List<DataEntry> statisticModelList = new ArrayList<>();

        statisticModelList.add(new ValueDataEntry(
                "Senin",1
        ));
        statisticModelList.add(new ValueDataEntry(
                "Selasa",4
        ));
        statisticModelList.add(new ValueDataEntry(
                "Rabu",5
        ));
        statisticModelList.add(new ValueDataEntry(
                "Kamis",2
        ));
        statisticModelList.add(new ValueDataEntry(
                "Jumat",8
        ));
        statisticModelList.add(new ValueDataEntry(
                "Sabtu",3
        ));


        mView.onGetChartData(statisticModelList);
    }
}
