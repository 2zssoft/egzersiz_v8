package com.zs.fitness;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class WorksActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    CountDownTimerWithPause times ;
    CountDownTimer countDownTimer;
  ArrayList<Works> worksArrayresim =new ArrayList<Works>();
    ArrayList<Works> worksArray =new ArrayList<Works>();
    ArrayList<Integer> array_egzersiz;
    TextToSpeech t1;

public  int  sira=0;
	 int playstop=0; // 0 ise stop başlangıçta stop
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_works);
        }
catch (Exception e)
{
    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
}
        t1=new TextToSpeech(this,this);

		;
       /* mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

*/Intent intent = getIntent();




        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            array_egzersiz=bundle.getIntegerArrayList("egzersizlistesi");
            sira = bundle.getInt("sira");
            try{ worksArray= (ArrayList<Works>) bundle.getSerializable("Works");}
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
            }

        }
        Works wrk= worksArray.get(sira);
      int tekrarsayisi= wrk.get_works_reps();
        final TextView mTextField = (TextView) findViewById(R.id.textView_geri_sayim);
        final Egzersiz simdikiegzersiz=readDBdata_egzersiz(array_egzersiz.get(sira));
final String konus=simdikiegzersiz.getaciklama();
	//	final Chronometer simpleChronometer = (Chronometer) findViewById(R.id.kronometre);
        //Play();
        final ImageButton btn_stop=(ImageButton)findViewById(R.id.imageButton);
//Egzersiz egzersiz;= egzersizArray.get(0);
        Button btn_ckis=(Button) findViewById(R.id.button_wcikis);
        btn_ckis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(WorksActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawableResource(R.color.translucent_black);
                dialog.setContentView(R.layout.fragment_my_dialog);

                dialog.show();
            }
        });
TextView txt_egzersiz_adi =(TextView)findViewById(R.id.textView_egzersizadi);
       final ProgressBar prgbar =(ProgressBar)findViewById(R.id.progressBar);
        txt_egzersiz_adi.setText(simdikiegzersiz.get_title().toString());
        Egzersiz_Resmi(simdikiegzersiz.get_png1resid(),simdikiegzersiz.get_png2resid());
txt_egzersiz_adi.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {



    }
});

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String konus=simdikiegzersiz.getaciklama();
                String toSpeak = konus;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Set<String> a=new HashSet<>();
                    a.add("female");//here you can give male if you want to select male voice.
                    Voice v=new Voice("en-us-x-sfg#female_2-local",new Locale("en","US"),400,200,true,a);
                    t1.setVoice(v);

                }
                //  t1.setSpeechRate(0.90f); //ses hızı düşükse yavaş
                  t1.setPitch(0.75f); //ses kalınlığı düşükse kalın


                t1.setSpeechRate(0.8f);
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);//speak after 1000ms
            }
        }, 2000);
	//	simpleChronometer.start(); // start a chronometer
	//	simpleChronometer.setFormat("%s"); // set the format for a chronometer

if(tekrarsayisi==30)
{

    times =new CountDownTimerWithPause(30000,1000,true) {
        @Override
        public void onTick(long millisUntilFinished) {
            long sure=millisUntilFinished/1000;
            mTextField.setText( ""+millisUntilFinished / 1000);
            int saniye=(int)millisUntilFinished/1000;
            prgbar.setProgress(saniye);
        }

        @Override
        public void onFinish() {
            mTextField.setText("0");
bitme();
        }
    };
    times.create();
}


else
        {
           // speakOut("Welcome to VoiceBased Chat Application");
            mTextField.setText("X"+Integer.toString(tekrarsayisi));
            btn_stop.setImageResource(R.drawable.ic_done_black_24dp);
            prgbar.setVisibility(View.INVISIBLE);
            playstop=2;

        }







		btn_stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if(playstop==0) { //image buttonun resmini değiştiriyoruz
					btn_stop.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
					playstop=1;
					times.pause();

				}
				else if(playstop==1)
				{
					btn_stop.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
					playstop=0;
					times.resume();
				}
				else
                {
                    bitme();
                }

			}
		});

		final Button bnt_ileri = (Button)findViewById(R.id.button_wileri);

		bnt_ileri.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                times.cancel();
                bitme();
            }
        });




		/////on create bitiş//////////////////////
    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    public void showDialog() {
        FragmentManager fm = getSupportFragmentManager();
        MyDialog newFragment = new MyDialog();
        newFragment.show(fm, "abc");
    }
String dils=Locale.getDefault().getDisplayCountry().toString();
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
    public void bitme(){
	 sira++;

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        mp.start();
        if(sira==array_egzersiz.size())
        {
            Intent myIntent = new Intent(WorksActivity.this, BitmeActivity.class);
            myIntent.putExtra("Works",worksArray);
            startActivity(myIntent);
            finish();
        }
        else {
            Intent myIntent = new Intent(WorksActivity.this, DinlenmeActivity.class);
            myIntent.putExtra("sira",sira);
            myIntent.putIntegerArrayListExtra("egzersizlistesi",array_egzersiz);
            myIntent.putExtra("Works",worksArray);
            try {
                startActivity(myIntent);
                finish();
            } catch (Exception e) {

            }
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

    public void Egzersiz_Resmi(int resim1,int resim2)
    {

        final ImageView wssegzersiz_resim = (ImageView) findViewById(R.id.imageView44);


        if (resim1 != 0 && resim2 != 0) {
            final int[] imageArray = { resim1, resim2 };

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {
                    wssegzersiz_resim.setImageResource(imageArray[i]);

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
                wssegzersiz_resim.setImageResource(resim1);
            } else {
                wssegzersiz_resim.setImageResource(R.drawable.ic_done_black_24dp);
            }
        }

    }
    @Override
    public void onDestroy() {
        // Don't forget to shutdown!
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {

            int result = t1.setLanguage(Locale.US);
          //  int result= t1.setLanguage(new Locale("tr", "TR"));


            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {

            }

        } else {
            Log.e("TTS", "Initilization Failed");
        }
    }


}
