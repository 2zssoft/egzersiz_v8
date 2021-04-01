package com.zs.fitness;

import java.util.ArrayList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class RWorksActivity extends AppCompatActivity {
	TextView w_egzersiz_name = (TextView) findViewById(R.id.w_egzersiz_name);
	ArrayList<Works> worksArray = new ArrayList<Works>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rworks);
		// Bundle b = getIntent().getExtras();

		// String gelenDeger = b.getString("id");

	}
	/*
	 * @Override protected void onResume() { super.onResume(); readDBdata(); }
	 * 
	 * public void readDBdata() {
	 * 
	 * 
	 * 
	 * veritabani dbh = new veritabani(this); SQLiteDatabase db =
	 * dbh.getWritableDatabase(); Bundle b = getIntent().getExtras();
	 * 
	 * 
	 * 
	 * 
	 * String gelenDeger = b.getString("id");
	 * 
	 * 
	 * String[] misal={gelenDeger}; String v_adi="works";
	 * 
	 * Cursor cursor = db.rawQuery("" +
	 * "SELECT * FROM "+v_adi+" WHERE routine_id LIKE ?",misal);
	 * worksArray.clear(); if (cursor.moveToFirst()) { do { int id =
	 * cursor.getInt(cursor.getColumnIndex("id")); int routine_id =
	 * cursor.getInt(cursor.getColumnIndex("routine_id")); int w_egzersiz_id =
	 * cursor.getInt(cursor.getColumnIndex("egzersiz_id")); int work_id =
	 * cursor.getInt(cursor.getColumnIndex("sets")); int sirasi =
	 * cursor.getInt(cursor.getColumnIndex("reps"));
	 * readDBdata_egzersiz(Integer.toString(w_egzersiz_id));
	 * 
	 * 
	 * Works routine_works = new Works(id,routine_id,work_id,sirasi);
	 * worksArray.add(routine_works); } while (cursor.moveToNext()); } if
	 * (cursor != null && !cursor.isClosed()) { cursor.close(); } db.close();
	 * 
	 * ListView routine_worksList = (ListView) findViewById(R.id.rworks_list);
	 * worksAdapter adapter = new worksAdapter(this, R.layout.activity_rworks,
	 * worksArray); routine_worksList.setAdapter(adapter); }
	 * 
	 * public class worksAdapter extends ArrayAdapter<Works>{ ArrayList<Works>
	 * items; public worksAdapter(Context context, int textViewResourceId,
	 * ArrayList<Works> objects) { super(context, textViewResourceId, objects);
	 * this.items = objects; }
	 * 
	 * 
	 * @Override public View getView(int position, View convertView, ViewGroup
	 * parent) { if (convertView == null) { LayoutInflater vi =
	 * (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 * convertView = vi.inflate(R.layout.works_row, null); }
	 * 
	 * TextView routine_worksID = (TextView)
	 * convertView.findViewById(R.id.rw_Id);
	 * 
	 * TextView w_rest = (TextView) convertView.findViewById(R.id.txt_rest);
	 * TextView w_reps = (TextView) convertView.findViewById(R.id.txt_rw_reps);
	 * TextView w_sets = (TextView) convertView.findViewById(R.id.txt_rw_sets);
	 * ImageView w_egzersiz_Image = (ImageView)
	 * convertView.findViewById(R.id.w_egzersiz_image); TableRow tablerow =
	 * (TableRow) convertView.findViewById(R.id.tableRow1);
	 * 
	 * tablerow.setTag(items.get(position).getID());
	 * 
	 * tablerow.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { String works_id = (String)
	 * v.getTag(); final Bundle b=new Bundle(); final Intent intent=new
	 * Intent("android.intent.action.WorksActivity"); // final MediaPlayer
	 * sesonay=MediaPlayer.create(Liste.this, null); //sesonay.start();
	 * 
	 * b.putString("key", works_id); intent.putExtras(b); startActivity(intent);
	 * } });
	 * 
	 * //veritabani dbhs = new veritabani(egzersiz); int
	 * id=items.get(position).getID(); int
	 * egzersiz_id=items.get(position).getegzersiz();
	 * routine_worksID.setText(Integer.toString(items.get(position).getID()));
	 * 
	 * w_egzersiz_name.setText(egzersiz_id);
	 * 
	 * 
	 * w_rest.setText(items.get(position).get_works_dinlenme());
	 * w_reps.setText(items.get(position).get_works_reps());
	 * w_sets.setText(items.get(position).get_sets());
	 * 
	 * 
	 * //routine_worksImage.setImageResource(items.get(position).getresim1());
	 * switch(id) {
	 * 
	 * 
	 * 
	 * } return convertView;
	 * 
	 * } }
	 * 
	 * 
	 * int id=0;
	 * 
	 * ArrayList<Egzersiz> productArray = new ArrayList<Egzersiz>();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void readDBdata_egzersiz( String deger) { veritabani dbh = new
	 * veritabani(this); SQLiteDatabase db = dbh.getWritableDatabase();
	 * 
	 * 
	 * String[] aranan={deger};
	 * 
	 * String v_adi;
	 * 
	 * if (Locale.getDefault().getLanguage().toString().equals("tr")==true){
	 * v_adi="egzersiz"; } else { v_adi="egzersiz_en";
	 * 
	 * }
	 * 
	 * Cursor cursor = db.query(v_adi, new String[] { "*"}, "id"+ "=? ",aranan,
	 * null, null, veritabani.name, null); productArray.clear(); if
	 * (cursor.moveToFirst()) {
	 * 
	 * id = cursor.getInt(cursor.getColumnIndex("id")); String ad =
	 * cursor.getString((cursor.getColumnIndex("adi"))); String anakas =
	 * cursor.getString((cursor.getColumnIndex("anakas"))); String yankas =
	 * cursor.getString((cursor.getColumnIndex("yankas"))); String ekipman =
	 * cursor.getString((cursor.getColumnIndex("ekipman"))); String aciklama =
	 * cursor.getString((cursor.getColumnIndex("aciklama")));
	 * 
	 * String puan=cursor.getString((cursor.getColumnIndex("puan")));
	 * 
	 * 
	 * 
	 * int resim1=0;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * switch(id) { case 1:resim1=R.drawable.bicep_curls_1;break; case
	 * 2:resim1=R.drawable.bicep_curl_with_deadlift_1;break; case
	 * 3:resim1=R.drawable.close_grip_ez_bar_curl_1;break; case
	 * 4:resim1=R.drawable.close_grip_standing_bicep_curls_1;break; case
	 * 5:resim1=R.drawable.drag_curl_1;break; case
	 * 6:resim1=R.drawable.ez_bar_curl_1;break; case
	 * 7:resim1=R.drawable.lying_high_bench_biceps_curl_1;break; case
	 * 8:resim1=R.drawable.lying_incline_curl_1;break; case
	 * 9:resim1=R.drawable.one_arm_bicep_curl_with_olympic_bar_1;break; case
	 * 10:resim1=R.drawable.preacher_curl_3_1;break; case
	 * 11:resim1=R.drawable.seated_close_grip_concentration_curls_1;break; case
	 * 12:resim1=R.drawable.spider_curl_1;break; case
	 * 13:resim1=R.drawable.wide_grip_standing_biceps_curl_1;break; case
	 * 14:resim1=R.drawable.chin_ups_1;break; case
	 * 15:resim1=R.drawable.chin_ups_2;break; case
	 * 16:resim1=R.drawable.narrow_parallel_grip_chin_ups_2;break; case
	 * 17:resim1=R.drawable.hammer_curls_with_rope_1;break; case
	 * 18:resim1=R.drawable.high_cable_curls_1;break; case
	 * 19:resim1=R.drawable.lying_bicep_cable_curl_1;break; case
	 * 20:resim1=R.drawable.lying_close_grip_biceps_curls_1;break; case
	 * 21:resim1=R.drawable.overhead_curl_1;break; case
	 * 22:resim1=R.drawable.preacher_curl_1;break; case
	 * 23:resim1=R.drawable.standing_biceps_curl_1;break; case
	 * 24:resim1=R.drawable.standing_one_arm_bicep_curl_1;break; case
	 * 25:resim1=R.drawable.alternate_bicep_curl_1;break; case
	 * 26:resim1=R.drawable.alternate_hammer_curl_1;break; case
	 * 27:resim1=R.drawable.alternate_incline_curl_1;break; case
	 * 28:resim1=R.drawable.incline_biceps_curl_1;break; case
	 * 29:resim1=R.drawable.biceps_curl_squat_1;break; case
	 * 30:resim1=R.drawable.biceps_curl_seated_on_stability_ball_1;break; case
	 * 31:resim1=R.drawable.biceps_curl_v_sit_on_dome_1;break; case
	 * 32:resim1=R.drawable
	 * .biceps_curl_with_overhead_extension_kneeling_on_sb_1;break; case
	 * 33:resim1=R.drawable.step_up_single_leg_balance_with_bicep_curl_1;break;
	 * case 34:resim1=R.drawable.bicep_hammer_curl_1;break; case
	 * 35:resim1=R.drawable.concentration_curls_1;break; case
	 * 36:resim1=R.drawable.cross_body_hammer_curl_1;break; case
	 * 37:resim1=R.drawable.biceps_curl_1;break; case
	 * 38:resim1=R.drawable.one_arm_bicep_concentration_on_stability_ball_1
	 * ;break; case 39:resim1=R.drawable.two_arm_preacher_curl_1;break; case
	 * 40:resim1=R.drawable.flexor_incline_curls_1;break; case
	 * 41:resim1=R.drawable.forward_lunge_with_bicep_curl_1;break; case
	 * 42:resim1=R.drawable.incline_inner_biceps_curl_1;break; case
	 * 43:resim1=R.drawable.lateral_lunge_with_bicep_curl_1;break; case
	 * 44:resim1=R.drawable.lying_supine_biceps_curl_1;break; case
	 * 45:resim1=R.drawable.one_arm_preacher_curl_1;break; case
	 * 46:resim1=R.drawable.preacher_hammer_curl_1;break; case
	 * 47:resim1=R.drawable.prone_incline_biceps_curl_1;break; case
	 * 48:resim1=R.drawable.biceps_curl_reverse_1;break; case
	 * 49:resim1=R.drawable.seated_bicep_curl_1;break; case
	 * 50:resim1=R.drawable.seated_inner_biceps_curl_1;break; case
	 * 51:resim1=R.drawable.standing_inner_biceps_curl_1;break; case
	 * 52:resim1=R.drawable.standing_one_arm_curl_over_incline_bench_1;break;
	 * case 53:resim1=R.drawable.bicep_curl_stork_stance_1;break; case
	 * 54:resim1=R.drawable.zottman_curl_1;break; case
	 * 55:resim1=R.drawable.zottman_preacher_curl_1;break; case
	 * 56:resim1=R.drawable.decline_ez_bar_triceps_extension_1;break; case
	 * 57:resim1=R.drawable.incline_triceps_extension_2_1;break; case
	 * 58:resim1=R.drawable.old_school_reverse_extensions_1;break; case
	 * 59:resim1
	 * =R.drawable.lying_close_grip_triceps_extension_behind_the_head_1;break;
	 * case 60:resim1=R.drawable.narrow_grip_bench_press_1;break; case
	 * 61:resim1=R.drawable.decline_close_grip_bench_to_skull_crusher_1;break;
	 * case 62:resim1=R.drawable.jm_press_1;break; case
	 * 63:resim1=R.drawable.reverse_triceps_bench_press_1;break; case
	 * 64:resim1=R.drawable.seated_overhead_triceps_extension_1;break; case
	 * 65:resim1=R.drawable.lying_triceps_press_1;break; case
	 * 66:resim1=R.drawable.close_grip_bench_press_1;break; case
	 * 67:resim1=R.drawable.standing_overhead_triceps_extension_1;break; case
	 * 68:resim1=R.drawable.bench_dips_1;break; case
	 * 69:resim1=R.drawable.close_triceps_pushup_1;break; case
	 * 70:resim1=R.drawable.standing_towel_triceps_extension_1;break; case
	 * 71:resim1=R.drawable.tricep_dips_2_1;break; case
	 * 72:resim1=R.drawable.incline_triceps_extension_1;break; case
	 * 73:resim1=R.drawable.lying_triceps_extension_1;break; case
	 * 74:resim1=R.drawable.incline_triceps_extension_1;break; case
	 * 75:resim1=R.drawable.kneeling_concentration_triceps_extension_1;break;
	 * case 76:resim1=R.drawable.kneeling_triceps_extension_1;break; case
	 * 77:resim1=R.drawable.low_triceps_extension_1;break; case
	 * 78:resim1=R.drawable.one_arm_tricep_extension_1;break; case
	 * 79:resim1=R.drawable.reverse_grip_triceps_pushdown_1;break; case
	 * 80:resim1=R.drawable.standing_triceps_extension_1;break; case
	 * 81:resim1=R.
	 * drawable.standing_one_arm_low_pulley_triceps_extension_1;break; case
	 * 82:resim1=R.drawable.triceps_pushdown_1;break; case
	 * 83:resim1=R.drawable.triceps_pushdown_with_rope_1;break; case
	 * 84:resim1=R.drawable.triceps_pushdown_with_v_bar_1;break; case
	 * 85:resim1=R.drawable.decline_triceps_extension_1;break; case
	 * 86:resim1=R.drawable.lying_supine_two_arm_triceps_extension_1;break; case
	 * 87:resim1=R.drawable.incline_triceps_extensions_1;break; case
	 * 88:resim1=R.drawable.lying_triceps_extension_2_1;break; case
	 * 89:resim1=R.drawable.lying_triceps_extension_across_face_1;break; case
	 * 90:resim1=R.drawable.one_arm_triceps_extension_1;break; case
	 * 91:resim1=R.drawable.seated_bent_over_one_arm_triceps_extension_1;break;
	 * case 92:resim1=R.drawable.single_arm_pronated_triceps_extension_1;break;
	 * case 93:resim1=R.drawable.single_arm_supinated_triceps_extension_1;break;
	 * case 94:resim1=R.drawable.standing_one_arm_triceps_extension_1;break;
	 * case 95:resim1=R.drawable.tate_press_1;break; case
	 * 96:resim1=R.drawable.seated_triceps_press_1;break; case
	 * 97:resim1=R.drawable.triceps_kickback_1;break; case
	 * 98:resim1=R.drawable.tricep_dips_1;break; case
	 * 99:resim1=R.drawable.triceps_extensions_1;break; case
	 * 100:resim1=R.drawable.barbell_deadlift_1;break; case
	 * 101:resim1=R.drawable.bent_arm_pullover_1;break; case 102:resim1=0;break;
	 * case 103:resim1=R.drawable.barbell_rear_delt_row_1;break; case
	 * 104:resim1=R.drawable.good_mornings_1;break; case
	 * 105:resim1=R.drawable.romanian_deadlift_1;break; case
	 * 106:resim1=R.drawable.one_arm_side_deadlift_1;break; case
	 * 107:resim1=R.drawable.barbell_clean_1;break; case
	 * 108:resim1=R.drawable.reverse_grip_bent_over_rows_1;break; case
	 * 109:resim1=R.drawable.romanian_deadlift_1;break; case 110:resim1=0;break;
	 * case 111:resim1=R.drawable.hyperextensions_1;break; case
	 * 112:resim1=R.drawable.body_row_1;break; case
	 * 113:resim1=R.drawable.chin_ups_1;break; case
	 * 114:resim1=R.drawable.climbers_chin_up_1;break; case
	 * 115:resim1=R.drawable.chin_ups_2;break; case
	 * 116:resim1=R.drawable.narrow_parallel_grip_chin_ups_1;break; case
	 * 117:resim1=0;break; case 118:resim1=0;break; case
	 * 119:resim1=R.drawable.bent_over_cable_lateral_raises_1;break; case
	 * 120:resim1=R.drawable.close_grip_front_lat_pull_down_1;break; case
	 * 121:resim1=R.drawable.wide_grip_lat_pull_down_1;break; case
	 * 122:resim1=R.drawable.underhand_pull_downs_1;break; case
	 * 123:resim1=R.drawable.cable_seated_rear_lateral_raise_1;break; case
	 * 124:resim1=R.drawable.cable_seated_rows_1;break; case
	 * 125:resim1=R.drawable.straight_arm_push_down_1;break; case
	 * 126:resim1=R.drawable.v_bar_pull_down_1;break; case
	 * 127:resim1=R.drawable.dumbbell_deadlift_1;break; case 128:resim1=0;break;
	 * case 129:resim1=R.drawable.rear_deltoid_row_1;break; case
	 * 130:resim1=R.drawable.dumbbell_clean_1;break; case 131:resim1=0;break;
	 * case 132:resim1=R.drawable.lying_one_arm_rear_lateral_raise_1;break; case
	 * 133:resim1=R.drawable.lying_rear_lateral_raise_1;break; case
	 * 134:resim1=R.drawable.romanian_deadlift_1;break; case 135:resim1=0;break;
	 * case 136:resim1=R.drawable.smith_machine_rear_deltoid_row_1;break; case
	 * 137:resim1=R.drawable.good_mornings_2_1;break; case
	 * 138:resim1=R.drawable.dead_lifts_1;break; case
	 * 139:resim1=R.drawable.butterfly_machine_1;break; case
	 * 140:resim1=R.drawable.bench_press_2_1;break; case
	 * 141:resim1=R.drawable.decline_chest_press_1;break; case
	 * 142:resim1=R.drawable.incline_chest_press_2;break; case
	 * 143:resim1=R.drawable.bench_press_3_1;break; case
	 * 144:resim1=R.drawable.incline_bench_press_2_1;break; case
	 * 145:resim1=R.drawable.incline_flys_1;break; case
	 * 146:resim1=R.drawable.decline_dumbbell_bench_press_1;break; case
	 * 147:resim1=R.drawable.dumbbell_bench_press_1;break; case
	 * 148:resim1=0;break; case
	 * 149:resim1=R.drawable.dumbbell_decline_flys_1;break; case
	 * 150:resim1=R.drawable.dumbbell_flys_1;break; case
	 * 151:resim1=R.drawable.incline_press_2;break; case 152:resim1=0;break;
	 * case 153:resim1=R.drawable.hammer_grip_incline_bench_press_2;break; case
	 * 154:resim1=R.drawable.incline_flys_with_a_twist_2;break; case
	 * 155:resim1=R.drawable.one_arm_bench_press_2;break; case
	 * 156:resim1=R.drawable.flat_bench_cable_flys_2;break; case
	 * 157:resim1=R.drawable.cable_crossover_2;break; case
	 * 158:resim1=R.drawable.incline_cable_flyes_2;break; case
	 * 159:resim1=R.drawable.one_armed_biased_push_up_1;break; case
	 * 160:resim1=R.drawable.chest_dips_1;break; case
	 * 161:resim1=R.drawable.push_up_with_feet_on_an_exercise_ball_2;break; case
	 * 162:resim1=R.drawable.push_ups_3_1;break; case 163:resim1=0;break; case
	 * 164:resim1=R.drawable.close_triceps_pushup_1;break; case
	 * 165:resim1=R.drawable.push_ups_1;break; case
	 * 166:resim1=R.drawable.bent_arm_pullover_1;break; case
	 * 167:resim1=R.drawable.bench_press_1;break; case
	 * 168:resim1=R.drawable.decline_bench_press_1;break; case
	 * 169:resim1=R.drawable.incline_bench_press_1;break; case
	 * 170:resim1=R.drawable.wide_grip_bench_press_1;break; case
	 * 171:resim1=R.drawable.wide_grip_decline_bench_press_1;break; case
	 * 172:resim1=R.drawable.barbell_front_raises_1;break; case
	 * 173:resim1=R.drawable.seated_military_shoulder_press_2;break; case
	 * 174:resim1=R.drawable.barbell_shrugs_1;break; case
	 * 175:resim1=R.drawable.barbell_upright_rows_1;break; case
	 * 176:resim1=0;break; case 177:resim1=R.drawable.hang_cleans_2;break; case
	 * 178:resim1=0;break; case
	 * 179:resim1=R.drawable.cable_front_raises_2;break; case
	 * 180:resim1=0;break; case
	 * 181:resim1=R.drawable.bent_over_cable_lateral_raises_2;break; case
	 * 182:resim1=R.drawable.cable_shrugs_2;break; case
	 * 183:resim1=R.drawable.cable_upright_rows_2;break; case
	 * 184:resim1=R.drawable.cable_seated_rear_lateral_raise_2;break; case
	 * 185:resim1=R.drawable.arnold_press_2;break; case
	 * 186:resim1=R.drawable.cuban_press_2;break; case
	 * 187:resim1=R.drawable.dumbbell_front_raises_2_2;break; case
	 * 188:resim1=R.drawable.dumbbell_lateral_raises_2;break; case
	 * 189:resim1=R.drawable.dumbbell_raise_2;break; case
	 * 190:resim1=R.drawable.dumbbell_shoulder_press_2;break; case
	 * 191:resim1=R.drawable.dumbbell_shrugs_2;break; case
	 * 192:resim1=R.drawable.dumbbell_upright_row_2;break; case
	 * 193:resim1=R.drawable.iron_cross_1_935x1024;break; case
	 * 194:resim1=R.drawable.one_arm_upright_row_2;break; case
	 * 195:resim1=R.drawable.lying_rear_lateral_raise_2;break; case
	 * 196:resim1=R.drawable.lying_one_arm_rear_lateral_raise_2;break; case
	 * 197:resim1=R.drawable.shoulder_press_machine_2;break; case
	 * 198:resim1=R.drawable.smith_machine_shrugs_2;break; case
	 * 199:resim1=R.drawable.smith_machine_upright_row_2;break; case
	 * 200:resim1=R.drawable.crunches_1;break; case
	 * 201:resim1=R.drawable.bent_knee_hip_raise_1;break; case
	 * 202:resim1=0;break; case 203:resim1=R.drawable.cross_body_crunch_1;break;
	 * case 204:resim1=R.drawable.ab_rollout_1;break; case
	 * 205:resim1=R.drawable.ab_rollout_on_knees_1;break; case
	 * 206:resim1=R.drawable.seated_ab_crunch_1;break; case
	 * 207:resim1=R.drawable.side_bend_1;break; case
	 * 208:resim1=R.drawable.decline_crunch_1;break; case
	 * 209:resim1=R.drawable.decline_oblique_crunch_1;break; case
	 * 210:resim1=R.drawable.crunches_with_legs_on_stability_ball_1;break; case
	 * 211:resim1=R.drawable.exercise_ball_pull_in_1;break; case
	 * 212:resim1=0;break; case 213:resim1=R.drawable.side_plank_1;break; case
	 * 214:resim1=R.drawable.stability_ball_abdominal_crunch_1;break; case
	 * 215:resim1=R.drawable.leg_raises_2;break; case
	 * 216:resim1=R.drawable.barbell_deadlift_1;break; case
	 * 217:resim1=R.drawable.one_arm_side_deadlift_2;break; case
	 * 218:resim1=R.drawable.barbell_clean_1;break; case
	 * 219:resim1=R.drawable.romanian_deadlift_1;break; case 220:resim1=0;break;
	 * case 221:resim1=R.drawable.romanian_deadlift_1;break; case
	 * 222:resim1=R.drawable.hyperextensions_1;break; case
	 * 223:resim1=R.drawable.dumbbell_deadlift_1;break; case
	 * 224:resim1=R.drawable.romanian_deadlift_1;break; case
	 * 225:resim1=R.drawable.barbell_clean_1;break; case
	 * 226:resim1=R.drawable.seated_leg_curl_1;break; case
	 * 227:resim1=R.drawable.good_mornings_2_1;break; case
	 * 228:resim1=R.drawable.dead_lifts_1;break; case
	 * 229:resim1=R.drawable.standing_leg_curl_2;break; case
	 * 230:resim1=R.drawable.calves_press_on_leg_machine_1;break; case
	 * 231:resim1=R.drawable.donkey_calf_raises_1;break; case
	 * 232:resim1=R.drawable.rocking_standing_calf_raise_1;break; case
	 * 233:resim1=R.drawable.seated_calf_raise_2_1;break; case
	 * 234:resim1=R.drawable.seated_one_leg_calf_raise_1;break; case
	 * 235:resim1=R.drawable.smith_machine_reverse_calf_raises_1;break; case
	 * 236:resim1=R.drawable.standing_barbell_calf_raise_1;break; case
	 * 237:resim1=R.drawable.standing_calf_raises_1;break; case
	 * 238:resim1=R.drawable.hack_squat_1_856x1024;break; case
	 * 239:resim1=R.drawable.lunges_2;break; case
	 * 240:resim1=R.drawable.squats_1;break; case
	 * 241:resim1=R.drawable.squat_to_bench_1_865x1024;break; case
	 * 242:resim1=R.drawable.one_leg_squat_2;break; case
	 * 243:resim1=R.drawable.front_squat_1_857x1024;break; case
	 * 244:resim1=R.drawable.front_squat_to_bench_1_858x1024;break; case
	 * 245:resim1=R.drawable.jefferson_squats_2_413x1024;break; case
	 * 246:resim1=R.drawable.overhead_squat_2;break; case
	 * 247:resim1=R.drawable.lunges_2;break; case
	 * 248:resim1=R.drawable.wide_stance_squat_2;break; case
	 * 249:resim1=R.drawable.side_split_squats_1_1024x600;break; case
	 * 250:resim1=R.drawable.single_leg_squat_1_877x1024;break; case
	 * 251:resim1=R.drawable.speed_squats_1;break; case
	 * 252:resim1=R.drawable.step_ups_1_801x1024;break; case
	 * 253:resim1=R.drawable.wide_stance_squat_1;break; case
	 * 254:resim1=R.drawable.zecher_squats_1;break; case
	 * 255:resim1=R.drawable.lunges_2_1;break; case
	 * 256:resim1=R.drawable.rear_lunges_2_1_611x1024;break; case
	 * 257:resim1=R.drawable.squats_3_1_436x1024;break; case
	 * 258:resim1=R.drawable.squat_to_bench_2_1_542x1024;break; case
	 * 259:resim1=R.drawable.step_ups_2_1_553x1024;break; case
	 * 260:resim1=R.drawable.pile_squat_2;break; case
	 * 261:resim1=R.drawable.walking_lunges_1;break; case
	 * 262:resim1=R.drawable.weighted_sissy_squat_1;break; case
	 * 263:resim1=R.drawable.hack_squats_1;break; case
	 * 264:resim1=R.drawable.leg_extensions_1_672x1024;break; case
	 * 265:resim1=R.drawable.leg_press_1_1024x670;break; case
	 * 266:resim1=R.drawable.lying_squat_2_990x1024;break; case
	 * 267:resim1=R.drawable.narrow_stance_hack_squats_1_1024x721;break; case
	 * 268:resim1=R.drawable.narrow_stance_leg_press_1_1024x671;break; case
	 * 269:resim1=R.drawable.hack_squat_2_2_768x1024;break; case
	 * 270:resim1=R.drawable.squats_2_1;break; case
	 * 271:resim1=R.drawable.hyperextensions_1;break; case
	 * 272:resim1=R.drawable.flutter_kicks_1;break; case
	 * 273:resim1=R.drawable.bridge_1;break; case
	 * 274:resim1=R.drawable.good_mornings_1;break; case
	 * 275:resim1=R.drawable.leg_lift_2;break; case
	 * 276:resim1=R.drawable.one_legged_kickback_2;break; case
	 * 277:resim1=R.drawable.good_mornings_2_1;break;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Egzersiz egzersiz; do { egzersiz = new
	 * Egzersiz(id,ad,anakas,yankas,aciklama,ekipman,puan); } while
	 * (cursor.moveToNext()); productArray.add(egzersiz); } if (cursor != null
	 * && !cursor.isClosed()) { cursor.close(); } db.close();
	 * 
	 * EgzersizAdapter adapter = new EgzersizAdapter(this, R.layout.urun2,
	 * productArray);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public class EgzersizAdapter extends ArrayAdapter<Egzersiz>{
	 * ArrayList<Egzersiz> items; public EgzersizAdapter(Context context, int
	 * textViewResourceId, ArrayList<Egzersiz> objects) { super(context,
	 * textViewResourceId, objects); this.items = objects; }
	 * 
	 * @Override public View getView(int position, View convertView, ViewGroup
	 * parent) { if (convertView == null) { LayoutInflater vi =
	 * (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 * convertView = vi.inflate(R.layout.urun2, null); }
	 * w_egzersiz_name.setText(items.get(position).getadi());
	 * 
	 * 
	 * 
	 * // egzersizID.setText(0); //
	 * egzersizName.setText(items.get(position).getadi()); //
	 * egzersiz_anakas.setText(items.get(position).getanakas()); //
	 * egzersiz_ekipman.setText(items.get(position).getekipman()); //
	 * egzersizID.setText(0); //
	 * egzersizName.setText(items.get(position).getadi()); //
	 * egzersiz_anakas.setText(items.get(position).getanakas()); //
	 * egzersiz_ekipman.setText(items.get(position).getekipman());
	 * 
	 * 
	 * return convertView; } }
	 */

}
