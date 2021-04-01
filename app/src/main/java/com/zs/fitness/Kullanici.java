package com.zs.fitness;

public class Kullanici {
    int id;
    String kadi;
    String cinsiyet;
    int boy;
    int kilo;
    public Kullanici()
    {}
    public Kullanici(int id,String kadi,String cinsiyet,int boy,int kilo)
    {
        this.id=id;
        this.kadi=kadi;
        this.cinsiyet=cinsiyet;
        this.boy=boy;
        this.kilo=kilo;
    }
    public Kullanici(String kadi,String cinsiyet,int boy,int kilo)
    {
        this.kadi=kadi;
        this.cinsiyet=cinsiyet;
        this.boy=boy;
        this.kilo=kilo;
    }

    public int getBoy() {
        return boy;
    }

    public int getKilo() {
        return kilo;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public String getKadi() {
        return kadi;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
