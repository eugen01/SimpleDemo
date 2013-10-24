package com.example.completedemo;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.actionbarsherlock.view.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class FormDemo extends Activity {

	GridView gv;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_form_demo);
	    
	    gv = (GridView) findViewById(R.id.gridview);
	    gv.setAdapter(new ImageAdapter(this));
	    
	    gv.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(FormDemo.this, "" + position,Toast.LENGTH_SHORT).show();
	        }

		
	    });
	}


	public boolean onContextItemSelected(MenuItem item){
			
		return super.onContextItemSelected((android.view.MenuItem) item);
	}

	
}


class ImageAdapter extends BaseAdapter{

	private Context myContext;
	
	
	public ImageAdapter (Context c){
		myContext = c;
		
	}
		
	@Override
	public int getCount() {
		
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView iv;
			if(convertView == null){
				iv= new ImageView(myContext);
				iv.setLayoutParams(new GridView.LayoutParams(85,85));
				iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
				iv.setPadding(8,8,8,8);				
			}else{
				iv = (ImageView) convertView;				
			}
		
		iv.setImageResource(mThumbIds[position]);
		return iv;
	}
	
	private Integer[] mThumbIds = {
			 R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7,
	            R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7,
	            R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7
				};	
	
	
	
}