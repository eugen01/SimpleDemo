package com.example.completedemo;

import android.os.Bundle;
import com.actionbarsherlock.app.SherlockFragmentActivity;


public class SearchActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_search);
	    Bundle b = getIntent().getExtras();
	    
	    SearchFragment sf = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.result);
	    sf.searchURL(b.getString("URL"));
	}
	
	
}
