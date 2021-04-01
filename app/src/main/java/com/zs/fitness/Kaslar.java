package com.zs.fitness;

import java.util.ArrayList;
import java.util.Locale;



public class Kaslar {

    private String KaslarName;
    private String KaslarDescription;
    private int imageID;
    private int KasAdi;

    public Kaslar() {
    }

    public Kaslar(int imageID, String KaslarName, String KaslarDescription,int Kas2Adi) {
        this.imageID = imageID;
        this.KaslarName = KaslarName;
        this.KaslarDescription = KaslarDescription;
        this.KasAdi=Kas2Adi;
    }


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getKaslarName() {
        return KaslarName;
    }
    public int getKaslarAdi() {
        return KasAdi;
    }
    public void setKaslarName(String KaslarName) {
        this.KaslarName = KaslarName;
    }

    public void setKaslarAdi(int KaslarName) {
        this.KasAdi = KaslarName;
    }
    public String getKaslarDescription() {
        return KaslarDescription;
    }

    public void setKaslarDescription(String KaslarDescription) {
        this.KaslarDescription = KaslarDescription;
    }

    public static ArrayList<Kaslar> getData() {
        ArrayList<Kaslar> KaslarList = new ArrayList<Kaslar>();
        String[] KaslarNames = {"Triceps", "Biceps", "Back","Hamstrings","Quads","Lats","Shoulders","Chest","Abdominals","Calves","Glutes","Traps","All"};
        String[] KaslarNames_tr = {"Arkakol", "Önkol", "Sırt","Arkabacak","Önbacak","Kanat","Omuz","Göğüs","Karın","Kalfler","Kalça","Boyun","Hepsi"};
        int KaslarImages[] = {R.drawable.karin, R.drawable.sirt, R.drawable.biceps,R.drawable.gogus,R.drawable.omuz,R.drawable.kalf,R.drawable.triceps_kare,R.drawable.onbacak,R.drawable.arkabacak,R.drawable.kalca,R.drawable.lats,R.drawable.traps,R.drawable.hepsi};
int KasAdi[] ={R.string.abs,R.string.back,R.string.biceps,R.string.chests,R.string.shoulders,R.string.calves,R.string.tciceps,R.string.upperlegs,R.string.lowerlegs,R.string.glutes,R.string.lats,R.string.traps,R.string.all_kas};
        for (int i = 0; i < KaslarImages.length; i++) {
            Kaslar temp = new Kaslar();
            temp.setImageID(KaslarImages[i]);

                temp.setKaslarName(KaslarNames[i]);


            temp.setKaslarDescription("Fitness");
temp.setKaslarAdi(KasAdi[i]);
            KaslarList.add(temp);

        }


        return KaslarList;


    }
}