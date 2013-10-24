package com.example.completedemo;


import java.util.ArrayList;
import java.util.Locale;
import com.actionbarsherlock.app.SherlockListActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class MenuDemo extends SherlockListActivity {


	private String[] items = {"this","list","can","be","edited","through","the","menu"};
	
	ArrayList<String> words= new ArrayList<String>();
	
	MenuItem res_button;
	InitTask it = new InitTask();
	
	public static final int MENU_ADD = Menu.FIRST+1;
	public static final int MENU_RESET = Menu.FIRST+2;
	public static final int MENU_CAP = Menu.FIRST+3;
	public static final int MENU_REMOVE = Menu.FIRST+4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_menu_demo);
		
		
		registerForContextMenu(getListView());
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuItem add_button= menu.add(Menu.NONE,MENU_ADD,Menu.NONE,"Adauga");
		add_button.setIcon(R.drawable.ic_add_icon);
		add_button.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		res_button=menu.add(Menu.NONE,MENU_RESET,Menu.NONE,"Reset");
		res_button.setIcon(R.drawable.ic_reset_button);
		res_button.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		setAdapter();
		
		return super.onCreateOptionsMenu(menu);
	}
	
	

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		switch(item.getItemId()) {
			
			//Adauga cuvant
			case MENU_ADD:{
					add();
					return true;
			}
			
			//Reset lista de cuvinte
			case MENU_RESET:{					
					InitTask t = new InitTask();
					t.execute();
					setAdapter();
					return true;
			}
			
			//touch app icon
			case android.R.id.home : {
				Toast.makeText(this,
								"This is useless",
								Toast.LENGTH_SHORT)
					 .show();
				finish();
				return super.onOptionsItemSelected(item);
			}
		
		
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public boolean onContextItemSelected(android.view.MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = 
				(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		@SuppressWarnings("unchecked")
		ArrayAdapter<String> adapter = (ArrayAdapter<String>)getListAdapter();

		
		switch(item.getItemId()){
			case MENU_CAP:{
				String word = words.get(info.position);
				word.toUpperCase(Locale.getDefault());
				adapter.remove(words.get(info.position));
				adapter.add(word);
				return true;
			}
			
			case MENU_REMOVE:{
				adapter.remove(words.get(info.position));
				return true;
			}
		}
		
	
		return super.onContextItemSelected(item);
	}
	
	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo){
		
		menu.add(Menu.NONE,MENU_CAP,Menu.NONE,"Capitalize");
		menu.add(Menu.NONE,MENU_REMOVE,Menu.NONE,"Remove");

	}
	
	
	
	/*Functie adaugare cuvant nou in lista
	      - show View with entry form
	      - check for duplicates
	      - add word to list
	*/
	private void add(){
		final View addView = getLayoutInflater().inflate(R.layout.add,null);
		
		new AlertDialog.Builder(this)
				.setTitle("Cuvant Nou !")
				.setView(addView)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								@SuppressWarnings("unchecked")
								ArrayAdapter<String> adapter = 
										(ArrayAdapter<String>) getListAdapter();
								EditText title = (EditText) addView.findViewById(R.id.title);
								//Duplicate check
								String entry = title.getText().toString();
						
								if(adapter.getPosition(entry)  == -1){
										adapter.add(entry);
								}else{
									Toast.makeText(MenuDemo.this,
											"Cuvantul exista deja",
											Toast.LENGTH_SHORT)
										 .show();
									
								}
							}
						})
				.setNegativeButton("Cancel",null)		
				.show();
	}
	
	
	
	private class InitTask extends AsyncTask<Void, Void, Void>{


		@Override
		protected void onPreExecute() {
			res_button.setActionView(R.layout.progressbar);
			res_button.expandActionView();
			super.onPreExecute();
		}
		
		@Override
		protected Void doInBackground(Void... params) {			
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			res_button.collapseActionView();
			res_button.setActionView(null);
			super.onPostExecute(result);
		}
		
		
	};
	
	
	
	private void setAdapter (){
		
		words.clear();
		
		for (String s : items){
			words.add(s);
			
		}
		
		setListAdapter(new ArrayAdapter<String>(this,
												android.R.layout.simple_list_item_1,
												words));

	}

}


