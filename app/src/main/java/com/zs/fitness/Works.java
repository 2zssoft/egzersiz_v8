package com.zs.fitness;

import java.io.Serializable;

public class Works implements Serializable {
	// private variables
	int works_id;
	int work_set;
	int works_reps;
	int works_dinlenme;
	int works_egzersiz_id;
	int setsure;
	String works_egzersiz_adi;
	Egzersiz egzersiz;

	public  Works()
	{

	}
	// Empty constructor
	public Works(int id, int work_set, int works_reps, int works_dinlenme,
				 int works_egzersiz_id,int sure,String egzer_adi) {
		this.works_id = works_id;
		this.work_set = work_set;
		this.works_reps = works_reps;
		this.works_dinlenme = works_dinlenme;
		this.works_egzersiz_id = works_egzersiz_id;
		this.works_egzersiz_adi=egzer_adi;
		this.setsure=sure;
	}
	// constructor

	public Works(int id, int work_set, int works_reps, int works_dinlenme,
				 int works_egzersiz_id,int sure,Egzersiz egzer) {
		this.works_id = works_id;
		this.work_set = work_set;
		this.works_reps = works_reps;
		this.works_dinlenme = works_dinlenme;
		this.works_egzersiz_id = works_egzersiz_id;
		this.egzersiz=egzer;
		this.setsure=sure;
	}

	// constructor
	public Works(int work_set, int works_reps, int works_dinlenme,
				 int works_egzersiz_id, int sure, String egzersiz_adi) {

		this.work_set = work_set;
		this.works_reps = works_reps;
		this.works_dinlenme = works_dinlenme;
		this.works_egzersiz_id = works_egzersiz_id;
		this.works_egzersiz_adi=egzersiz_adi;
		this.setsure=sure;

	}

	// getting ID
	public int getID() {
		return this.works_id;
	}

	// setting id
	public void setID(int works_id) {
		this.works_id = works_id;
	}

	public int get_sets() {
		return this.work_set;
	}

	public void set_sets(int work_set) {
		this.work_set = work_set;
	}

	public int get_works_reps() {
		return this.works_reps;
	}

	public void set_works_reps(int works_reps) {
		this.works_reps = works_reps;
	}

	public int get_works_dinlenme() {
		return this.works_dinlenme;
	}

	public void set_works_dinlenme(int works_dinlenme) {
		this.works_dinlenme = works_dinlenme;
	}

	//
	public int getegzersiz() {
		return this.works_egzersiz_id;
	}

	public void setegzersiz(int works_egzersiz_id) {
		this.works_egzersiz_id = works_egzersiz_id;
	}

	public String getegzersiz_adi() {
		return this.works_egzersiz_adi;
	}


	public int get_sure() {
		return this.setsure;
	}

	public Egzersiz getEgzersizl() {
		return egzersiz;
	}

	public void setSetsure(int setsure) {
		this.setsure = setsure;
	}

	public void setEgzersiz(Egzersiz egzersiz) {
		this.egzersiz = egzersiz;
	}
}



