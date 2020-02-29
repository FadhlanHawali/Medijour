package com.fadhlanhawali.medijour;

import android.content.Context;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.fadhlanhawali.medijour.Database.AppDatabase;
import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;
import com.fadhlanhawali.medijour.Database.DAO.UserDao;
import com.fadhlanhawali.medijour.Login.UserModel;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;
import com.fadhlanhawali.medijour.Time.Model.Day;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class DatabaseTest {

    private AlarmDao alarmDao;
    private UserDao userDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        alarmDao = mDb.alarmDao();
        userDao = mDb.userDao();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

        mDb.userDao().deleteAll();

        List<UserModel> listUser = userDao.getListUser();
        assertThat(listUser.size(),equalTo(0));


        userDao.insertUser(new UserModel(
                "Fadhlan"
        ));
        listUser = userDao.getListUser();
        assertThat(listUser.size(),equalTo(1));

    }

    @Test
    public void writeAlarmAndReadInList() throws Exception{

        userDao.insertUser(new UserModel(
                "Fadhlan"
        ));

        alarmDao.insertAlarm(new AlarmModel(
                1,
                1,
                System.currentTimeMillis(),
                "Ini alarm",
                new Day(
                        true,false,true,false,true,false,true
                ),
                true

        ));

        alarmDao.insertAlarm(new AlarmModel(
                2,
                1,
                System.currentTimeMillis(),
                "Ini alarm",
                new Day(
                        true,false,true,false,true,false,true
                ),
                true

        ));

        List<AlarmModel> listAlarm = alarmDao.getListAlarm();

        assertThat(listAlarm.size(), equalTo(2));
    }


    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    void addUser(AppDatabase mDb, UserModel userModel){
        userDao.insertUser(userModel);
    }

    void addAlarm(AppDatabase mDb, AlarmModel alarmModel){

    }
}
