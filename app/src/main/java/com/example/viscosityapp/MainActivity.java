package com.example.viscosityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnClickListener {

	final int MENU_QUIT_ID = 1;
	
	ImageButton imgBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgBtn = (ImageButton) findViewById(R.id.imgBtn);
		imgBtn.setOnClickListener(this);
		
	}
@Override
public void onClick(View v){
	switch(v.getId()){
	case R.id.imgBtn:
		Intent intent = new Intent(this,ActivityStart.class);
		startActivity(intent);
		break;
		default:
			break;
	}
}
// создание меню
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// TODO Auto-generated method stub

menu.add(0, MENU_QUIT_ID, 0, "Выйти");
return super.onCreateOptionsMenu(menu);
}

// обработка нажатий на пункты меню
@Override
public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
switch (item.getItemId()) {

case MENU_QUIT_ID:
// выход из приложения
finish();
break;
}
return super.onOptionsItemSelected(item);
}
}
	
