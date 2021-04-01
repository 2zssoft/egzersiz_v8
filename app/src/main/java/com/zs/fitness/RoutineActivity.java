package com.zs.fitness;

import java.util.ArrayList;
import java.util.Random;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public class RoutineActivity extends AppCompatActivity {
	ArrayList<Routines> routineArray = new ArrayList<Routines>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routineliste);

	}

	@Override
	protected void onResume() {
		super.onResume();
		readDBdata();
	}
	int çalışma_resmi;
	public void readDBdata() {

		veritabani dbh = new veritabani(this);
		SQLiteDatabase db = dbh.getWritableDatabase();

		String v_adi = "routines";

		String[] key = { "%" };

		Cursor cursor = db.rawQuery("SELECT * FROM " + v_adi
				+ " WHERE name LIKE ? ", key);

		routineArray.clear();
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String name = cursor.getString((cursor.getColumnIndex("name")));
				String day = cursor.getString((cursor.getColumnIndex("odakbolgesi")));
				String resim = cursor.getString((cursor.getColumnIndex("resmi")));
				String seviye = cursor.getString((cursor.getColumnIndex("seviye")));


				Routines routines = new Routines(id, name, day,resim,seviye);
				routineArray.add(routines);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		db.close();

		ListView productList = (ListView) findViewById(R.id.routine_list);
		ProductAdapter adapter = new ProductAdapter(this,
				R.layout.routines_row, routineArray);
		productList.setAdapter(adapter);
	}

	public class ProductAdapter extends ArrayAdapter<Routines> {
		ArrayList<Routines> items;

		public ProductAdapter(Context context, int textViewResourceId,
				ArrayList<Routines> objects) {
			super(context, textViewResourceId, objects);

			this.items = objects;
		}
		String routine_ad="sdad";
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.routines_row, null);
			}

			TextView routineID = (TextView) convertView
					.findViewById(R.id.routine_id);
			TextView routineName = (TextView) convertView
					.findViewById(R.id.routine_name2);
			TextView routineDay = (TextView) convertView
					.findViewById(R.id.routine_day);

			TableRow tablerow = (TableRow) convertView
					.findViewById(R.id.tableRow1);
final int rutin_id=items.get(position).getID();
			tablerow.setTag(items.get(position).getname());

			Button rutinbutton = (Button) convertView
					.findViewById(R.id.routine_name);
			rutinbutton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// int routineid = (Integer) v.getTag();
					//String routine_ad = v.getTag().toString();
				//	final Bundle b = new Bundle();
					final Intent intent = new Intent(
							"android.intent.action.RUTINBASLA");
					//final Intent intent = new Intent(RoutineActivity.this,

									//RutinBaslamaActivity.class);

					// b.putString("id", "5");
				//	b.putInt("id",rutin_id);


					intent.putExtra("id", rutin_id);
				//	 b.putInt("id", rutin_id);
					// intent.putExtras(b);
					startActivity(intent);
				}
			});

			int id = items.get(position).getID();

					String mDrawableName = items.get(position).getresim() ;
        int resID = getResources().getIdentifier(mDrawableName , "drawable" ,
                getPackageName()) ;

			routineID.setText(Integer.toString(items.get(position).getID()));
			//Toast.makeText(getApplicationContext(),rutin_id, Toast.LENGTH_LONG).show();
			rutinbutton.setText(items.get(position).getname());
			Random rnd = new Random();

			rutinbutton.setBackgroundResource(resID);
			routineDay.setText(items.get(position).getresim());

                    // items.get(position).getday()
			// productImage.setImageResource(items.get(position).getresim1());

			return convertView;

		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.routine, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
