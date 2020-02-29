package com.fadhlanhawali.medijour.Time.Riwayat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.util.List;

public class RiwayatFragment extends Fragment implements RiwayatContract.View{

    private RiwayatAdapter riwayatAdapter;
    RecyclerView recyclerView;
    RiwayatContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_riwayat, container, false);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        recyclerView = v.findViewById(R.id.recyclerView);
        mPresenter = new RiwayatPresenter(getContext(),this);
        mPresenter.initP();

        return v;
    }

    @Override
    public void initV() {
        riwayatAdapter = new RiwayatAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(riwayatAdapter);
        mPresenter.getLastMedication();
    }

    @Override
    public void onGetLastMedication(List<TimeModel> timeModelList) {
        riwayatAdapter.setTimeModelList(timeModelList);
    }
}
