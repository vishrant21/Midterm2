package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;


public class CountryDetailActivity extends AppCompatActivity {

    GoogleMap googleMap;
    double latitude,longitude;
    String name;
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        ImageView flagDetailImageView = findViewById(R.id.flagDetailImageView);
        TextView latitudeDetaailTextView = findViewById(R.id.latitudeDetailTextView);
        TextView longitudeDetailTextView = findViewById(R.id.longitudeDetailTextView);
        TextView countryNameDetailTextView = findViewById(R.id.countryNameDetailTextView);
        TextView capitalDetailTextView = findViewById(R.id.capitalDetailTextView);
        TextView regionDetailTextView = findViewById(R.id.regionDetailTextView);
        TextView populationDetailTextView = findViewById(R.id.populationDetailTextView);
        TextView timezoneDetailTextView = findViewById(R.id.timezoneDetailTextView);
        TextView currencyDetailTextView = findViewById(R.id.currencyDetailTextView);

        Intent  intent = getIntent();
        name = intent.getStringExtra("name");
        String capital = intent.getStringExtra("capital");
        String region = intent.getStringExtra("region");
        long population = intent.getLongExtra("population", 0);
        String timezone = intent.getStringExtra("timezone");
        String currency = intent.getStringExtra("currency");
        String flagUrl = intent.getStringExtra("flagUrl");
        latitude = intent.getDoubleExtra("latitude",0);
        longitude = intent.getDoubleExtra("longitude",0);

        countryNameDetailTextView.setText("Country Name: " + name);
        capitalDetailTextView.setText("Country Capital: " + capital);
        regionDetailTextView.setText("Region: " + region);
        populationDetailTextView.setText("Population: " + population);
        timezoneDetailTextView.setText("Timezone: " + timezone);
        currencyDetailTextView.setText("Currency: " + currency);
        latitudeDetaailTextView.setText("Latitude: "+latitude);
        longitudeDetailTextView.setText("Longitude: "+longitude);



// Load country flag using Glide
        Glide.with(this)
                .load(flagUrl)
                .into(flagDetailImageView);

    }

}