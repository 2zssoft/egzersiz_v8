package com.zs.fitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class veritabani extends SQLiteOpenHelper {
	private static final String VERITABANI_ISMI = "main";
	private static final int VERITABANI_SURUMU = 1;
	static final String egzersiz_tbl = "egzersiz";
	static final String routines_tbl = "routines";
	static final String routines_w_tbl = "routine_works";
	static  final String kullanici="kullanici";
	static String name = "adi";

	static String id = "id";

	public veritabani(Context context) {

		super(context, VERITABANI_ISMI, null, VERITABANI_SURUMU);
		// TODO Auto-generated constructor stub
	}

	/*
	 * public static String DB_FILEPATH =
	 * "/data/data/com.example.kondisyon/databases/main";
	 * 
	 * /** Copies the database file at the specified location over the current
	 * internal application database.
	 */
	/*
	 * public boolean importDatabase(String dbPath) throws IOException {
	 * 
	 * // Close the SQLiteOpenHelper so it will commit the created empty //
	 * database to internal storage. close(); File newDb = new File(dbPath);
	 * File oldDb = new File(DB_FILEPATH);
	 * 
	 * if (newDb.exists()) { FileUtils.copyFile(new FileInputStream(newDb), new
	 * FileOutputStream(oldDb)); // Access the copied database so SQLiteHelper
	 * will cache it and mark // it as created. getWritableDatabase().close();
	 * return true; } return false; }
	 */

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE  TABLE  IF NOT EXISTS 'main'.'egzersiz' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 'name' VARCHAR,'title' VARCHAR, 'primer' VARCHAR, 'type' VARCHAR, 'ana_kas' VARCHAR, 'secondary' VARCHAR, 'equipment' VARCHAR, 'png1' VARCHAR, 'png2' VARCHAR, 'png3' VARCHAR, 'steps' VARCHAR, 'tips' VARCHAR)");
		db.execSQL("CREATE  TABLE  IF NOT EXISTS 'main'.'routines' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 'name' VARCHAR NOT NULL , 'odakbolgesi' VARCHAR NOT NULL,'resmi' VARCHAR,'seviye' VARCHAR)");
		db.execSQL("CREATE  TABLE  IF NOT EXISTS 'main'.'works' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 'sets' INTEGER NOT NULL , 'reps' INTEGER NOT NULL,'dinlenme' INTEGER,'egzersiz_id' INTEGER)");
		db.execSQL("CREATE  TABLE  IF NOT EXISTS 'main'.'routine_works' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 'routine_id' INTEGER NOT NULL , 'work_id' INTEGER NOT NULL, 'sirasi' INTEGER)");
		db.execSQL("CREATE  TABLE  IF NOT EXISTS 'main'.'kullanici' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 'k_adi' VARCHAR NOT NULL , 'cinsiyet' VARCHAR NOT NULL, 'boy' INTEGER, 'kilo' INTEGER)");
		db.execSQL("PRAGMA encoding='utf-16be'");

		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.execSQL("DROP TABLE IF NOT EXISTS main");

	}

}
