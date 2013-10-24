package com.example.completedemo;


import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.content.Intent;
import com.actionbarsherlock.view.Menu;
import android.view.View;
import android.widget.Button;

public class DemoSelector extends SherlockActivity {
	
	public static final int NR_BUTOANE = 6;
	
	
	Button[] buttons=new Button[NR_BUTOANE];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_selector);

		
		buttons[0] = (Button) findViewById(R.id.buton_d1);
		buttons[1] = (Button) findViewById(R.id.buton_d2);
	    buttons[2] = (Button) findViewById(R.id.buton_d3);
	    buttons[3] = (Button) findViewById(R.id.buton_d4);
	    buttons[4] = (Button) findViewById(R.id.buton_d5);
	    buttons[5] = (Button) findViewById(R.id.buton_d6);
	}

	
	public void startDemo1(View v){
		startActivity(new Intent(this,MenuDemo.class));
	}
	public void startDemo2(View v){
		startActivity(new Intent(this,FormDemo.class));
	}
	
	public void startDemo3(View v){
		startActivity(new Intent(this,ResourceDemo.class));
	}
	
	public void startDemo4(View v){
		startActivity(new Intent(this,FragmentDemo.class));
		
	}
	public void startDemo5(View v){
		startActivity(new Intent(this,DesignTesting.class));
	}
	public void startDemo6(View v){
		//TODO start Action bar demo
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.demo_selector, menu);
		return true;
	}

}
