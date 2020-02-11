package com.fadhlanhawali.medijour.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.Home.Model.HomeModel;
import com.fadhlanhawali.medijour.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context mContext;
    private List<HomeModel> homeModelList;
    public TextView tvTitle, tvContent;
    public ImageView ivInfo;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(final View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvContent = view.findViewById(R.id.tvContent);
            ivInfo = view.findViewById(R.id.ivInfo);
        }

    }

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setHomeModelList(List<HomeModel> homeModelList) {
        this.homeModelList = homeModelList;
        notifyDataSetChanged();
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_home, parent, false);

        return new HomeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HomeAdapter.MyViewHolder holder, final int position) {
        tvTitle.setText(homeModelList.get(position).getTitle());
        tvContent.setText(homeModelList.get(position).getTextContent());
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

}
