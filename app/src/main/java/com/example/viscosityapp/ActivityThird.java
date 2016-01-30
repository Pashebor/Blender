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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityThird extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	

	EditText e1;
	EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    EditText e6;
    EditText e7;
    EditText e8;
	Button cunt;
	

	TextView tRslt;

	String oper = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);

		// находим элементы
		e1 = (EditText) findViewById(R.id.e1);
		e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        e6 = (EditText) findViewById(R.id.e6);
        e7 = (EditText) findViewById(R.id.e7);
        e8 = (EditText) findViewById(R.id.e8);
		cunt = (Button) findViewById(R.id.cunt);
		tRslt = (TextView) findViewById(R.id.tRslt);
    	// прописываем обработчик
		cunt.setOnClickListener(this);
	
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		double m1 = 0;
		double m2 = 0;
		double j1 = 0;
		double j2 = 0;
		double j3 = 0;
		double j4 = 0;
		double m3 = 0;
		double m4 = 0;
		
		float result = 0;
		double f=0;
        double p=0;
        double t=0;
        double z=0;
        double l=0;
        double g=0;
		// Проверяем поля на пустоту
		if (TextUtils.isEmpty(e1.getText().toString())
			|| TextUtils.isEmpty(e2.getText().toString())
			|| TextUtils.isEmpty(e3.getText().toString())
			|| TextUtils.isEmpty(e4.getText().toString())
			|| TextUtils.isEmpty(e5.getText().toString())
			|| TextUtils.isEmpty(e6.getText().toString())
			|| TextUtils.isEmpty(e7.getText().toString())
			|| TextUtils.isEmpty(e8.getText().toString())){
			return;
		}

		// читаем EditText и заполняем переменные числами
		m1 = Float.parseFloat(e2.getText().toString());
		m2 = Float.parseFloat(e4.getText().toString());
		m3 = Float.parseFloat(e6.getText().toString());
		m4 = Float.parseFloat(e8.getText().toString());
		j1 = Float.parseFloat(e1.getText().toString());
        j2 = Float.parseFloat(e3.getText().toString());
        j3 = Float.parseFloat(e5.getText().toString());
        j4 = Float.parseFloat(e7.getText().toString());
		// определяем нажатую кнопку и выполняем соответствующую операцию
		// в oper пишем операцию, потом будем использовать в выводе
		switch (v.getId())
		{
		
		case R.id.cunt:
			oper = "";
			f = (m1*(Math.log10(Math.log10(j1+0.8))))+(m2*(Math.log10(Math.log10(j2+0.8))))+(m3*(Math.log10(Math.log10(j3+0.8))));
			g = f+(m4*(Math.log10(Math.log10(j4+0.8)))); 
			l = g/(m1+m3+m2+m4);
			p = Math.pow(10, l);
			t = Math.pow(10, p);
			z = t - 0.8;
			result= (float) z;
			
			break;
		
		}
	

		// формируем строку вывода
		BigDecimal n=new BigDecimal(result);
		tRslt.setText(  oper  + n.setScale(3, RoundingMode.HALF_UP));
	}
	
	// создание меню
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
	e1.setText("");
	e2.setText("");
	e3.setText("");
	e4.setText("");
	e5.setText("");
	e6.setText("");
	tRslt.setText("");
	break;
	
	}
	return super.onOptionsItemSelected(item);
	}
}

