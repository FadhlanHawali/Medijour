package com.fadhlanhawali.medijour.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.fadhlanhawali.medijour.Database.Converter.AlarmConverter;
import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;
import com.fadhlanhawali.medijour.Database.DAO.UserDao;
import com.fadhlanhawali.medijour.Login.UserModel;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;

@Database(entities = {AlarmModel.class, UserModel.class}, version = 1, exportSchema = false)
@TypeConverters({AlarmConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract AlarmDao alarmDao();
    public abstract UserDao userDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "medijour.db")
                    .allowMainThreadQueries()
                    .addMigrations()
                    .build();
        }
        return INSTANCE;
    }

    public static AppDatabase getMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
