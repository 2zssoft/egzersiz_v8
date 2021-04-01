package com.zs.fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KayitKAdiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_kadi);
        final EditText txt_kadi = (EditText) findViewById(R.id.editText_kadi);
        Button btn_nxt = (Button)findViewById(R.id.button_next);
        final Intent i = new Intent(KayitKAdiActivity.this,KayitCinsiyetActivity.class);
        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kadi=txt_kadi.getText().toString();

                i.putExtra("kadi",kadi);
                startActivity(i);
                finish();
            }
        });

    }
}
