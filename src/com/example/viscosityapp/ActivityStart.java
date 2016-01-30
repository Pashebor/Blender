package com.example.viscosityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityStart extends Activity implements OnClickListener{

	final int MENU_QUIT_ID = 1;
	Button btnFirst;
    Button btnSecond;
    Button btnThird;
    Button btnFourth;
    Button btnFifth;
@Override
public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.start);
	
	btnFirst = (Button) findViewById(R.id.btnFirst);
	btnSecond = (Button) findViewById(R.id.btnSecond);
	btnThird = (Button) findViewById(R.id.btnThird);
	btnFourth = (Button) findViewById(R.id.btnFourth);
	btnFifth = (Button) findViewById(R.id.btnFifth);
	
	btnFirst.setOnClickListener(this);
	btnSecond.setOnClickListener(this);
	btnThird.setOnClickListener(this);
	btnFourth.setOnClickListener(this);
	btnFifth.setOnClickListener(this);
	
}
public void onClick(View v){
	switch (v.getId()){
	case R.id.btnFirst:
		Intent intent = new Intent(this,ActivityFirst.class);
		startActivity(intent);
		break;	
	}
	switch(v.getId()){
	case R.id.btnSecond:
		Intent intent = new Intent(this,ActivitySecond.class);
		startActivity(intent);
		break;
	}
	switch(v.getId()){
	case R.id.btnThird:
		Intent intent = new Intent(this,ActivityThird.class);
		startActivity(intent);
		break;
	}
	switch(v.getId()){
	case R.id.btnFourth:
		Intent intent = new Intent(this,ActivityFourth.class);
		startActivity(intent);
		break;
	}
	switch(v.getId()){
	case R.id.btnFifth:
		Intent intent = new Intent(this, ActivityFive.class);
		startActivity(intent);
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

