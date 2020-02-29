package com.fadhlanhawali.medijour.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fadhlanhawali.medijour.Login.UserModel;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<UserModel> getListUser();

    @Insert(onConflict = REPLACE)
    void insertUser(UserModel userModel);

    @Query("SELECT * FROM user WHERE username=:username")
    UserModel findUser(String username);

//    @Insert(onConflict = REPLACE)
//    void insertRoomChatReplace(DataItem listRoomChat);

    @Update(onConflict = IGNORE)
    void updateAlarm(AlarmModel listRoomChat);

    @Query("DELETE FROM user")
    void deleteAll();

    @Delete
    void deleteAlarm(AlarmModel listRoomChat);

}
