package com.zs.fitness;

public class Routines_Works {
	
	//private variables
	int re_id;
	int r_routine_id;
	
	int works_id;
	int rt_sira;


	


	
	// Empty constructor

	// constructor
	
	public Routines_Works(int re_id,int r_routine_id, int works_id, int rt_sira){
		this.re_id=re_id;
		this.r_routine_id=r_routine_id;
		this.works_id=works_id;
		this.rt_sira=rt_sira;

			
		}
	
	public Routines_Works(int r_routine_id, int works_id, int rt_sira){
	this.r_routine_id=r_routine_id;
	this.works_id=works_id;
	this.rt_sira=rt_sira;

		
	}
	
	// getting ID
	public int get_re_id(){
		return this.re_id;
	}
	
	// setting id
	public void set_re_id(int re_id){
		this.re_id = re_id;
	}
	
	
	// getting ID
	public int get_routine_id(){
		return this.r_routine_id;
	}
	
	// setting id
	public void set_routine_id(int r_routine_id){
		this.r_routine_id = r_routine_id;
	}
	
	
	public int get_works_id(){
		return this.works_id;
	}
	
	
	public void set_works_id(int works_id){
		this.works_id = works_id;
	}
	
	
	public int get_sira(){
		return this.rt_sira;
	}
	
	
	public void set_sira(int rt_sira){
		this.rt_sira = rt_sira;
	}
	

}
