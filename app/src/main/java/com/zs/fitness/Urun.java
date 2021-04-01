package com.zs.fitness;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Urun extends AppCompatActivity {
	private AdView mAdView;
	int id = 0;

	ArrayList<Egzersiz> productArray = new ArrayList<Egzersiz>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.urun2);

		Bundle b = getIntent().getExtras();
		String gelenDeger = b.getString("key");

		readDBdata(gelenDeger);
		mAdView = findViewById(R.id.adView4);

		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Bundle b = getIntent().getExtras();
		String gelenDeger = b.getString("key");
		readDBdata(gelenDeger);
	}

	public void readDBdata(String deger) {
		veritabani dbh = new veritabani(this);
		SQLiteDatabase db = dbh.getWritableDatabase();

		String[] aranan = { deger };

		String v_adi;


			v_adi = "egzersiz";


		Cursor cursor = db.query(v_adi, new String[] { "*" }, "title" + "=? ",
				aranan, null, null, null, null);
		productArray.clear();
		if (cursor.moveToFirst()) {

			long id = cursor.getLong(cursor.getColumnIndex("id"));
			String ad = cursor.getString((cursor.getColumnIndex("name")));
			String baslik = cursor.getString((cursor.getColumnIndex("title")));
			String primer = cursor.getString((cursor.getColumnIndex("primer")));
			String primary = cursor.getString((cursor.getColumnIndex("ana_kas")));
			String ekipmn = cursor.getString((cursor.getColumnIndex("equipment")));
			String tp = cursor.getString((cursor.getColumnIndex("type")));
			String tip = tp.substring(0, 1).toUpperCase() + tp.substring(1);
			String yankas = cursor.getString((cursor.getColumnIndex("secondary")));
			String png1 = cursor.getString((cursor.getColumnIndex("png1")));
			String png2 = cursor.getString((cursor.getColumnIndex("png2")));
			String png3 = cursor.getString((cursor.getColumnIndex("png3")));
			String ekipman = ekipmn.substring(0, 1).toUpperCase() + ekipmn.substring(1);
			String steps = cursor.getString((cursor.getColumnIndex("steps")));
			String tips = cursor.getString((cursor.getColumnIndex("tips")));
			//Egzersiz egzersiz = new Egzersiz((int)id,ad,primary,yankas,steps,ekipman,primer,png1,png2,png3,tips,baslik);

			final TextView egzersizID = (TextView) findViewById(R.id.product_Id);
			final TextView egzersizName = (TextView) findViewById(R.id.routine_name);
			final TextView egzersiz_anakas = (TextView) findViewById(R.id.text_kas_ana);
			final TextView egzersiz_ekipman = (TextView) findViewById(R.id.text_ekipman);
			final TextView egzersiz_aciklama = (TextView) findViewById(R.id.textView_aciklama);
			final TextView egzersiz_yankas = (TextView) findViewById(R.id.text_yankas);
			final ImageView productImage = (ImageView) findViewById(R.id.product_image);

			final TextView egzersiz_type = (TextView) findViewById(R.id.text_type);

			final TextView egzersiz_puan = (TextView) findViewById(R.id.textView_puan);
			egzersiz_type.setText(tip);
			//egzersizID.setText(Integer.toString(id));
			egzersizName.setText(baslik);
			egzersiz_anakas.setText(primary);
		//	Toast.makeText(getApplicationContext(), anakas, Toast.LENGTH_LONG).show();
			egzersiz_ekipman.setText(ekipman);
			egzersiz_yankas.setText(yankas);
			egzersiz_aciklama.setText(steps);
			//egzersiz_puan.setText(puan);

			// final ImageView image = (ImageView) findViewById(R.id.image);
			/*
			 * final ToggleButton button = (ToggleButton)
			 * findViewById(R.id.toggleButton1); button.setOnClickListener(new
			 * OnClickListener() {
			 *
			 * @Override public void onClick(final View v) { TransitionDrawable
			 * drawable = (TransitionDrawable) productImage.getDrawable(); if
			 * (button.isChecked()) { drawable.startTransition(500); } else {
			 * drawable.reverseTransition(500); } } });
			 */
			int resim1 = 0;
			int resim2 = 0;
			int png1resID = getResources().getIdentifier(png1 , "drawable" ,
					getPackageName()) ;
		//	egzersiz.set_png1resid(png1resID);
			int png2resID = getResources().getIdentifier(png2 , "drawable" ,
					getPackageName()) ;
		//	egzersiz.set_png2resid(png2resID);
			if (png3!=null)
			{
				int png3resID = getResources().getIdentifier(png3 , "drawable" ,
						getPackageName()) ;
				//egzersiz.set_png3resid(png3resID);

			}
			resim1=png1resID;
			resim2=png2resID;


productImage.setImageResource(resim1);

			if (resim1 != 0 && resim2 != 0) {
				final int[] imageArray = { resim1, resim2 };

				final Handler handler = new Handler();
				Runnable runnable = new Runnable() {
					int i = 0;

					public void run() {
						productImage.setImageResource(imageArray[i]);
						i++;
						if (i > imageArray.length - 1) {
							i = 0;
						}
						handler.postDelayed(this, 700); // for interval...
					}
				};
				handler.postDelayed(runnable, 100); // for initial delay..
			} else {
				if (resim1 != 0 && resim2 == 0) {
					productImage.setImageResource(resim1);
				} else {
					productImage.setImageResource(0);
				}
			}

			Egzersiz egzersiz;
			do {
				 egzersiz = new Egzersiz((int)id,ad,primary,yankas,steps,ekipman,primer,png1,png2,png3,tips,baslik);
			} while (cursor.moveToNext());
			productArray.add(egzersiz);
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		db.close();
		// ListView productList = (ListView) findViewById(R.id.product_list);
		EgzersizAdapter adapter = new EgzersizAdapter(this, R.layout.urun2,
				productArray);

	}

	public class EgzersizAdapter extends ArrayAdapter<Egzersiz> {
		ArrayList<Egzersiz> items;

		public EgzersizAdapter(Context context, int textViewResourceId,
							   ArrayList<Egzersiz> objects) {
			super(context, textViewResourceId, objects);
			this.items = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.urun2, null);
			}

			final TextView egzersizID = (TextView) convertView
					.findViewById(R.id.product_Id);
			final TextView egzersizName = (TextView) convertView
					.findViewById(R.id.routine_name);
			final TextView egzersiz_anakas = (TextView) convertView
					.findViewById(R.id.text_kas_ana);
			final TextView egzersiz_ekipman = (TextView) convertView
					.findViewById(R.id.text_ekipman);
			final ImageView productImage = (ImageView) convertView
					.findViewById(R.id.product_image);
			final ImageView productImage2 = (ImageView) findViewById(R.id.ImageView01);
			productImage.setImageResource(0);
			productImage2.setImageResource(0);
			egzersizID.setText(0);
			egzersizName.setText(items.get(position).getadi());
			//egzersiz_anakas.setText(items.get(position).getanakas());
			egzersiz_ekipman.setText(items.get(position).getekipman());

			egzersizID.setText(0);
			egzersizName.setText(items.get(position).getadi());
		//	egzersiz_anakas.setText(items.get(position).getanakas());
			egzersiz_ekipman.setText(items.get(position).getekipman());

			return convertView;
		}
	}
}