package com.fadhlanhawali.medijour.Time.AddAlarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;

import com.fadhlanhawali.medijour.Database.AppDatabase;
import com.fadhlanhawali.medijour.Database.DAO.AlarmDao;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.Time.Alarm.AlarmContract;
import com.fadhlanhawali.medijour.Time.Model.AlarmModel;
import com.fadhlanhawali.medijour.Utils.TimePickerUtils;

public class AlarmActivity extends AppCompatActivity implements AlarmContract.AddAlarmView {

    CheckBox cbSunday,cbMonday,cbTuesday,cbWednesday,cbThursday,cbFriday,cbSaturday;
    Button btSimpan, btBatal;
    EditText etLabel;
    TimePicker tpTime;
    AlarmContract.AddAlarmPresenter mPresenter;
    AlarmDao alarmDao;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        mDb = AppDatabase.getDatabase(this);
        alarmDao = mDb.alarmDao();
        mPresenter = new AddAlarmPresenter(this,this,alarmDao);

        mPresenter.initP();
    }

    @Override
    public void initV() {
        cbSunday = findViewById(R.id.cbSunday);
        cbMonday = findViewById(R.id.cbMonday);
        cbTuesday = findViewById(R.id.cbTuesday);
        cbWednesday = findViewById(R.id.cbWednesday);
        cbThursday = findViewById(R.id.cbThursday);
        cbFriday = findViewById(R.id.cbFriday);
        cbSaturday = findViewById(R.id.cbSaturday);

        btSimpan = findViewById(R.id.btSimpan);
        btBatal = findViewById(R.id.btBatal);

        etLabel = findViewById(R.id.etAlarmLabel);

        tpTime = findViewById(R.id.tpTime);

        TimePickerUtils.setTimePickerTime(tpTime, System.currentTimeMillis());
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onAddAlarm() {

    }
}
