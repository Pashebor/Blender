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

public class ActivitySecond extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	

	EditText ed1;
	EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;
	Button count;
	
	TextView tvRslt;

	String oper = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		// находим элементы
		ed1 = (EditText) findViewById(R.id.ed1);
		ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        ed6 = (EditText) findViewById(R.id.ed6);
		count = (Button) findViewById(R.id.count);
		tvRslt = (TextView) findViewById(R.id.tvRslt);
    	// прописываем обработчик
		count.setOnClickListener(this);
	
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		double m1 = 0;
		double m2 = 0;
		double j1 = 0;
		double j2 = 0;
		double j3 = 0;
		double m3 = 0;
		float result = 0;
		double f=0;
        double p=0;
        double t=0;
        double z=0;
        double l=0;
		// Проверяем поля на пустоту
		if (TextUtils.isEmpty(ed1.getText().toString())
			|| TextUtils.isEmpty(ed2.getText().toString())
			|| TextUtils.isEmpty(ed3.getText().toString())
			|| TextUtils.isEmpty(ed4.getText().toString())
			|| TextUtils.isEmpty(ed5.getText().toString())
			|| TextUtils.isEmpty(ed6.getText().toString())){
			return;
		}

		// читаем EditText и заполняем переменные числами
		m1 = Float.parseFloat(ed2.getText().toString());
		m2 = Float.parseFloat(ed4.getText().toString());
		m3 = Float.parseFloat(ed6.getText().toString());
		j1 = Float.parseFloat(ed1.getText().toString());
        j2 = Float.parseFloat(ed3.getText().toString());
        j3 = Float.parseFloat(ed5.getText().toString());
        
		// определяем нажатую кнопку и выполняем соответствующую операцию
		// в oper пишем операцию, потом будем использовать в выводе
		switch (v.getId())
		{
		
		case R.id.count:
			oper = "";
			f = (m1*(Math.log10(Math.log10(j1+0.8))))+(m2*(Math.log10(Math.log10(j2+0.8))))+(m3*(Math.log10(Math.log10(j3+0.8))));
			l = f/(m1+m3+m2);
			p = Math.pow(10, l);
			t = Math.pow(10, p);
			z = t - 0.8;
			result= (float) z;
			
			break;
		
		}
	

		// формируем строку вывода
		BigDecimal n=new BigDecimal(result);
		tvRslt.setText(  oper  + n.setScale(3, RoundingMode.HALF_UP));
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
	ed1.setText("");
	ed2.setText("");
	ed3.setText("");
	ed4.setText("");
	ed5.setText("");
	ed6.setText("");
	tvRslt.setText("");
	break;
	
	}
	return super.onOptionsItemSelected(item);
	}
}
