package com.zs.fitness;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class DinlenmeActivity extends AppCompatActivity {
    ArrayList<Integer> array_egzersiz;
    CountDownTimer cc;
    long sure=30000;//25 sn
    long sureekleme=0;
    ArrayList<Works> worksArray =new ArrayList<Works>();
    public  int  sira=1;
    public int kapasite=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinlenme);
        final TextView gerisayimtext = (TextView) findViewById(R.id.textView_geri_sayim2);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            array_egzersiz=bundle.getIntegerArrayList("egzersizlistesi");
            sira = bundle.getInt("sira");
            worksArray= (ArrayList<Works>) bundle.getSerializable("Works");
        }

        final ProgressBar prgbar =(ProgressBar)findViewById(R.id.progressBar);
        int isure=(int)sure;
        prgbar.setMax(isure/1000);
       /*  cc =new CountDownTimer(sure, 1000) {

            public void onTick(long millisUntilFinished) {
                gerisayimtext.setText( ""+millisUntilFinished / 1000);
                int saniye=(int)millisUntilFinished/1000;
                prgbar.setProgress(saniye);
                if (sureekleme==1)
                {
                    millisUntilFinished=millisUntilFinished+20000;

                }
            }

            public void onFinish() {
                ///*  gerisayimtext.setText("done!");

                bitme();
            }
        };
         */
        // cc.start();
        kapasite=array_egzersiz.size();
Egzersiz siradakiegzersiz=readDBdata_egzersiz(array_egzersiz.get(sira));
TextView txt_sirada_egzersiz = (TextView)findViewById(R.id.textView_siradakiegzersiz);
        TextView txt_sira = (TextView)findViewById(R.id.textView_sira);
        TextView txt_tekrar = (TextView)findViewById(R.id.textView4);
txt_sirada_egzersiz.setText(siradakiegzersiz.get_title());
        Works wd=worksArray.get(sira);
        txt_tekrar.setText("X"+Integer.toString(wd.get_works_reps()));


        Egzersiz_Resmi(siradakiegzersiz.get_png1resid(),siradakiegzersiz.get_png2resid());

txt_sira.setText("NEXT "+(sira+1)+"/"+array_egzersiz.size());
        final CountDownTimerWithPause times=new CountDownTimerWithPause(sure+sureekleme,1000,true) {
            @Override
            public void onTick(long millisUntilFinished) {
                long sure=millisUntilFinished/1000;
                gerisayimtext.setText( ""+sure);
            }

            @Override
            public void onFinish() {
bitme();
            }
        };
        times.create();

        final Button btn_sureekle=(Button)findViewById(R.id.button_artisaniye);
        btn_sureekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long kalansure=times.timeLeft();
times.cancel();
        times.setmMillisInFuture(kalansure+20000);
        btn_sureekle.setEnabled(false);
times.create();
               // cc.cancel();
               // cc.start();
            }
        });

        final Button btn_skip=(Button)findViewById(R.id.button3);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // long sure=1000;
              //  cc.cancel();
               // bitme();
                times.cancel();
                bitme();
            }
        });

    }

    public void bitme(){

            Intent myIntent = new Intent(DinlenmeActivity.this, WorksActivity.class);

            myIntent.putIntegerArrayListExtra("egzersizlistesi",array_egzersiz);
            myIntent.putExtra("sira",sira);
        myIntent.putExtra("Works",worksArray);
            try {
                startActivity(myIntent);
                finish();
            }
            catch (Exception e)
            {

            }



    }
    public Egzersiz  readDBdata_egzersiz(int egzersiz_id) {
        Egzersiz egzersiz = new Egzersiz(egzersiz_id,"","","",null,null,null,null,null,null,null,null);
        String egzersiz_adi="";
        veritabani dbh = new veritabani(this);

        SQLiteDatabase db = dbh.getReadableDatabase();
        String[] misal = {Integer.toString(egzersiz_id)};
        Cursor cursor = db.rawQuery("SELECT * FROM egzersiz  WHERE id = ?"
                , misal);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String ad = cursor.getString((cursor.getColumnIndex("name")));
                String baslik = cursor.getString((cursor.getColumnIndex("title")));
                String primer = cursor.getString((cursor.getColumnIndex("primer")));
                String primary = cursor.getString((cursor.getColumnIndex("ana_kas")));
                String ekipman = cursor.getString((cursor.getColumnIndex("equipment")));
                String tip = cursor.getString((cursor.getColumnIndex("type")));
                String yankas = cursor.getString((cursor.getColumnIndex("secondary")));
                String png1 = cursor.getString((cursor.getColumnIndex("png1")));
                String png2 = cursor.getString((cursor.getColumnIndex("png2")));
                String png3 = cursor.getString((cursor.getColumnIndex("png3")));
                String steps = cursor.getString((cursor.getColumnIndex("steps")));
                String tips = cursor.getString((cursor.getColumnIndex("tips")));
                egzersiz = new Egzersiz(id,ad,primary,yankas,steps,ekipman,primer,png1,png2,png3,tips,baslik);
                int png1resID = getResources().getIdentifier(png1 , "drawable" ,
                        getPackageName()) ;
                	egzersiz.set_png1resid(png1resID);
                int png2resID = getResources().getIdentifier(png2 , "drawable" ,
                        getPackageName()) ;
                	egzersiz.set_png2resid(png2resID);





            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {

            cursor.close();

        }

        db.close();
        return egzersiz;

    }
    String dils= Locale.getDefault().getDisplayCountry().toString();
    String cikmasoru="";
    String cevapevt="";
    String cevaphyr="";

    @Override
    public void onBackPressed() {
        if(dils=="tr")
        {
            cikmasoru = "Çıkmak istiyor musunuz?";
            cevapevt="Evet";
            cevaphyr="Hayır";
        }
        else{
            cikmasoru = "Do you want to close?";
            cevapevt="Yes";
            cevaphyr="No";
        }
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Workout")
                .setMessage(cikmasoru)
                .setPositiveButton(cevapevt, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(cevaphyr, null)
                .show();
    }
    public void Egzersiz_Resmi(int resim1,int resim2)
    {

        final ImageView wegzersiz_resim = (ImageView) findViewById(R.id.imageView4);


        if (resim1 != 0 && resim2 != 0) {
            final int[] imageArray = { resim1, resim2 };

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {
                    wegzersiz_resim.setImageResource(imageArray[i]);
                    i++;
                    if (i > imageArray.length - 1) {
                        i = 0;
                    }
                    handler.postDelayed(this, 750); // for interval...
                }
            };
            handler.postDelayed(runnable, 100); // for initial delay..
        } else {
            if (resim1 != 0 && resim2 == 0) {
                wegzersiz_resim.setImageResource(resim1);
            } else {
                wegzersiz_resim.setImageResource(R.drawable.ic_done_black_24dp);
            }
        }
    }


}
