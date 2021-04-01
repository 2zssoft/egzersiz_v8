package com.zs.fitness;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class RutinBaslamaActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    public ArrayList<Egzersiz> egzersizArray = new ArrayList<Egzersiz>();
    public ArrayList<Routines_Works> rutinworkArray = new ArrayList<Routines_Works>();
    ArrayList<Works> worksArrayresim =new ArrayList<Works>();
    ArrayList<Works> worksArray =new ArrayList<Works>();
    public  ArrayList<Integer> array_egzersiz=new ArrayList<Integer>();

    public ArrayList<Egzersiz> getEgzersizArray() {
        return egzersizArray;
    }


// public int temp=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rutin_baslama);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2772878414290299/4522691688");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    @Override
    protected void onResume() {
        super.onResume();
        readDBdata_rutinwork2();
        readDBdata();
        Button button = (Button) findViewById(R.id.button_basla);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RutinBaslamaActivity.this, WorksActivity.class);

                myIntent.putIntegerArrayListExtra("egzersizlistesi",array_egzersiz);
                myIntent.putExtra("sira",0);
               // Works wd=worksArray.get(2);
               // int stsayisi = wd.get_sets();

                try{
                   myIntent.putExtra("Works",worksArray); //sıkıntı burada geçiş yapmıyor . 30.05.2020 1:40
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }

                startActivity(myIntent);
                finish();
            }
        });
    }


    public void readDBdata() {
        Intent intent = getIntent();
        int temp = intent.getIntExtra("id", 0);
        veritabani dbh = new veritabani(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String v_adi = "routines";
        String[] key = { "%" };
     TextView txtbaslik = (TextView)findViewById(R.id.textView_workout_baslik);
        TextView txtseviye = (TextView)findViewById(R.id.textView_seviye);
        TextView txtodak = (TextView)findViewById(R.id.textView_odak);
ImageView imgresim= (ImageView)findViewById(R.id.imageView5); //rutin resim
        Cursor cursor = db.rawQuery("SELECT * FROM " + v_adi
                + " WHERE id="+temp, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString((cursor.getColumnIndex("name")));
                String day = cursor.getString((cursor.getColumnIndex("odakbolgesi")));
                String resim = cursor.getString((cursor.getColumnIndex("resmi")));
                int resID = getResources().getIdentifier(resim , "drawable" ,
                        getPackageName()) ;
                imgresim.setImageResource(resID);
                String seviye = cursor.getString((cursor.getColumnIndex("seviye")));
                txtbaslik.setText(name);
                txtodak.setText(day);
                txtseviye.setText(seviye);


                Routines routines = new Routines(id, name, day,resim,seviye);

            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();


    }
    public void readDBdata_rutinwork2() {
        int toplam_tekrar=0;
        int egzersizsayisi=0;
        int dinlenmetoplam;
        int ilk=0;
        Intent intent = getIntent();
        int temp = intent.getIntExtra("id", 0);
       //Toast.makeText(getApplicationContext(), Integer.toString(temp), Toast.LENGTH_LONG).show();
        veritabani dbh = new veritabani(this);
       //temp=1;
        SQLiteDatabase db = dbh.getReadableDatabase();
        String[] misal = {Integer.toString(temp)};
        Cursor cursor = db.rawQuery("SELECT * FROM routine_works  WHERE routine_id = ?"
                , misal);
        rutinworkArray.clear();
        worksArray.clear();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int rutin_id = cursor.getInt((cursor.getColumnIndex("routine_id")));
                int workid = cursor.getInt((cursor.getColumnIndex("work_id")));
                int sirasi = cursor.getInt((cursor.getColumnIndex("sirasi")));
                Routines_Works rutin_work = new Routines_Works(id, rutin_id, workid, sirasi);
                ///////////////////////////////////////////////
                String[] works_id = {Integer.toString(workid)};
                Cursor cursor_works = db.rawQuery("SELECT * FROM works WHERE id = ?"
                        , works_id);

               if (cursor_works.moveToFirst()) {
                    do {
                        int work_id = cursor_works.getInt(cursor_works.getColumnIndex("id"));
                        int sets = cursor_works.getInt((cursor_works.getColumnIndex("sets")));
                        int reps = cursor_works.getInt((cursor_works.getColumnIndex("reps")));
                        int dinlenme = cursor_works.getInt((cursor_works.getColumnIndex("dinlenme")));
                        int egzersiz_id = cursor_works.getInt((cursor_works.getColumnIndex("egzersiz_id")));
                        Egzersiz egzersiz = readDBdata_egzersiz(egzersiz_id);
                        ilk++;
                        egzersizsayisi++;
                        toplam_tekrar=toplam_tekrar+reps;
                        String egzersizisim=egzersiz.get_title();
                        Works works = new Works(work_id, sets, reps, dinlenme,egzersiz_id, 20,egzersizisim);
                        Works works_resim = new Works(work_id, sets, reps, dinlenme,egzersiz_id, 20,egzersiz);
                       worksArray.add(works);
                       worksArrayresim.add(works_resim);
                       array_egzersiz.add(egzersiz_id);
                    } while (cursor_works.moveToNext());
                }
                if (cursor_works != null && !cursor_works.isClosed()) {
                    cursor_works.close();
                }


                /////////////////////////////////
                rutinworkArray.add(rutin_work);

            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        db.close();


        ListView listemiz = (ListView) findViewById(R.id.liste_rutin_basla);
        WorksAdapter veriAdaptoru = new WorksAdapter(this, R.layout.works_row, worksArrayresim);
        listemiz.setAdapter(veriAdaptoru);
TextView txt_egzersiz_sure=(TextView)findViewById(R.id.textView_zmn);
int toplamsn=(toplam_tekrar*5)+((egzersizsayisi-1)*30);
        int toplamdk=toplamsn/60;
        int kalansn=toplamsn%60;
        String zaman=toplamdk+":"+kalansn;
        txt_egzersiz_sure.setText(zaman);


    }


    public Egzersiz  readDBdata_egzersiz(int egzersiz_id) {

        String egzersiz_adi="";
        Egzersiz egzersiz = new Egzersiz();
        veritabani dbh = new veritabani(this);
       // ImageView egzersizresmi = (ImageView) findViewById(R.id.w_egzersiz_image);
        SQLiteDatabase db = dbh.getReadableDatabase();
        String[] misal = {Integer.toString(egzersiz_id)};
        Cursor cursor = db.rawQuery("SELECT * FROM egzersiz WHERE id = ?"
                , misal);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String ad = cursor.getString((cursor.getColumnIndex("name")));
                String baslik = cursor.getString((cursor.getColumnIndex("title")));
                String primer = cursor.getString((cursor.getColumnIndex("primer")));
                String ana_kas = cursor.getString((cursor.getColumnIndex("ana_kas")));
                String ekipman = cursor.getString((cursor.getColumnIndex("equipment")));
                String tip = cursor.getString((cursor.getColumnIndex("type")));
                String yankas = cursor.getString((cursor.getColumnIndex("secondary")));
                String png1 = cursor.getString((cursor.getColumnIndex("png1")));
                String png2 = cursor.getString((cursor.getColumnIndex("png2")));
                String png3 = cursor.getString((cursor.getColumnIndex("png3")));
                String steps = cursor.getString((cursor.getColumnIndex("steps")));
                String tips = cursor.getString((cursor.getColumnIndex("tips")));
                egzersiz = new Egzersiz(id,ad,ana_kas,yankas,steps,ekipman,primer,png1,png2,png3,tips,baslik);
               int png1resID = getResources().getIdentifier(png1 , "drawable" ,
                        getPackageName()) ;
egzersiz.set_png1resid(png1resID);

                int png2resID = getResources().getIdentifier(png2 , "drawable" ,
                        getPackageName()) ;
                egzersiz.set_png2resid(png2resID);




                egzersiz_adi=baslik;
                egzersizArray.add(egzersiz);


            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {

            cursor.close();

        }

        db.close();
        return egzersiz;

    }



    public class WorksAdapter extends ArrayAdapter<Works> {
        ArrayList<Works> items;

        public WorksAdapter(Context context, int textViewResourceId,
                              ArrayList<Works> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.works_row, null);
            }


            TextView egzersizName = (TextView) convertView.findViewById(R.id.w_egzersiz_name);
            TextView egzersiz_tekrar = (TextView) convertView.findViewById(R.id.txt_rw_reps);
            TextView egzersiz_setler = (TextView) convertView.findViewById(R.id.txt_rw_sets);
            TextView egzersiz_dinlenme = (TextView) convertView.findViewById(R.id.txt_rest);
            ImageView egzersizresmi = (ImageView) convertView.findViewById(R.id.w_egzersiz_image);
            TableRow tablerow = (TableRow) convertView.findViewById(R.id.tableRow1);




            egzersizName.setText(items.get(position).egzersiz.get_title());
            egzersiz_setler.setText(Integer.toString(items.get(position).get_sets()));
            egzersiz_tekrar.setText(Integer.toString(items.get(position).get_works_reps()));
            int id=items.get(position).getegzersiz();
            egzersizresmi.setImageResource(items.get(position).egzersiz.get_png1resid());




            return convertView;

        }


    }

}



