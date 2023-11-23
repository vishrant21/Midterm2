package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// MainActivity.java

// Import statements remain the same

public class MainActivity extends AppCompatActivity {
    public static final String API_URL = "https://restcountries.com/v2/all";
    public ArrayList<Country> countryList = new ArrayList<>();
    public CountryAdapter adapter;
    RecyclerView recyclerView;
    public RequestQueue requestQueue; // Move the RequestQueue outside the onCreate method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.r_v_country);


        // Initialize Volley RequestQueue
        requestQueue = Volley.newRequestQueue(this);

        adapter = new CountryAdapter(countryList,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
        // Make a GET request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                API_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle the JSON response
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject countryObject = response.getJSONObject(i);
                                String name = countryObject.getString("name");
                                String capital = countryObject.getString("capital");
                                String flagUrl = countryObject.getJSONObject("flags").getString("png");
                                Log.d("Flag URL", flagUrl); // Add this line to log the flag URL// Fix the flag URL extraction
                                String region = countryObject.getString("region");
                                long population = countryObject.getLong("population");
                                String timezone = countryObject.getJSONArray("timezones").getString(0);
                                String currency = countryObject.getJSONArray("currencies").getJSONObject(0).getString("name");

                                // Create a Country object and add it to your list
                                Country country = new Country(name, capital, flagUrl, region, population, timezone, currency);
                                countryList.add(country);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, ""+country.getCapital(), Toast.LENGTH_SHORT).show();
                            }

                            // Update your RecyclerView adapter here


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });

        // Add the request to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }
}
