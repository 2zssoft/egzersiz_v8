package com.zs.fitness;

public class Egzersiz {

	//private variables
	int _id;
	String _adi;
	String _ekipman;
	String _title;
	String _primer;
	String _png1;
	String _png2;
	String _png3;
	String _tips;
	String _aciklama; //steps
	String _puan;
	String _anakas; //primary
	String _yankas; //secondary
	int _png1resid;
	int _png2resid;
	int _png3resid;


	// Empty constructor

	// constructor
	public Egzersiz(int id, String adi, String _anakas, String _yankas, String aciklama, String ekipman, String puan) {
		this._id = id;
		this._adi = adi;
		this._anakas = _anakas;
		this._yankas = _yankas;
		this._ekipman = ekipman;
		this._puan = puan;

		this._aciklama = aciklama;

	}

	public Egzersiz()
	{

	}
	public Egzersiz(int id,String adi, String ana_kas, String yan_kas, String aciklama, String ekipman,String primer,String png1,String png2,String png3,String tips,String title)

	{
		this._id=id;
		this._adi = adi;
		this._title=title;
				this._png1=png1;
		this._png2=png2;
		this._png3=png3;
		this._primer=primer;
		this._tips=tips;
		this._anakas = ana_kas;
		this._yankas = yan_kas;
		this._ekipman = ekipman;


		this._aciklama = aciklama;
	}
	
	// constructor
	public Egzersiz(String adi, String ana_kas, String yan_kas, String aciklama, String ekipman, String puan){
		this._adi = adi;
		this._anakas = ana_kas;
		this._yankas = yan_kas;
		this._ekipman = ekipman;
		this._puan=puan;

		this._aciklama=aciklama;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getadi(){
		return this._adi;
	}
	
	// setting name
	public void setadi(String adi){
		this._adi = adi;
	}
	
	// getting phone number
	public String getanakas(){
		return this._anakas;
	}
	
	// setting phone number
	public void setanakas(String ana_kas){
		this._anakas = ana_kas;
	}
	
	// getting yan_kas
		public String getyankas(){
			return this._yankas;
		}
		
		// setting name
		public void setyankas(String yan_kas){
			this._yankas = yan_kas;
		}
		
		
		public String getpuan(){
			return this._puan;
		}
		
		// setting name
		public void setpuan(String puan){
			this._puan = puan;
		}
		
		//getting ekipman
		public String getekipman(){
			return this._ekipman;
		}
		
		// setting ekipman
		public void setekipman(String ekipman){
			this._ekipman = ekipman;
		}
		
		

		
		
		//getting Aciklama
		public String getaciklama(){
			return this._aciklama;
		}
		
		// setting Aciklama
		public void setaciklama(String aciklama){
			this._aciklama = aciklama;
		}

	public void set_png1(String _png1) {
		this._png1 = _png1;
	}

	public void set_png2(String _png2) {
		this._png2 = _png2;
	}

	public void set_png3(String _png3) {
		this._png3 = _png3;
	}

	public void set_primer(String _primer) {
		this._primer = _primer;
	}

	public void set_png1resid(int _png1resid) {
		this._png1resid = _png1resid;
	}

	public void set_png2resid(int _png2resid) {
		this._png2resid = _png2resid;
	}

	public void set_png3resid(int _png3resid) {
		this._png3resid = _png3resid;
	}

	public void set_tips(String _tips) {
		this._tips = _tips;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	public String get_png1() {
		return _png1;
	}

	public String get_png2() {
		return _png2;
	}

	public int get_png1resid() {
		return _png1resid;
	}

	public int get_png2resid() {
		return _png2resid;
	}

	public int get_png3resid() {
		return _png3resid;
	}

	public String get_primer() {
		return _primer;
	}

	public String get_png3() {
		return _png3;
	}

	public String get_title() {
		return _title;
	}

	public String get_tips() {
		return _tips;
	}

}
