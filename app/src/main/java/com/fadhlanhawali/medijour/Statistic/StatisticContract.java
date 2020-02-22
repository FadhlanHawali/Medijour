package com.fadhlanhawali.medijour.Statistic;

import com.anychart.chart.common.dataentry.DataEntry;
import com.fadhlanhawali.medijour.Statistic.Model.StatisticModel;

import java.util.List;

public interface StatisticContract {

    interface View{
        void initV();

        void onGetChartData(List<DataEntry> statisticModelList);

    }

    interface Presenter{
        void initP();

        void getChartData();

    }

}
