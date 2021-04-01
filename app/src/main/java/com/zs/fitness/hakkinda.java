package com.zs.fitness;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;


public class hakkinda extends AppCompatActivity {
	private static final String TAG = "MainActivity";


	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hakkinda);

		ImageView img = (ImageView)findViewById(R.id.imageView6);
		/*String mDrawableName = "relaxation0018" ;
        int resID = getResources().getIdentifier(mDrawableName , "drawable" ,
                getPackageName()) ;
		img.setImageResource(resID);*/


	}

}
