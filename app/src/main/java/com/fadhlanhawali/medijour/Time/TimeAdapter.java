package com.fadhlanhawali.medijour.Time;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.ConvertDate;
import com.fadhlanhawali.medijour.Home.Model.HomeModel;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.Model.TimeModel;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {

    private Context mContext;
    private List<TimeModel> timeModelList;
    public TextView tvTimeMedication,tvDateMedication;
    public ImageView ivFlagMedication;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(final View view) {
            super(view);
            tvTimeMedication = view.findViewById(R.id.tvTimeMedication);
            ivFlagMedication = view.findViewById(R.id.ivFlagMedication);
            tvDateMedication = view.findViewById(R.id.tvDateMedication);
        }

    }

    public TimeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setTimeModelList(List<TimeModel> timeModelList) {
        this.timeModelList = timeModelList;
        notifyDataSetChanged();
    }


    @Override
    public TimeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_time, parent, false);

        return new TimeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TimeAdapter.MyViewHolder holder, final int position) {
        ConvertDate convertDate = new ConvertDate();
        tvDateMedication.setText(convertDate.convertComplete(timeModelList.get(position).getMedicationTime()));
        tvTimeMedication.setText(convertDate.convertTime(timeModelList.get(position).getMedicationTime()));
    }

    @Override
    public int getItemCount() {
        return timeModelList.size();
    }

}
