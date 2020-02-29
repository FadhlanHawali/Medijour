package com.fadhlanhawali.medijour.Time.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Day implements Parcelable {
    private boolean sunday;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thrusday;
    private boolean friday;
    private boolean saturday;

    public Day(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thrusday, boolean friday, boolean saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thrusday = thrusday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThrusday() {
        return thrusday;
    }

    public void setThrusday(boolean thrusday) {
        this.thrusday = thrusday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.sunday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.monday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.tuesday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.wednesday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.thrusday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.friday ? (byte) 1 : (byte) 0);
        dest.writeByte(this.saturday ? (byte) 1 : (byte) 0);
    }

    protected Day(Parcel in) {
        this.sunday = in.readByte() != 0;
        this.monday = in.readByte() != 0;
        this.tuesday = in.readByte() != 0;
        this.wednesday = in.readByte() != 0;
        this.thrusday = in.readByte() != 0;
        this.friday = in.readByte() != 0;
        this.saturday = in.readByte() != 0;
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
