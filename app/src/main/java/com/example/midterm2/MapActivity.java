package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (isGooglePlayServicesAvailable()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this::onMapReady);
        } else {
            // Handle the case where Google Play services are not available.
            // You can show an error message or take appropriate action.
            Toast.makeText(this, "Google Play services are not available.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onMapReady(GoogleMap map) {
        googleMap = map;
        // Check if the map is ready
        if (googleMap != null) {

            Intent intent = getIntent();
            // Add a marker at a specific location and move the camera
            // Kamloops, Canada's coordinates (Commented out for reference)
            LatLng kamloops = new LatLng(intent.getDoubleExtra("latitude",0), intent.getDoubleExtra("longitude",0));
            map.addMarker(new MarkerOptions().position(kamloops).title(""+intent.getStringExtra("Name")));
            //Move the camera to Kamloops and set a zoom level
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(kamloops,12));

            // San Francisco coordinates
//            LatLng location = new LatLng(37.7749, -122.4194);  // Example: San Francisco
//
//            // Add a marker at the specified location with a title
//            googleMap.addMarker(new MarkerOptions().position(location).title("San Francisco"));
//
//            // Move the camera to the specified location with a zoom level of 12
//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
//
//            // Enable zoom controls on the map
//            //googleMap.getUiSettings().setZoomControlsEnabled(true);

        }
    }

    //Change the color of the marker
//    public void onMapReady(GoogleMap map) {
//        googleMap = map; // Assign the map instance when it's ready
//
//        // Check if the map is ready
//        if (googleMap != null) {
//            // Add a custom marker at a specific location and move the camera
//
//            // Define the location using latitude and longitude coordinates
//            LatLng location = new LatLng(37.7749, -122.4194);  // Example: San Francisco
//
//            // Create a custom marker icon with a magenta color
//            BitmapDescriptor customMarkerIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA);
//
//            // Configure the marker options
//            MarkerOptions markerOptions = new MarkerOptions()
//                    .position(location)       // Set the marker's position
//                    .title("San Francisco")  // Set a title for the marker
//                    .icon(customMarkerIcon);  // Set the custom marker icon
//
//            // Add the marker to the Google Map
//            googleMap.addMarker(markerOptions);
//
//            // Move the camera to the specified location with a zoom level of 12
//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
//        }
//    }

    private boolean isGooglePlayServicesAvailable() {
        int availability = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        return availability == ConnectionResult.SUCCESS;
    }
}