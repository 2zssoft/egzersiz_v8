package com.zs.fitness;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.luolc.emojirain.EmojiRainLayout;

import java.sql.Time;
import java.util.ArrayList;


public class BitmeActivity extends AppCompatActivity {
    private EmojiRainLayout mContainer;
    ArrayList<Works> worksArray =new ArrayList<Works>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitme);
        Intent intent = getIntent();




        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            try{ worksArray= (ArrayList<Works>) bundle.getSerializable("Works");}
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
            }

        }
        int toplamtekrar=0;
        int egzersizsayisi=worksArray.size();
        for (int i=0;i<worksArray.size();i++)
        {
         int reps=worksArray.get(0).get_works_reps();
         toplamtekrar=toplamtekrar+reps;
        }
      double kcal=toplamtekrar*1.9;
       TextView txt_kcal=(TextView)findViewById(R.id.textView_kcal);
        TextView txt_egzersizsayisi=(TextView)findViewById(R.id.textView_egzersizsayisi);
       txt_kcal.setText(Double.toString(kcal));
       txt_egzersizsayisi.setText(Integer.toString(egzersizsayisi));

        mContainer=(EmojiRainLayout)findViewById(R.id.BitmeActivity);
        mContainer.addEmoji(R.drawable.nazar_amulet_1f9ff);
        mContainer.addEmoji(R.drawable.flexed_biceps_medium_light_skin_tone_1f4aa_1f3fc_1f3fc);
        mContainer.addEmoji(R.drawable.trophy_1f3c6);
        mContainer.addEmoji(R.drawable.man_lifting_weights_1f3cb_fe0f_200d_2642_fe0f);
        mContainer.addEmoji(R.drawable.slightly_smiling_face_1f642);
        mContainer.addEmoji(R.drawable.man_cartwheeling_dark_skin_tone_1f938_1f3ff_200d_2642_fe0f);
        mContainer.addEmoji(R.drawable.party_popper_1f389);
        mContainer.addEmoji(R.drawable.sports_medal_1f3c5);
        mContainer.addEmoji(R.drawable.star_2b50);
        mContainer.addEmoji(R.drawable.ic_fitness_center_black_24dp);
        mContainer.stopDropping();
        mContainer.setPer(10);
        mContainer.setDuration(5000);
        mContainer.setDropDuration(2400);
        mContainer.setDropFrequency(500);
        mContainer.startDropping();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.victory);
        mp.start();

        Button btnpaylas=(Button)findViewById(R.id.button_paylas);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        btnpaylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/developer?id=2ZSSoftware";
                String shareSub = "Share";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

        Button btn_bitme = (Button)findViewById(R.id.button_finish);

        btn_bitme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BitmeActivity.this,MainActivity.class);
                startActivity(i);
                finish();




            }
        });
    }



}
