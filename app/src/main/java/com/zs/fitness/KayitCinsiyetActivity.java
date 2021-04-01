package com.zs.fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class KayitCinsiyetActivity extends AppCompatActivity {
    String cinsiyet = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_cinsiyet);
        final String[] kullanici=new String[4];
        String kadi;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                kadi= null;
            } else {
                kadi= extras.getString("kadi");
            }
        } else {
            kadi= (String) savedInstanceState.getSerializable("kadi");
        }
        kullanici[0]=kadi;
         ImageButton imgerkek = (ImageButton) findViewById(R.id.imageButton_erkek);
        ImageButton imgkadin = (ImageButton) findViewById(R.id.imageButton_kadin);

        final Intent i = new Intent(KayitCinsiyetActivity.this,KayitBoyKiloActivity.class);

imgerkek.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        cinsiyet ="Male";
        kullanici[1]=cinsiyet;
        i.putExtra("kullanici",kullanici);
        startActivity(i);
        finish();

    }
});

        imgkadin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinsiyet ="Female";
                kullanici[1]=cinsiyet;
                i.putExtra("kullanici",kullanici);
                startActivity(i);
                finish();
            }
        });




    }
}
