package com.zs.fitness;

import java.util.Locale;


import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class egzersiz_kasgrup extends AppCompatActivity {
	private String gonder[];

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kasgrup_egzersiz);

gonder = new String[5];

		Button btnkarin = (Button) findViewById(R.id.button_karin);
		final Intent intent = new Intent(egzersiz_kasgrup.this, Liste.class);
		final Bundle bundle = new Bundle();
		btnkarin.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						String ana_kas = "%";
				// TODO Auto-generated method stub


					ana_kas = "%Abdominals%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);

				// bundle.putString("ana_kas", ana_kas);
				intent.putExtras(bundle);
				startActivity(intent);

			}
		});

		// ////////////////////////////////////////Arka Kol
		// ////////////////////////////////////////////////////
		Button btnarkakol = (Button) findViewById(R.id.button_arkakol);
		btnarkakol.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String ana_kas = "%";
				// TODO Auto-generated method stub


					ana_kas = "%Triceps%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);

				// bundle.putString("ana_kas", ana_kas);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		Button btngogus = (Button) findViewById(R.id.button_gogus1);
		btngogus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String ana_kas = "%";
				// TODO Auto-generated method stub


					ana_kas = "%Chest%";

				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);

				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// /////////////////////////////////////////////// B?LEK
		// ///////////////////////////////////

		Button btnbilek = (Button) findViewById(R.id.button_bilek);
		btnbilek.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";
				// TODO Auto-generated method stub


					ana_kas = "%Lats%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// //////////////////////////////////////////////////////////////////////////////

		// /////// Arka bacak //////////
		Button btnarkabacak = (Button) findViewById(R.id.button_arkabacak);
		btnarkabacak.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";
				// TODO Auto-generated method stub


					ana_kas = "%Hamstrings%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});
		// /////////////////////////////////////////////////////////////////
		// ///////////////// ?N KOL ////////////////////////////////////////
		Button btnonkol = (Button) findViewById(R.id.button_onkol);
		btnonkol.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";


					ana_kas = "%Biceps%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				// TODO Auto-generated method stub
				bundle.putString("ana_kas", ana_kas);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// ///////////////////////////////////////////////////////////////////////////////////////

		// ///////////////////////////////////////////////////////////S?rt/////

		Button btnsirt = (Button) findViewById(R.id.button_sirt);
		btnsirt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";


					ana_kas = "%Back%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});
		// /////////////////////////////////////////////////////////////////////////////////

		// //////////////////////////////////////////////////////////
		// Omuz///////////////////////////////////////////
		Button btnomuz = (Button) findViewById(R.id.button_omuz);
		btnomuz.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";

				if (Locale.getDefault().getLanguage().toString().equals("tr") == true) {
					ana_kas = "%Omuz%";
				} else {
					ana_kas = "%Shoulders%";

				}
				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// //////////////////////////////Kal?a/////
		Button btnkalca = (Button) findViewById(R.id.button_kalca);
		btnkalca.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";

				if (Locale.getDefault().getLanguage().toString().equals("tr") == true) {
					ana_kas = "%Kalça%";
				} else {
					ana_kas = "%Glutes%";

				}
				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// //////////////////////////////////////////////////////////////////////////////

		// ////////////////////////////// ?n bacak
		// ///////////////////////////////////////////

		Button btnonbacak = (Button) findViewById(R.id.button_onbacak);
		btnonbacak.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";

					ana_kas = "%Quads%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// //////////////////////////////Kalfler
		// ///////////////////////////////////////////

		Button btnkalf = (Button) findViewById(R.id.button_kalf);
		btnkalf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";


					ana_kas = "%Calves%";


				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// //////////////////////////////Hepsi
		// ///////////////////////////////////////////

		Button btnhepsi = (Button) findViewById(R.id.button__hepsi);
		btnhepsi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ana_kas = "%";

				String ekipman = "%";
				String ekler = "";
				String keyw = "";
				bundle.putString("keyword", keyw);
				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ekler);
				intent.putExtras(bundle);
				startActivity(intent);
				// TODO Auto-generated method stub

			}

		});

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

}
