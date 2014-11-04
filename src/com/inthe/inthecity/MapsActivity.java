package com.inthe.inthecity;

import android.app.Activity;
import android.widget.RelativeLayout.LayoutParams;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.View.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;

//public class MapsActivity extends FragmentActivity {
public class MapsActivity extends android.support.v4.app.FragmentActivity implements OnMarkerClickListener {

	public ImageButton jumpButton;
	public GoogleMap map;
	 
	private Marker valium_marker;
	private Marker clara_marker;
	private Marker dreamExibition_marker;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		setUpPlusButton();
		 
		setUpMapIfNeeded();
		

	}

	private void setUpPlusButton() {

		jumpButton = (ImageButton) findViewById(R.id.imageButton5);
		jumpButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent jumpToBar = new Intent(MapsActivity.this,LegendActivity.class);

				startActivity(jumpToBar);

			}
		});

	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (map == null) {
			// Try to obtain the map from the SupportMapFragment.
			map = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			if (map != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		// map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title(	"Marker"));
		
		map.setMyLocationEnabled(true);
		
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);
		

		// get current location
		Location myLocation = locationManager.getLastKnownLocation(provider);
		
		//get myLat
		double myLat = myLocation.getLatitude();
		double myLon = myLocation.getLongitude();
		
		LatLng latLng = new LatLng(myLat,myLon);
		
		
		//show my current position
		map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		
		//Zoom in 
		map.animateCamera(CameraUpdateFactory.zoomTo(17));
		
		//enter Event locations
		map.addMarker(new MarkerOptions().position(new LatLng(myLat, myLon)).title(
				"Rami is here :)"));
		
		map.setOnMarkerClickListener((OnMarkerClickListener)this);
		//cat and dog


		dreamExibition_marker = map.addMarker(new MarkerOptions().position(new LatLng(32.074924, 34.781616)).title(
				"Dream Exhibition").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_orange)));
		
		clara_marker = map.addMarker(new MarkerOptions().position(new LatLng(32.067269,  34.762695)).title(
				"Clara").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_red)));
		
		valium_marker = map.addMarker(new MarkerOptions().position(new LatLng(32.073132, 34.768324)).title(
				"Valium").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_green)));
		
	
	
		map.addMarker(new MarkerOptions().position(new LatLng(32.054107, 34.779480)).title(
				"The Block").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));
		
		map.addMarker(new MarkerOptions().position(new LatLng(32.053910, 34.766581)).title(
				"Ha Oman 17").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));

		
		map.addMarker(new MarkerOptions().position(new LatLng(32.064017, 34.762216)).title(
				"Sublet").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));
		
		map.addMarker(new MarkerOptions().position(new LatLng(32.074897, 34.781659)).title(
				"Extravaganza").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));
		
		map.addMarker(new MarkerOptions().position(new LatLng(32.068828,  34.782721)).title(
				"Cat and Dog").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));
		
		map.addMarker(new MarkerOptions().position(new LatLng(32.066778,  34.783399)).title(
				"Mojo Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.c_blue)));
				
				
	} 
	
	
	@Override
	public boolean onMarkerClick(final Marker marker) {
		
		//TextView descriptionText;
	//	ImageButton eventLogoButton;
	//	ImageView eventPic;
	    if (marker.equals(valium_marker))
	    {
	    	Intent jump = new Intent(MapsActivity.this,ValiumActivity.class);

			startActivity(jump);  
	    	
	    	/*
	    	//update the correct event data 
	    	Resources res = getResources();
	    	String newEventDesc = res.getString(R.string.valium_desc);	  
	    	descriptionText = (TextView) findViewById(R.id.long_description);
	    	descriptionText.setText(newEventDesc);
	    	
	    	
	    	//update correct event logo
	    	
	    	eventLogoButton = (ImageButton) findViewById(R.id.imageButton2);
	    	eventLogoButton.setImageDrawable(getResources().getDrawable(R.drawable.valium_logo));
	    	
	     	//update correct event picture
	    	
	    	eventPic = (ImageView) findViewById(R.id.imageView1);
	    	eventPic.setImageDrawable(getResources().getDrawable(R.drawable.valium_photo));
	    	
	    	
	    	
	    	jumpToFullScreen();
	    	*/
	    	
	//setContentView(R.layout.viewone);
	    }
	    else if (marker.equals(clara_marker))
	    {
	    //setContentView(R.layout.viewtwo);
	    	
	    	Intent jump = new Intent(MapsActivity.this,ClaraActivity.class);

			startActivity(jump);  
	    } 
	    else if (marker.equals(dreamExibition_marker))
	    {
	    //setContentView(R.layout.viewtwo);
	    	Intent jump = new Intent(MapsActivity.this,DreamActivity.class);

			startActivity(jump);  
	    }
	    return true;
	}

	private void jumpToFullScreen() {
		Intent jump = new Intent(MapsActivity.this,FullscreenActivity.class);

		startActivity(jump);
		
	}

}
