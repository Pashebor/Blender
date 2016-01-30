package com.example.viscosityapp;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActivityFive extends Activity implements OnClickListener  {
	
	
   
	
	final int MENU_QUIT_ID = 1;
	final int MENU_RESET_ID = 2;
	final String  LOG_TAG = "myLogs";
	
	EditText edTxt1, edTxt2, edTxt3, edTxt4, edTxt5, edTxt6, edTxt7, edTxt8;
	ImageButton imgPnt;
	ImageButton bRight;
	TextView tRez;
	String toTV = "";
	Handler h;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth);
		
		
		edTxt1 = (EditText) findViewById(R.id.etEdit1);
		edTxt2 = (EditText) findViewById(R.id.etEdit2);
		edTxt3 = (EditText) findViewById(R.id.etEdit3);
		edTxt4 = (EditText) findViewById(R.id.etEdit4);
		edTxt5 = (EditText) findViewById(R.id.etEdit5);
		edTxt6 = (EditText) findViewById(R.id.etEdit6);
		edTxt7 = (EditText) findViewById(R.id.etEdit7);
		edTxt8 = (EditText) findViewById(R.id.etEdit8);
		
		imgPnt = (ImageButton) findViewById(R.id.imgPnt);
		bRight = (ImageButton) findViewById(R.id.bRight);
		tRez = (TextView) findViewById(R.id.tRes);
		
		imgPnt.setOnClickListener(this);
		bRight.setOnClickListener(this);
		
				
	}
	
	
	
	
	public void onClick(View v){
		

		double w1 ;
		double w2 ;
		double w3 ;
		double w4 ;
		
		double pen1 ;
		double pen2 ;
		double pen3 ;
		double pen4 ;
  
		
		
		float r = 0;
	    float b6 = 0;
	    float b9 = 0;
	    
		double sum ;
		double penetr ;
		double logPenetr ;
		
		
	

		
		if(TextUtils.isEmpty(edTxt1.getText().toString())
			||TextUtils.isEmpty(edTxt2.getText().toString())
			||TextUtils.isEmpty(edTxt3.getText().toString())
			||TextUtils.isEmpty(edTxt4.getText().toString())
			||TextUtils.isEmpty(edTxt5.getText().toString())
			||TextUtils.isEmpty(edTxt6.getText().toString())
			||TextUtils.isEmpty(edTxt7.getText().toString())
			||TextUtils.isEmpty(edTxt8.getText().toString())){
			return;
		}
		w1 = Float.parseFloat(edTxt1.getText().toString());
		w2 = Float.parseFloat(edTxt2.getText().toString());
		w3 = Float.parseFloat(edTxt3.getText().toString());
		w4 = Float.parseFloat(edTxt4.getText().toString());
		
		pen1 = Float.parseFloat(edTxt5.getText().toString());
		pen2 = Float.parseFloat(edTxt6.getText().toString());
		pen3 = Float.parseFloat(edTxt7.getText().toString());
		pen4 = Float.parseFloat(edTxt8.getText().toString());
		
		
		switch (v.getId()) {
		case R.id.bRight:
			Intent intent = new Intent(this, ActivitySix.class);
			startActivity(intent);
			break;

		
		}
	switch(v.getId()){
	case R.id.imgPnt:
		
		if(  w3 == 0 && w4 == 0  ){
			sum = w1 + w2;
			logPenetr = ((w1 * Math.log10(pen1)) + ((w2 * Math.log10(pen2)))) / sum;
			penetr = Math.pow(10,logPenetr);
			
			r = (float) penetr;
			Log.d(LOG_TAG, "--Result--" );
			BigDecimal p = new BigDecimal(r);
			tRez.setText(toTV + p.setScale(0, RoundingMode.HALF_EVEN));
			break;
		}
		
		
		if( w4 == 0  ){
			sum = w1 + w2 + w3;
			logPenetr = ((w1 * Math.log10(pen1)) + ((w2 * Math.log10(pen2))) + (w3 * Math.log10(pen3))) / sum;
			penetr = Math.pow(10,logPenetr);
			r = (float) penetr;
			Log.d(LOG_TAG, "--Result--" );
			BigDecimal p = new BigDecimal(r);
			tRez.setText(toTV + p.setScale(0, RoundingMode.HALF_EVEN));
			break;
		}else{
			
			sum = w1 + w2 + w3 + w4;
			logPenetr = ((w1 * Math.log10(pen1)) + ((w2 * Math.log10(pen2))) + (w3 * Math.log10(pen3)) + (w4 * Math.log10(pen4)))/sum;
			penetr = Math.pow(10,logPenetr);
			r = (float) penetr;
			Log.d(LOG_TAG, "--Result--" );
			BigDecimal p = new BigDecimal(r);
			tRez.setText(toTV + p.setScale(0, RoundingMode.HALF_EVEN));
      break;
      
      
	}
	
	default:
		break;
	}
	
	
    
	
	
	}
	
	 public boolean onCreateOptionsMenu(Menu menu){
		 
		 menu.add(0,MENU_QUIT_ID,0,"Выйти");
		 return super.onCreateOptionsMenu(menu);
	 }
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()){
		case MENU_QUIT_ID:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	
			
		}	
		
		
	
	

	



