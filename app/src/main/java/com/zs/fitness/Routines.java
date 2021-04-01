package com.zs.fitness;

public class Routines {

	// private variables
	int routine_id;
	String routine_name;
	String odakbolgesi;
	String rutin_resmi;
	int rutin_sure;
	String seviye;

	// Empty constructor

	// constructor
	public Routines(int routine_id, String routine_name, String odakbolgesi,String resim) {
		this.routine_id = routine_id;
		this.routine_name = routine_name;
		this.odakbolgesi = odakbolgesi;
		this.rutin_resmi=resim;

	}
	public Routines(int routine_id, String routine_name, String odakbolgesi,String resim,String seviye) {
		this.routine_id = routine_id;
		this.routine_name = routine_name;
		this.odakbolgesi = odakbolgesi;
		this.rutin_resmi=resim;
		this.seviye=seviye;

	}
	// constructor
	public Routines(String routine_name, String odakbolgesi,String resim) {

		this.routine_name = routine_name;
		this.odakbolgesi = odakbolgesi;
		this.rutin_resmi=resim;
	}
	public Routines(String routine_name, String odakbolgesi,String resim,int rutin_sure,String seviye) {

		this.routine_name = routine_name;
		this.odakbolgesi = odakbolgesi;
		this.rutin_resmi=resim;
		this.rutin_sure=rutin_sure;
		this.seviye=seviye;

	}
	// getting ID
	public int getID() {
		return this.routine_id;
	}

	// setting id
	public void setID(int routine_id) {
		this.routine_id = routine_id;
	}

	// getting name
	public String getname() {
		return this.routine_name;
	}

	// setting name
	public void setname(String routine_name) {
		this.routine_name = routine_name;
	}

	// getting phone number


	public String getresim() {
		return this.rutin_resmi;
	}


	public void setresim(String resim) {
		this.rutin_resmi = resim;
	}

	public String getOdakbolgesi() {
		return odakbolgesi;
	}

	public int getRutin_sure() {
		return rutin_sure;
	}

	public String getSeviye() {
		return seviye;
	}

	public void setSeviye(String seviye) {
		this.seviye = seviye;
	}

	public void setOdakbolgesi(String odakbolgesi) {
		this.odakbolgesi = odakbolgesi;
	}

	public void setRutin_sure(int rutin_sure) {
		this.rutin_sure = rutin_sure;
	}
}
