package com.zs.fitness;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KayitBoyKiloActivity extends AppCompatActivity {
    private veritabani main;

   // String[] kullanici=getIntent().getStringArrayExtra("kullanici");
    String[] kullanici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_boy_kilo);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                kullanici= null;
            } else {
                kullanici= extras.getStringArray("kullanici");
            }
        } else {
            kullanici= (String[]) savedInstanceState.getSerializable("kullanici");
        }

        final EditText txt_boy = (EditText)findViewById(R.id.editText_boy);
        final EditText txt_kilo = (EditText)findViewById(R.id.editText_kilo);

     Button btn_next=(Button) findViewById(R.id.button_nextbk);
        final Intent i = new Intent(this,MainActivity.class);
        main = new veritabani(this);
     btn_next.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String boy=txt_boy.getText().toString();
             String kilo=txt_kilo.getText().toString();
             kullanici[2]=boy;
             kullanici[3]=kilo;
             KullaniciEkle(boy,kilo);
             startActivity(i);
             finish();
         }
     });
    }

    private void KullaniciEkle(String by,String kl) {
        int boy=0,kilo=0;
        if (by.equals(""))
        {
            boy=0;
        }
        else
        {
            try {
                boy = Integer.parseInt(by);
            }
            catch (Exception e) {

            }
        }
        if (kl.equals(""))
        {
            kilo=0;
        }
        else
        {
            try {
                kilo=Integer.parseInt(kl);
            }
            catch (Exception e)
            {

            }

        }
        SQLiteDatabase db = main.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put("k_adi", kullanici[0]);
        values.put("cinsiyet", kullanici[1]);
        values.put("boy", boy);
        values.put("kilo", kilo);
// Inserting Row
            db.insert("kullanici", null, values);





    }
}
