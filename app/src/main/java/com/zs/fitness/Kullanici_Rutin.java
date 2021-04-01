package com.zs.fitness;

public class Kullanici_Rutin {
    int kullaniciid;
    String tarih;
    int rutinid;
    int kcal;
    String sure;
    Routines rutin;
    Kullanici kullanici;

    public void Kullanici_Rutin(){}
    public  void  Kullanici_Rutin(int kullaniciid,String tarih,int rutinid,int kcal,String sure)
    {
        this.kcal=kcal;
        this.kullaniciid=kullaniciid;
        this.rutinid=rutinid;
        this.sure=sure;
        this.tarih=tarih;
    }
    public  void  Kullanici_Rutin(String tarih,int kcal,String sure,Kullanici kullanici,Routines rutin)
    {
        this.kcal=kcal;
        this.kullanici=kullanici;
        this.rutin=rutin;
        this.sure=sure;
        this.tarih=tarih;
    }

}
