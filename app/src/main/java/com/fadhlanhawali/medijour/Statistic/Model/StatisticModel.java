package com.fadhlanhawali.medijour.Statistic.Model;

public class StatisticModel {
    private Integer pemakaian;
    private String hari;

    public StatisticModel(Integer pemakaian, String hari) {
        this.pemakaian = pemakaian;
        this.hari = hari;
    }

    public Integer getPemakaian() {
        return pemakaian;
    }

    public void setPemakaian(Integer pemakaian) {
        this.pemakaian = pemakaian;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }
}
