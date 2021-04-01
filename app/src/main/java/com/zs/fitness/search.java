package com.zs.fitness;

import java.util.Locale;
import java.util.Properties;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;

public class search extends AppCompatActivity {
	private String array_spinner[];
	private CheckBox chkIos, chck_bosu, chck_bench, chck_barbell,
			chck_bodyonly, chck_dumbell, chck_z_bari, chck_exercise_ball,
			chck_v_bar, chck_cable, chck_machine, chck_medicine_ball,
			chck_pull, chck_paralel_bars, chck_other;
	static Properties properties;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		array_spinner = new String[5];
		array_spinner[0] = "Any";
		array_spinner[1] = "Alt bacak";
		array_spinner[2] = "Arka kol";
		array_spinner[3] = "Karin";
		array_spinner[4] = "Sirt";

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter;

		if (Locale.getDefault().getLanguage().toString().equals("tr") == true) {
			adapter = ArrayAdapter.createFromResource(this, R.array.kas_grup,
					android.R.layout.simple_spinner_item);

		} else {
			adapter = ArrayAdapter.createFromResource(this,
					R.array.kas_grup_en, android.R.layout.simple_spinner_item);

		}

		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		final Intent intent = new Intent(search.this, Liste.class);
		final Bundle bundle = new Bundle();

		/*
		 * CheckBox repeatChkBx = ( CheckBox ) findViewById( R.id.checkBox_all
		 * ); repeatChkBx.setOnCheckedChangeListener(new
		 * OnCheckedChangeListener() { public void
		 * onCheckedChanged(CompoundButton buttonView, boolean isChecked) { if (
		 * isChecked ) { // perform logic }
		 * 
		 * } });
		 */

		chkIos = (CheckBox) findViewById(R.id.checkBox_all);
		chck_bosu = (CheckBox) findViewById(R.id.checkBox_bosu);
		chck_bench = (CheckBox) findViewById(R.id.checkBox_bench);
		chck_barbell = (CheckBox) findViewById(R.id.checkBox_barbell);
		chck_bodyonly = (CheckBox) findViewById(R.id.checkBox_bodyonly);
		chck_dumbell = (CheckBox) findViewById(R.id.checkBox_dumbell);
		chck_z_bari = (CheckBox) findViewById(R.id.checkBox_z_bari);
		chck_exercise_ball = (CheckBox) findViewById(R.id.checkBox_exercisesball);
		chck_v_bar = (CheckBox) findViewById(R.id.checkBox_v_bar);
		chck_cable = (CheckBox) findViewById(R.id.checkBox_cable);
		chck_machine = (CheckBox) findViewById(R.id.checkBox_machine);
		chck_medicine_ball = (CheckBox) findViewById(R.id.checkBox_medicine_ball);
		chck_pull = (CheckBox) findViewById(R.id.checkBox_pullup_bar);
		chck_paralel_bars = (CheckBox) findViewById(R.id.checkBox_parallel_bars);
		chck_other = (CheckBox) findViewById(R.id.checkBox_other);

		chkIos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// is chkIos checked?
				if (((CheckBox) v).isChecked()) {
					chck_bosu.setChecked(true);
					chck_bench.setChecked(true);
					chck_barbell.setChecked(true);

					chck_dumbell.setChecked(true);
					chck_z_bari.setChecked(true);
					chck_exercise_ball.setChecked(true);
					chck_v_bar.setChecked(true);
					chck_cable.setChecked(true);
					chck_machine.setChecked(true);
					chck_medicine_ball.setChecked(true);
					chck_pull.setChecked(true);
					chck_paralel_bars.setChecked(true);
					chck_other.setChecked(true);

				} else {
					chck_bosu.setChecked(false);
					chck_bench.setChecked(false);
					chck_barbell.setChecked(false);

					chck_dumbell.setChecked(false);
					chck_z_bari.setChecked(false);
					chck_exercise_ball.setChecked(false);
					chck_v_bar.setChecked(false);
					chck_cable.setChecked(false);
					chck_machine.setChecked(false);
					chck_medicine_ball.setChecked(false);
					chck_pull.setChecked(false);
					chck_paralel_bars.setChecked(false);
					chck_other.setChecked(false);
				}

			}
		});

		Button button_ara = (Button) findViewById(R.id.button_ara);
		button_ara.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Spinner spinner = (Spinner) findViewById(R.id.spinner1);
				String ana_kas = "%";
				int poz = spinner.getSelectedItemPosition();
				String ekipman;
				String ekler;
				String keyw = "";
				String k_w;
				final EditText keyword = (EditText) findViewById(R.id.editText_keyword);
