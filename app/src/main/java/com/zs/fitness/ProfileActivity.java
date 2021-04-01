package com.zs.fitness;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    veritabani v = new veritabani(this);
    private veritabani main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        List<Kullanici> countries = new ArrayList<Kullanici>();
        countries =getAllCountries();
        CircleImageView cimage_profil = (CircleImageView)findViewById(R.id.profile_image);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        TextView txt_boy=(TextView) findViewById(R.id.txt_profile_boy);
        TextView txt_kilo=(TextView) findViewById(R.id.txt_profile_kilo);
        TextView txt_vki=(TextView) findViewById(R.id.txt_profile_vki);
        final TextView txt_ad=(TextView) findViewById(R.id.TextBox_ad_soyad);
        TextView txt_cins=(TextView) findViewById(R.id.textView_profile_cinsiyet);

      int boy=countries.get(0).getBoy();
      int kilo=countries.get(0).getKilo();
        txt_boy.setText(Integer.toString(boy));
        txt_kilo.setText(Integer.toString(kilo));

        txt_ad.setText(countries.get(0).getKadi().toString());
        txt_cins.setText(countries.get(0).getCinsiyet().toString());
        String cins=txt_cins.getText().toString();
        String dil=Locale.getDefault().getLanguage();
        if (cins.equals("Male"))
        {
            cimage_profil.setImageResource(R.drawable.erkek1);
            if (dil=="tr")
            {
                txt_cins.setText("Erkek");
            }
        }
        else
        {
            cimage_profil.setImageResource(R.drawable.kadin1);
            if (dil=="tr")
            {
                txt_cins.setText("Kadın");
            }
        }


            double vki=vki_i(boy,kilo);
        if (vki<18.5)
        {
//zayıf
            txt_vki.setBackgroundColor(getResources().getColor(R.color.zayif));
        }
        else if(vki<25)
        {
//normal
            txt_vki.setBackgroundColor(getResources().getColor(R.color.normal));
        } else if(vki<30)
        {
       //hafif obez
            txt_vki.setBackgroundColor(getResources().getColor(R.color.hafifobez));
        }
        else if(vki<35)
        {
            //
            txt_vki.setBackgroundColor(getResources().getColor(R.color.obez));
        }
        else
        {
            txt_vki.setBackgroundColor(Color.RED);
            //aşırı obez
        }

          txt_vki.setText(Double.toString(Math.round(vki)));

    }

    public double vki_i(int boy,int kilo)
    {
        double by=(double)boy;
        double kl=(double)kilo;
        double boymt=by/100;
        double vki=kl/(boymt*boymt);
        return vki;
    }
    public List<Kullanici> getAllCountries() {
        List<Kullanici> countries = new ArrayList<Kullanici>();
        SQLiteDatabase db = v.getWritableDatabase();

        // String sqlQuery = "SELECT  * FROM " + TABLE_COUNTRIES;
        // Cursor cursor = db.rawQuery(sqlQuery, null);

        Cursor cursor = db.query("kullanici", new String[]{"id", "k_adi", "cinsiyet","kilo","boy"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Kullanici kullanici = new Kullanici();
            kullanici.setId(cursor.getInt(0));
            kullanici.setKadi(cursor.getString(1));
            kullanici.setCinsiyet(cursor.getString(2));
            kullanici.setKilo(cursor.getInt(3));
            kullanici.setBoy(cursor.getInt(4));
            countries.add(kullanici);
        }

        return countries;
    }
    public void readDBdata() {
        veritabani dbh = new veritabani(this);
        SQLiteDatabase db = dbh.getReadableDatabase();

      //  Kullanici kullanici=null;

        String tabloadi = "kullanici";


        Cursor cursor = db.query(tabloadi, new String[]{"*"}, null,
                null, null, null, veritabani.name, null);



        if (cursor.moveToFirst()) {

            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String ad = cursor.getString((cursor.getColumnIndex("k_adi")));
            String cinsiyet = cursor.getString((cursor.getColumnIndex("cinsiyet")));
            int boy = cursor.getInt((cursor.getColumnIndex("boy")));
            int kilo = cursor.getInt((cursor.getColumnIndex("kilo")));


            do {
              //  Kullanici kullanici = new Kullanici(id, ad, cinsiyet, boy, kilo);
            } while (cursor.moveToNext());

        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        // ListView productList = (ListView) findViewById(R.id.product_list);
       // return kullanici;
    }

}
