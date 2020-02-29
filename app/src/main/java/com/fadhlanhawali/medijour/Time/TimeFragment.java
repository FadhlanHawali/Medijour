package com.fadhlanhawali.medijour.Time;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.Alarm.AlarmFragment;
import com.fadhlanhawali.medijour.Time.Model.TimeModel;
import com.fadhlanhawali.medijour.Time.Riwayat.RiwayatFragment;
import com.fadhlanhawali.medijour.Time.Riwayat.RiwayatAdapter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeFragment extends Fragment implements TimeContract.View{

    private TimeContract.Presenter mPresenter;
    private TextView tvTimeMedication;

    private RecyclerView recyclerView;
    private Button btRiwayat, btDaftarAlarm;
    Date date;

    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_time, container, false);
        mPresenter = new TimePresenter(getContext(),this);
        recyclerView = root.findViewById(R.id.recyclerView);
        tvTimeMedication = root.findViewById(R.id.tvTimeMedication);
        tvTimeMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DialogFragment newFragment = new SetTimeFragment();
//                newFragment.show(getChildFragmentManager(), "datepicker");
                showDatePicker();

            }
        });
        loadFragment(new RiwayatFragment());
        btDaftarAlarm = root.findViewById(R.id.btDaftarAlarm);
        btRiwayat = root.findViewById(R.id.btRiwayat);

        btRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundResource(R.drawable.button_pressed_left);
                Fragment fragment = new RiwayatFragment();
                loadFragment(fragment);
                view.setBackgroundResource(R.drawable.button_pressed_left);
                btDaftarAlarm.setBackgroundResource(R.drawable.button_unpressed_right);
            }
        });

        btDaftarAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AlarmFragment();
                loadFragment(fragment);
                if (view.getId() == R.id.btDaftarAlarm) {// toggle the boolean flag
                    view.setBackgroundResource(R.drawable.button_pressed_right);
                    btRiwayat.setBackgroundResource(R.drawable.button_unpressed_left);

                }
            }
        });

        mPresenter.initP();
        return root;
    }

    public void setDate(Date date){
       this.date = date;
        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initV() {

    }

    private void showDatePicker() {
        SetDateFragment date = new SetDateFragment();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(onDate);
        date.show(getChildFragmentManager(), "Date Picker");

    }

    private void showTimePicker() {
        SetTimeFragment date = new SetTimeFragment();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("hour", calender.get(Calendar.YEAR));
        args.putInt("minute", calender.get(Calendar.MONTH));
        args.putInt("second", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(onTime);
        date.show(getChildFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener onDate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Toast.makeText(getContext(), "Date : " + year + "/" + monthOfYear + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();
            showTimePicker();
        }
    };

    TimePickerDialog.OnTimeSetListener onTime = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Toast.makeText(getContext(), "Time : " + i + ":" + i1, Toast.LENGTH_SHORT).show();

        }
    };


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flTime, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}