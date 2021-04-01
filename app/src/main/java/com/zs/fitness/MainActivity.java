package com.zs.fitness;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Locale;

public class MainActivity extends Activity {

	private InterstitialAd mInterstitialAd;
	private AdView mAdView;
	protected void onCreate(Bundle savedInstanceState) {


		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-2772878414290299/2088100038");
		mInterstitialAd.loadAd(new AdRequest.Builder().build());
		mInterstitialAd.setAdListener(new AdListener()
		{
			@Override
			public void onAdLoaded() {
				super.onAdLoaded();
				mInterstitialAd.show();
			}
		});
		// //////////////////////////////////////////////////////////////////////
		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {
			}
		});
		mAdView = findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		// //////////////// Exercises Buton//////////////////

		final Intent intent = new Intent(MainActivity.this,
				egzersiz_kasgrup.class);
		final Bundle bundle = new Bundle();
		Button btnegzersiz = (Button) findViewById(R.id.button_egzersiz);
		btnegzersiz.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final String ana_kas = "Egzersiz";
				// TODO Auto-generated method stub
				bundle.putString("egzersiz", ana_kas);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// ///////////////////////////////////////////////////////////////////////////////////
// //////////////// Exercises Buton//////////////////

        final Intent intent_liste = new Intent(MainActivity.this,
                Kasgrup_liste.class);
        final Bundle bundle_liste = new Bundle();
        Button btnegzersiz2 = (Button) findViewById(R.id.button_egzersiz_ekle);
        btnegzersiz2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final String ana_kas = "Egzersiz";
                // TODO Auto-generated method stub
                bundle_liste.putString("egzersiz", ana_kas);
                intent_liste.putExtras(bundle_liste);
                startActivity(intent_liste);
                // TODO Auto-generated method stub

            }

        });

        // ///////////////////////////////////////////////////////////////////////////////////
		// ///////////////// About Button
		// ////////////////////////////////////////
		final Intent intent_about = new Intent(MainActivity.this,
				hakkinda.class);
		final Bundle bundle_about = new Bundle();
		Button btn_about = (Button) findViewById(R.id.button_hakkinda);
		btn_about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub

				intent_about.putExtras(bundle_about);
				startActivity(intent_about);
				// TODO Auto-generated method stub

			}

		});

		// /////////////////////////////////////////////////////////
		// ///////////////// Search Button
		// ////////////////////////////////////////
		final Intent intent_search = new Intent(MainActivity.this, search.class);
		final Bundle bundle_search = new Bundle();
		Button btn_search = (Button) findViewById(R.id.button_search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub

				intent_search.putExtras(bundle_search);
				startActivity(intent_search);
				// TODO Auto-generated method stub

			}

		});

		// /////////////////////////////////////////////////////////


		  /////////////////// Routiine Button
		  ////////////////////////////////////////
		  final Intent intent_routine = new Intent(MainActivity.this,RoutineActivity.class);
		  final Bundle bundle_routine = new Bundle(); Button btn_routine = (Button)
		  findViewById(R.id.button_routines);
		  btn_routine.setOnClickListener(new OnClickListener() {

		  @Override public void onClick(View v) {

		  // TODO Auto-generated method stub
		  intent_search.putExtras(bundle_routine);
		  startActivity(intent_routine); // TODO Auto-generated method stub

		  }

		 });


		// /////////////////////////////////////////////////////////

		// ///////////////////////////////////////////////////////////////////////////////////
		// ///////////////// Profile Button
		// ////////////////////////////////////////
		final Intent intent_profile = new Intent(MainActivity.this,
				ProfileActivity.class);
		Button btn_profile = (Button) findViewById(R.id.button_profile);
		btn_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub


				startActivity(intent_profile);
				// TODO Auto-generated method stub

			}

		});

		// /////////////////////////////////////////////////////////

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
				.setTitle("Closing Application")
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

}
