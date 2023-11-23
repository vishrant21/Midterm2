package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


public class CountryDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        ImageView flagDetailImageView = findViewById(R.id.flagDetailImageView);
        TextView countryNameDetailTextView = findViewById(R.id.countryNameDetailTextView);
        TextView capitalDetailTextView = findViewById(R.id.capitalDetailTextView);
        TextView regionDetailTextView = findViewById(R.id.regionDetailTextView);
        TextView populationDetailTextView = findViewById(R.id.populationDetailTextView);
        TextView timezoneDetailTextView = findViewById(R.id.timezoneDetailTextView);
        TextView currencyDetailTextView = findViewById(R.id.currencyDetailTextView);

        Intent  intent = getIntent();
        String name = intent.getStringExtra("name");
        String capital = intent.getStringExtra("capital");
        String region = intent.getStringExtra("region");
        long population = intent.getLongExtra("population", 0);
        String timezone = intent.getStringExtra("timezone");
        String currency = intent.getStringExtra("currency");
        String flagUrl = intent.getStringExtra("flagUrl");


        countryNameDetailTextView.setText("Country Name: " + name);
        capitalDetailTextView.setText("Country Capital: " + capital);
        regionDetailTextView.setText("Region: " + region);
        populationDetailTextView.setText("Population: " + population);
        timezoneDetailTextView.setText("Timezone: " + timezone);
        currencyDetailTextView.setText("Currency: " + currency);

// Load country flag using Glide
        Glide.with(this)
                .load(flagUrl)
                .into(flagDetailImageView);

    }
}