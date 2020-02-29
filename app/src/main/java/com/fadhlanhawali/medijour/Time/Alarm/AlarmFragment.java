package com.fadhlanhawali.medijour.Time.Alarm;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.Database.AppDatabase;
import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.AddAlarm.AlarmActivity;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AlarmFragment extends Fragment implements AlarmContract.View {

    private FloatingActionButton floatingActionButton;
    private AlarmContract.Presenter mPresenter;
    private RecyclerView recyclerView;
    private AppDatabase mDb;
    private AlarmDao alarmDao;
    private AlarmAdapter alarmAdapter;
    private TextView tvEmptyList;
    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        floatingActionButton = v.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AlarmActivity.class);
                startActivity(i);
            }
        });
        mDb = AppDatabase.getDatabase(getContext());
        alarmDao = mDb.alarmDao();
        mPresenter = new AlarmPresenter(getContext(),this, alarmDao);
        recyclerView = v.findViewById(R.id.recyclerView);
        tvEmptyList = v.findViewById(R.id.tvEmptyList);

        alarmAdapter = new AlarmAdapter(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(alarmAdapter);

        mPresenter.initP();

        return v;
    }

    @Override
    public void initV() {
        mPresenter.getAlarm();
        if (alarmAdapter.getItemCount() == 0){
            tvEmptyList.setVisibility(View.VISIBLE);
        }else {
            tvEmptyList.setVisibility(View.GONE);
        }
    }

    @Override
    public void onGetAlarm(List<AlarmModel> alarmModels) {
        alarmAdapter.setChatRoomList(alarmModels);
    }
}
