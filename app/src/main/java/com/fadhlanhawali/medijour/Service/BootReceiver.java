package com.fadhlanhawali.medijour.Service;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.content.Intent.ACTION_BOOT_COMPLETED;

/**
 * Re-schedules all stored alarms. This is necessary as {@link AlarmManager} does not persist alarms
 * between reboots.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Executors.newSingleThreadExecutor().execute(() -> {
//                final List<AlarmModel> alarms = AppDatabase.getDatabase(context).alarmDao().getListAlarm();
//                setReminderAlarms(context, alarms);
//            });
        }
    }

}
