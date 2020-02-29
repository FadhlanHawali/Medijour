package com.fadhlanhawali.medijour.Time.Alarm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.ConvertDate;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

import java.util.ArrayList;
import java.util.List;

public class AlarmAdapter  extends RecyclerView.Adapter<AlarmAdapter.MyViewHolder> {

    private Context mContext;
    private List<AlarmModel> alarmModels;
    ConvertDate convertDate = new ConvertDate();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtUsername, txtLastChat, txtLastMessageTimestamp,txtUnreadChatCount;
        public ImageView imgProfile;
        public LinearLayout linearLayoutChat;
        public MyViewHolder(final View view) {
            super(view);

        }

    }

    public AlarmAdapter(Context mContext) {
        this.mContext = mContext;
        alarmModels = new ArrayList<>();
    }

    @Override
    public AlarmAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_alarm, parent, false);

        return new AlarmAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AlarmAdapter.MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return alarmModels.size();
    }

    public void setChatRoomList(List<AlarmModel> chatRoomList) {
        this.alarmModels = chatRoomList;
        notifyDataSetChanged();
    }

}
