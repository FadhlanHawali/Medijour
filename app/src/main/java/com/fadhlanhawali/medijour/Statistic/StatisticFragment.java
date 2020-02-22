package com.fadhlanhawali.medijour.Statistic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Statistic.Model.StatisticModel;

import java.util.List;

public class StatisticFragment extends Fragment implements StatisticContract.View{

    StatisticContract.Presenter mPresenter;
    AnyChartView anyChartView;
    Cartesian cartesian;
    Column column;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_statistic, container, false);

        mPresenter = new StatisticPresenter(getContext(),this);
        anyChartView = root.findViewById(R.id.any_chart_view);

        mPresenter.initP();

        return root;
    }

    @Override
    public void initV() {

        mPresenter.getChartData();
    }

    @Override
    public void onGetChartData(List<DataEntry> statisticModelList) {
        cartesian = AnyChart.column();
        column = cartesian.column(statisticModelList);
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Pemakaian obat");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Hari");
        cartesian.yAxis(0).title("Pemakaian");

        anyChartView.setChart(cartesian);
    }
}