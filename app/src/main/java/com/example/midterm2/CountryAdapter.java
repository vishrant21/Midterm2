package com.example.midterm2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<Country> countryList;
    private Context context;

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

        holder.lytCountry.setOnClickListener(new View.OnClickListener() {
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
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
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
        TextView capitalTextView;
        LinearLayout lytCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
            lytCountry = itemView.findViewById(R.id.lytCountry);
        }
    }
}

