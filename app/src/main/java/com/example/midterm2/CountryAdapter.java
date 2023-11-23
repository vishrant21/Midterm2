package com.example.midterm2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<Country> countryList;
    private Context context;


    GoogleMap googleMap;

    public CountryAdapter(ArrayList<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);

        // Bind data to views
        holder.countryNameTextView.setText(""+country.getName());
        holder.capitalTextView.setText(""+country.getCapital());

        // Load country flag using Glide
        Glide.with(context)
                .load(country.getFlagUrl())
                .into(holder.flagImageView);

        holder.txtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryDetailActivity.class);
                intent.putExtra("name", country.getName());
                intent.putExtra("capital", country.getCapital());
                intent.putExtra("region", country.getRegion());
                intent.putExtra("population", country.getPopulation());
                intent.putExtra("timezone", country.getTimezone());
                intent.putExtra("currency", country.getCurrency());
                intent.putExtra("flagUrl", country.getFlagUrl());
                intent.putExtra("latitude",country.getlatitude());
                intent.putExtra("longitude",country.getLongitude());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



        holder.txtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent2 = new Intent(context, MapActivity.class);
                        intent2.putExtra("latitude",country.getlatitude());
                        intent2.putExtra("longitude",country.getLongitude());
                        intent2.putExtra("Name",country.getName());
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent2);
                    }
            });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void addCountries(List<Country> newCountries) {
        int startIndex = countryList.size();
        countryList.addAll(newCountries);
        notifyItemRangeInserted(startIndex, newCountries.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImageView;
        TextView countryNameTextView;
        TextView capitalTextView,txtInfo,txtLocation;
        LinearLayout lytCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
            lytCountry = itemView.findViewById(R.id.lytCountry);
        }
    }


}

