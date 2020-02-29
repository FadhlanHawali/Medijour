package com.fadhlanhawali.medijour.Database.Converter;

import android.util.SparseBooleanArray;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class AlarmConverter implements Serializable {


    @TypeConverter public static SparseBooleanArray stringToSparseBooleanArray(String sparseBooleanArray){
        Gson gson = new Gson();
//        Type mapType = new Ty<>().getType();
        Type type = new TypeToken<SparseBooleanArray>() {}.getType();
        return gson.fromJson(sparseBooleanArray, type);
    }

    @TypeConverter public static String sparseBooleanArrayToString(SparseBooleanArray sparseBooleanArray){
        Gson gson= new Gson();
        return gson.toJson(sparseBooleanArray);
    }
}
