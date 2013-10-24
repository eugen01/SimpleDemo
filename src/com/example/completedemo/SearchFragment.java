package com.example.completedemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class SearchFragment extends SherlockFragment {
	
	WebView wv;
	
	public static final int MENU_REFRESH  = Menu.FIRST+1;
	public static final int MENU_BACK = Menu.FIRST+2;
	public static final int MENU_FORWARD = Menu.FIRST+3;
	
	@Override
	public void onActivityCreated(android.os.Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
			
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.search_fragment, container, false);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		MenuItem mi1 = menu.add(Menu.NONE,MENU_REFRESH,Menu.NONE,"Refresh");
		mi1.setIcon(R.drawable.navigation_refresh);
		mi1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		MenuItem mi2 = menu.add(Menu.NONE,MENU_BACK,Menu.NONE,"Back");
		mi2.setIcon(R.drawable.navigation_previous_item);
		mi2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		MenuItem mi3 = menu.add(Menu.NONE,MENU_FORWARD,Menu.NONE,"Forward");
		mi3.setIcon(R.drawable.navigation_next_item);
		mi3.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
			case MENU_BACK 	  : {
				wv.goBack();
			} break;
			case MENU_FORWARD : {
				wv.goForward();
			} break;
			case MENU_REFRESH : {
				wv.reload();
			} break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void searchURL(String url){
		
		wv = (WebView) getView().findViewById(R.id.browser);
		wv.setWebViewClient(new MyWebViewClient());
		wv.loadUrl(url);
		
		setHasOptionsMenu(true);
		
	}
	
}
