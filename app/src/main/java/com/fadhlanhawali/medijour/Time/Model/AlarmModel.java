package com.fadhlanhawali.medijour.Time.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.fadhlanhawali.medijour.Database.Converter.AlarmArrayConverter;
import com.fadhlanhawali.medijour.Database.Converter.AlarmConverter;
import com.fadhlanhawali.medijour.Login.UserModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Entity(tableName = "list_alarm",foreignKeys = @ForeignKey(
        entity = UserModel.class,
        parentColumns = "id",
        childColumns = "idUser"))
public class AlarmModel implements Parcelable {

    @PrimaryKey @NonNull
    private long id;
    @ColumnInfo(index = true)
    private int idUser;
    private long time;
    private String label;
    @TypeConverters(AlarmArrayConverter.class)
    private Day allDays;
    private boolean isEnabled;

    public AlarmModel(long id, int idUser, long time, String label, Day allDays, boolean isEnabled) {
        this.id = id;
        this.idUser = idUser;
        this.time = time;
        this.label = label;
        this.allDays = allDays;
        this.isEnabled = isEnabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Day getAllDays() {
        return allDays;
    }

    public void setAllDays(Day allDays) {
        this.allDays = allDays;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.idUser);
        dest.writeLong(this.time);
        dest.writeString(this.label);
        dest.writeParcelable(this.allDays, flags);
        dest.writeByte(this.isEnabled ? (byte) 1 : (byte) 0);
    }

    protected AlarmModel(Parcel in) {
        this.id = in.readLong();
        this.idUser = in.readInt();
        this.time = in.readLong();
        this.label = in.readString();
        this.allDays = in.readParcelable(Day.class.getClassLoader());
        this.isEnabled = in.readByte() != 0;
    }

    public static final Creator<AlarmModel> CREATOR = new Creator<AlarmModel>() {
        @Override
        public AlarmModel createFromParcel(Parcel source) {
            return new AlarmModel(source);
        }

        @Override
        public AlarmModel[] newArray(int size) {
            return new AlarmModel[size];
        }
    };
}
