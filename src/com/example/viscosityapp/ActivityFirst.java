
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
public class ActivityFirst extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	

	EditText etNum1;
	EditText etNum2;
        EditText etNum3;
        EditText etNum4;
	Button btnAdd;
	

	TextView tvResult;

	String oper = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);

		// находим элементы
		etNum1 = (EditText) findViewById(R.id.etNum1);
		etNum2 = (EditText) findViewById(R.id.etNum2);
        etNum3 = (EditText) findViewById(R.id.etNum3);
        etNum4 = (EditText) findViewById(R.id.etNum4);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		tvResult = (TextView) findViewById(R.id.tvResult);
        
		// прописываем обработчик
		btnAdd.setOnClickListener(this);
		

	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		
		double m1 = 0;
		double m2 = 0;
		double j1 = 0;
		double j2 = 0;
		float result = 0;
		double f=0;
        double t=0;
        
		// Проверяем поля на пустоту
		if (TextUtils.isEmpty(etNum1.getText().toString())
			|| TextUtils.isEmpty(etNum2.getText().toString())
			|| TextUtils.isEmpty(etNum3.getText().toString())
			|| TextUtils.isEmpty(etNum4.getText().toString())){
			return;
		}

		// читаем EditText и заполняем переменные числами
		j1 = Float.parseFloat(etNum1.getText().toString());
		j2 = Float.parseFloat(etNum2.getText().toString());
        m1 = Float.parseFloat(etNum3.getText().toString());
        m2 = Float.parseFloat(etNum4.getText().toString());
		// определяем нажатую кнопку и выполняем соответствующую операцию
		// в oper пишем операцию, потом будем использовать в выводе
		switch (v.getId())
		{
		
		case R.id.btnAdd:
			oper = "";
			f = (((m1/(m2+m1)*Math.log10(Math.log10(j1+0.8))))+((m2/(m1+m2)*Math.log10(Math.log10(j2+0.8)))));
			t=(Math.pow(10,Math.pow(10,f)))-0.8;
			result= (float) t;
			
			break;
		
		}
	

		// формируем строку вывода
		BigDecimal p=new BigDecimal(result);
		tvResult.setText(  oper  + p.setScale(2, RoundingMode.HALF_UP));
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
	etNum1.setText("");
	etNum2.setText("");
	etNum3.setText("");
	etNum4.setText("");
	tvResult.setText("");
	break;
	
	}
	return super.onOptionsItemSelected(item);
	}
}
