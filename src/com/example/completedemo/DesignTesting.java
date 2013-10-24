package com.example.completedemo;

import com.actionbarsherlock.app.SherlockActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class DesignTesting extends SherlockActivity {

	TextView tv1, tv2;
	Button b1,b2;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_design_testing);
	    
		
	    TabHost tabs = (TabHost ) findViewById(R.id.tabhost);
	    tabs.setup();
	    TabHost.TabSpec spec = tabs.newTabSpec("tag1");
	    spec.setContent(R.id.tab1);
	    spec.setIndicator("Tab I");
	    
	    tabs.addTab(spec);
	    
	    spec=tabs.newTabSpec("tag2");
	    spec.setContent(R.id.tab2);
	    spec.setIndicator("Tab II");
	    
	    tabs.addTab(spec);
		    
	    tv1=(TextView) findViewById(R.id.label_tab1);
	//    tv2=(TextView) findViewById(R.id.label_tab2);
	    b1 = (Button) findViewById(R.id.button_tab1);
	  //  b2 = (Button) findViewById(R.id.button_tab2);
	   
	}

	public void b1ButtonPressed(View v){
		Toast.makeText(this, "What did you expect ?", Toast.LENGTH_SHORT)
			 .show();
		
	}
	
}
