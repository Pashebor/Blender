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

public class ActivityFourth extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	

	EditText edit1;
	EditText edit2;
    EditText edit3;
    EditText edit4;
	Button btnCount;
	

	TextView tvRez;

	String oper = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth);

		// находим элементы
		edit1 = (EditText) findViewById(R.id.edit1);
		edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
		btnCount = (Button) findViewById(R.id.btnCount);
		tvRez = (TextView) findViewById(R.id.tvRez);
    	// прописываем обработчик
		btnCount.setOnClickListener(this);
	
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		double m1 = 0;
		double nj = 0;
		double j1 = 0;
		double j2 = 0;
		float result = 0;
		double f=0;
        
        
		// Проверяем поля на пустоту
		if (TextUtils.isEmpty(edit1.getText().toString())
			|| TextUtils.isEmpty(edit2.getText().toString())
			|| TextUtils.isEmpty(edit3.getText().toString())
			|| TextUtils.isEmpty(edit4.getText().toString())){
			return;
		}

		// читаем EditText и заполняем переменные числами
		m1 = Float.parseFloat(edit2.getText().toString());
		j1 = Float.parseFloat(edit1.getText().toString());
        j2 = Float.parseFloat(edit3.getText().toString());
        nj = Float.parseFloat(edit4.getText().toString());
		// определяем нажатую кнопку и выполняем соответствующую операцию
		// в oper пишем операцию, потом будем использовать в выводе
		switch (v.getId())
		{
		
		case R.id.btnCount:
			oper = "";
			f = m1*(Math.log10(Math.log10(j1+0.8))-Math.log10(Math.log10(nj+0.8)))/(Math.log10(Math.log10(nj+0.8))-Math.log10(Math.log10(j2+0.8)));
			
			result= (float) f;
			
			break;
		
		}
	

		// формируем строку вывода
		BigDecimal p=new BigDecimal(result);
		tvRez.setText(  oper  + p.setScale(2, RoundingMode.HALF_UP));
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
	edit1.setText("");
	edit2.setText("");
	edit3.setText("");
	edit4.setText("");
	tvRez.setText("");
	break;
	}
	return super.onOptionsItemSelected(item);
	}
}
