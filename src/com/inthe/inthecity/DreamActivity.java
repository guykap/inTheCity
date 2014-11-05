package com.inthe.inthecity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class DreamActivity extends ActionBarActivity {

	ImageButton LogoButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dream);
		addListenerOnButton();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dream, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	 public void addListenerOnButton() {
	   	 
	    	LogoButton = (ImageButton)findViewById(R.id.imageButton2);
	    	LogoButton.setOnClickListener(new OnClickListener() {
	    		 
				@Override
				public void onClick(View arg0) {
	 
				  Intent browserIntent = 
	                            new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.telavivme.com/NightLife/places/Dream_Exhibition"));
				    startActivity(browserIntent);
	 
				}
	 
			});
	    }
	
}
