package com.example.completedemo;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class FragmentDemo extends SherlockFragmentActivity {

	EditText mandatory,simple,excluded;
	ToggleButton safe;
	AttributeFragment af;

	
	/** Called when the activity is first created. */
@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fragment_demo);
		
		mandatory=(EditText)findViewById(R.id.mandatory_string);
		simple=(EditText)findViewById(R.id.simple_string);
		excluded=(EditText)findViewById(R.id.excluded_string);
		safe=(ToggleButton)findViewById(R.id.safe_toggle);
		safe.setChecked(true);		

	}	

	public void startSearch(View v){
				
		String mdtry = new String(mandatory.getText().toString());
		String smpl = new String(simple.getText().toString());
		String excl = new String(excluded.getText().toString());
		String src ;
		
		if (safe.isChecked()==true){
			src= new String("active");
		}else{
			src= new String("images");
		}
		mdtry=escape(mdtry);
		smpl=escape(smpl);
		excl=escape(excl);
		
		StringBuffer url = new StringBuffer("https://www.google.com/search?hl=en&as_q=");
				
		url.append("'"+smpl+"'&");
		
		if(mdtry.length()!=0){url.append("as_epq='"+mdtry+"'&");}
		if(excl.length()!=0){url.append("as_eq='"+excl+"'&");}
		url.append("safe='"+src+"'");
		
		if(this.getResources().getConfiguration().orientation 
							  != Configuration.ORIENTATION_LANDSCAPE){
		
			System.out.println("NOT LANDSCAPE");
			Intent intent = new Intent(this,SearchActivity.class);
			Bundle b = new Bundle();
			b.putString("URL", url.toString());
			intent.putExtras(b);
			startActivity(intent);
			
		}else{
			SearchFragment sf = (SearchFragment)getSupportFragmentManager()
												.findFragmentById(R.id.result);
			sf.searchURL(url.toString());
		}

	}

	
	private String escape(String str){
		
		str.replace(" ","%20");
		//str.replace("\"","%22");
		
		return str;
	}
	
}
