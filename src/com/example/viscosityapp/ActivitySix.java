package com.example.viscosityapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivitySix  extends Activity implements  OnClickListener{
    
	final int MENU_RESET_ID = 1;
	
	EditText etConst;
	EditText etPenetr;
	TextView tRes;
	ImageButton btnOil;
	String space;
  @Override
  public void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.six);
	  
	  etConst = (EditText) findViewById(R.id.etConst);
	  etPenetr = (EditText) findViewById(R.id.etPen);
	  
	  tRes = (TextView) findViewById(R.id.textRes);
	  
	  btnOil = (ImageButton) findViewById(R.id.btnOil);
	  btnOil.setOnClickListener(this);
  }


public void onClick(View v){
	
	double p = 0;
	double con = 0;
	double resultate = 0;
	
	if (TextUtils.isEmpty(etConst.getText().toString()) 
			|| TextUtils.isEmpty(etPenetr.getText().toString())) {
		return;
	}
	p = Float.parseFloat(etPenetr.getText().toString());
	con = Float.parseFloat(etConst.getText().toString());
	
	switch (v.getId()) {
	case R.id.btnOil:
		space = "";
		resultate = (float) (con - p)/10;
		break;
     
	default:
		break;
	}
	BigDecimal proc = new BigDecimal(resultate);
	tRes.setText(space + proc.setScale(1, RoundingMode.HALF_UP) + "%");
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// TODO Auto-generated method stub
menu.add(0, MENU_RESET_ID, 0, "Сброс");

return super.onCreateOptionsMenu(menu);
}

// обработка нажатий на пункты меню
@Override
public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
switch (item.getItemId()) {
case MENU_RESET_ID:
// очищаем поля
etConst.setText("");
etPenetr.setText("");
break;

}
return super.onOptionsItemSelected(item);
}

  
}
