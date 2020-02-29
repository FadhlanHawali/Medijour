package com.fadhlanhawali.medijour.Database.Converter;

import android.util.SparseBooleanArray;

import androidx.room.TypeConverter;

import com.fadhlanhawali.medijour.Time.Model.Day;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;

public class AlarmArrayConverter implements Serializable {

    @TypeConverter
    public static String alarmDayToString(Day day){
        return new Gson().toJson(day);
    }

    @TypeConverter
    public static Day stringToAlarmDay (String day){
        return new Gson().fromJson(day, Day.class);
    }
}
