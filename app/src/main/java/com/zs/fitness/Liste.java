package com.zs.fitness;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class Liste extends AppCompatActivity {

	ArrayList<Egzersiz> productArray = new ArrayList<Egzersiz>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste);

	}

	@Override
	protected void onResume() {
		super.onResume();
		readDBdata();
	}

	public void readDBdata() {

		veritabani dbh = new veritabani(this);
		SQLiteDatabase db = dbh.getWritableDatabase();
		Bundle b = getIntent().getExtras();

		String gelenDeger = b.getString("ana_kas");
		String ekipman2 = b.getString("ekipman");
		String ekler = b.getString("ekler");
		String keyw = b.getString("keyword");

		String[] misal = { gelenDeger, ekipman2 };
		String v_adi;


			v_adi = "egzersiz";


	/*	Cursor cursor = db.rawQuery("" + "SELECT * FROM " + v_adi
				+ " WHERE ana_kas LIKE ? AND (equipment LIKE ?" + ekler + ")"
				+ keyw, misal);
				*/
		Cursor cursor=db.rawQuery("SELECT * FROM egzersiz WHERE ana_kas LIKE ? ", new String[] {gelenDeger});
		// "SELECT * FROM egzersiz WHERE ekipman LIKE ? IN SELECT * FROM egzersi anakas LIKE ?"
		//Toast.makeText(getApplicationContext(),gelenDeger,Toast.LENGTH_LONG).show();
		productArray.clear();
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
				Egzersiz egzersiz = new Egzersiz(id,ad,primary,yankas,steps,ekipman,primer,png1,png2,png3,tips,baslik);
				int png1resID = getResources().getIdentifier(png1 , "drawable" ,
						getPackageName()) ;
				egzersiz.set_png1resid(png1resID);
				int png2resID = getResources().getIdentifier(png2 , "drawable" ,
						getPackageName()) ;
				egzersiz.set_png2resid(png2resID);
				if (png3!=null)
				{
					int png3resID = getResources().getIdentifier(png3 , "drawable" ,
							getPackageName()) ;
					egzersiz.set_png3resid(png3resID);

				}

				productArray.add(egzersiz);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		db.close();

		ListView productList = (ListView) findViewById(R.id.product_list);
		ProductAdapter adapter = new ProductAdapter(this, R.layout.product_row,
				productArray);
		productList.setAdapter(adapter);


	}

	public class ProductAdapter extends ArrayAdapter<Egzersiz> {
		ArrayList<Egzersiz> items;

		public ProductAdapter(Context context, int textViewResourceId,
				ArrayList<Egzersiz> objects) {
			super(context, textViewResourceId, objects);
			this.items = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.product_row, null);
			}

			TextView productID = (TextView) convertView
					.findViewById(R.id.product_Id);
			TextView productName = (TextView) convertView
					.findViewById(R.id.egzersiz_name);
			TextView productDetail = (TextView) convertView
					.findViewById(R.id.product_detail);
			TextView productDetail2 = (TextView) convertView
					.findViewById(R.id.product_detail2);
			ImageView productImage = (ImageView) convertView
					.findViewById(R.id.product_image);
			TableRow tablerow = (TableRow) convertView
					.findViewById(R.id.tableRow1);

			Button productBtn = (Button) convertView
					.findViewById(R.id.product_add);
			tablerow.setTag(items.get(position).get_title());

			tablerow.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String productadi = (String) v.getTag();
					final Bundle b = new Bundle();
					final Intent intent = new Intent(
							"android.intent.action.URUN");
					// final MediaPlayer sesonay=MediaPlayer.create(Liste.this,
					// null);
					// sesonay.start();

					b.putString("key", productadi);
					intent.putExtras(b);
					startActivity(intent);
				}
			});

			productName.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					// BURAYA TEXT TIKLANDIGINDA YAPILACAK ISLEMLERI YAZ

				}
			});
			int id = items.get(position).getID();
			productID.setText(Integer.toString(items.get(position).getID()));

			// Locale.getDefault().getDisplayLanguage()=="T�rk�e";
			// items.get(position).getadi()
			String kkkkkkk;
			if (Locale.getDefault().getLanguage().toString().equals("tr") == true) {
				kkkkkkk = "Türkçe";
			} else {
				kkkkkkk = "Başka bir dil";

			}

			productName.setText(items.get(position).get_title());
			productDetail.setText(items.get(position).getanakas());
			productDetail2.setText(items.get(position).getekipman());
productImage.setImageResource(items.get(position).get_png1resid());
			// productImage.setImageResource(items.get(position).getresim1());

			return convertView;

		}
	}
}