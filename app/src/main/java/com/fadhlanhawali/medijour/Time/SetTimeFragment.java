package com.fadhlanhawali.medijour.Time;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fadhlanhawali.medijour.R;

public class SetTimeFragment extends DialogFragment {
    TimePickerDialog.OnTimeSetListener ondateSet;

    private int hour, minute, second;
    boolean is24hour;

    public SetTimeFragment() {}

    public void setCallBack(TimePickerDialog.OnTimeSetListener ondate) {
        ondateSet = ondate;
    }


    @SuppressLint("NewApi")
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        hour = args.getInt("hour");
        minute = args.getInt("minute");
        second = args.getInt("second");
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), ondateSet, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }
}

