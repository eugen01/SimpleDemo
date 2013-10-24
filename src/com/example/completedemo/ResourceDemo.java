package com.example.completedemo;


import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class ResourceDemo extends SherlockActivity {

	public static final int SELECTED= 1;
	public static final int NOT_SELECTED = 0; 
	
	
	int selectionState;
	int selectedPos;
	int newSelection;
	
	int pairsFound;
	ArrayList<ImageButton> buttons =new ArrayList<ImageButton>();
	ArrayList<ImageButton> clickedButtons = new ArrayList<ImageButton>();
	int[] hiddenImages  = new int[16];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		setContentView(R.layout.activity_resource_demo);
		
		initGame();
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		for(int i=0;i<16;i++){
			ImageButton b;
			b = (ImageButton) findViewById(R.id.button1+i);
			b.setImageResource(R.drawable.questionmark);
			b.setClickable(true);

			b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				((ImageButton) v).setImageResource(hiddenImages[buttons.indexOf((ImageButton)v)]);
				
				
				switch(selectionState){
					case SELECTED : {
							
						if(hiddenImages[buttons.indexOf((ImageButton)v)] ==
								hiddenImages[selectedPos]){
							
							selectionState = NOT_SELECTED;
							((ImageButton) v).setClickable(false);
							buttons.get(selectedPos).setClickable(false);
							pairsFound++;
							clickedButtons.add((ImageButton)v);
							clickedButtons.add(buttons.get(selectedPos));
							v.setBackgroundResource(android.R.color.holo_blue_dark);
							buttons.get(selectedPos).setBackgroundResource(android.R.color.holo_blue_dark);
							
						}else{
							selectionState = NOT_SELECTED;
							newSelection = buttons.indexOf((ImageButton)v);
							
							TimeWaste tw = new TimeWaste();
							tw.execute();
							
						}
						
					}break;
					
					case NOT_SELECTED:{
							
							selectionState = SELECTED;
							selectedPos = buttons.indexOf((ImageButton)v);
							v.setClickable(false);
					}break;
				
				}
				
				checkWin();
				
			}
			
			
		});
			buttons.add(b);
		}
		
		super.onCreate(savedInstanceState);
	}
	
	private void initGame(){

		initImageID();		
		selectionState = NOT_SELECTED;
		pairsFound = 0;
	}
	
	private void checkWin(){
		
		if(pairsFound == 8){
			Toast.makeText(this, "Congratulations !! \n You WON !", Toast.LENGTH_SHORT)
				 .show();
		}
		
	}
	
	private void disableButtons(){
		for(ImageButton b:buttons){
			b.setClickable(false);
		}
	}
	
	private void enableButtons(){
		for(ImageButton b:buttons){
			if(!clickedButtons.contains(b))
				b.setClickable(true);
		}
	}
	
	
	private void initImageID(){
		
		for(int i=0;i<16;i++){
			hiddenImages[i]=0;
		}
		
		for(int i = R.drawable.icon1;i<=R.drawable.icon8;i++){
			
			
			for(int j = 0 ;j<2;j++){
				int position = (int)(Math.random() * 16 );
			
				while(hiddenImages[position]!=0){
					position = (int)(Math.random() * 16 );
					
				}
				hiddenImages[position] = i;				
			}
		}
	
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch(item.getItemId()){
		
			case android.R.id.home : {
				recreate();
				}break; 
		
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	private class TimeWaste extends AsyncTask<Void, Void, Void>{

		@Override
		protected void onPreExecute() {
			disableButtons();
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
			
			buttons.get(selectedPos).setImageResource(R.drawable.questionmark);
			buttons.get(newSelection).setImageResource(R.drawable.questionmark);
			enableButtons();
		}
		
		
	};


}