/////////////////////////////////////////////////////////////focus olunca text siliniyor

/*
				keyword.setOnClickListener( new View.OnFocusChangeListener() {

					public void onFocusChange( View v, boolean hasFocus ) {
						if( hasFocus ) {
							keyword.setText( "", EditText.BufferType.EDITABLE );
						}
					}

				} );
				*////////////////////////////////////////////
				if (keyword.getText().toString().equals("") == false ) {
					keyw = " and adi like '%" + keyword.getText().toString()
							+ "%'";
				}

				StringBuilder ek = new StringBuilder();
				ek.append("");

				ekipman = "%";
				ekler = "";

				if (chkIos.isChecked() == false) {

					ekipman = "'%N/A%'";
					if (chck_z_bari.isChecked() == true) {

						ek.append(" or ekipman like '%EZ Curl Bar%' '%EZ Bukle Bar%'");

					}

					if (chck_dumbell.isChecked() == true) {

						ek.append(" or ekipman like '%Dumbbells%' or ekipman like '%Dambıl%'");

					}

					if (chck_paralel_bars.isChecked() == true) {

						ek.append(" or ekipman like '%Parallel Bars%' or ekipman like '%Parelel Bar%'");

					}

					if (chck_v_bar.isChecked() == true) {

						ek.append(" or ekipman like '%V-Bar%'");

					}

					if (chck_bosu.isChecked() == true) {

						ek.append(" or ekipman like '%Bosu Ball%' or ekipman like '%Denge Topu%'");

					}
					if (chck_machine.isChecked() == true) {

						ek.append(" or ekipman like '%Machine%' or ekipman like '%Makine%'");

					}

					if (chck_medicine_ball.isChecked() == true) {

						ek.append(" or ekipman like '%Medicine Ball%' or ekipman like '%Sağlık Topu%'");

					}

					if (chck_barbell.isChecked() == true) {

						ek.append(" or ekipman like '%Barbell%' or ekipman like '%Halter Barı%'");

					}

					if (chck_pull.isChecked() == true) {

						ek.append(" or ekipman like '%Pull Up Bar%' or ekipman like '%Barfiks Barı%'");

					}

					if (chck_cable.isChecked() == true) {

						ek.append(" or ekipman like '%Cable%' or ekipman like '%Kablo%'");

					}

					if (chck_exercise_ball.isChecked() == true) {

						ek.append(" or ekipman like '%Exercise Ball%' or ekipman like '%Egzersiz Topu%'");

					}

					if (chck_bench.isChecked() == true) {

						ek.append(" or ekipman like '%Bench%'");

					}

					if (chck_bench.isChecked() == true) {

						ek.append(" or ekipman like '%Bench%'");

					}

					if (chck_other.isChecked() == true) {

						ek.append(" or ekipman like '%Other%'");

					}
				}

				ana_kas = spinner.getSelectedItem().toString();
				if (ana_kas.equals("All") || ana_kas.equals("Hepsi")) {
					ana_kas = "%";

				} else {
					ana_kas = "%" + ana_kas + "%";
				}

				bundle.putString("ana_kas", ana_kas);
				bundle.putString("ekipman", ekipman);
				bundle.putString("ekler", ek.toString());
				bundle.putString("keyword", keyw);

				intent.putExtras(bundle);
				startActivity(intent);

			}

		});
	}

}