package com.fadhlanhawali.medijour.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface AlarmDao {


    @Query("SELECT * FROM list_alarm")
    List<AlarmModel> getListAlarm();

    @Insert(onConflict = REPLACE)
    void insertAlarm(AlarmModel alarmModel);

//    @Insert(onConflict = REPLACE)
//    void insertRoomChatReplace(DataItem listRoomChat);

    @Query("DELETE FROM list_alarm")
    void deleteAll();

    @Query("SELECT * FROM list_alarm Where id=:id")
    AlarmModel findAlarm(String id);

    @Delete
    void deleteAlarm(AlarmModel listRoomChat);

}
