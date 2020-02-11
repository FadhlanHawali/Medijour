package com.fadhlanhawali.medijour.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.Home.Model.HomeModel;
import com.fadhlanhawali.medijour.R;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View{

    private HomeContract.Presenter mPresenter;
    private HomeAdapter homeAdapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mPresenter = new HomePresenter(getContext(),this);
        recyclerView = root.findViewById(R.id.recyclerView);
        mPresenter.initP();

        return root;
    }

    @Override
    public void initV() {
        homeAdapter = new HomeAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeAdapter);

        mPresenter.populateData();
    }

    @Override
    public void onPopulateData(List<HomeModel> homeModelList) {
        homeAdapter.setHomeModelList(homeModelList);
    }
}