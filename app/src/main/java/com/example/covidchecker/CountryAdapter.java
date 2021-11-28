package com.example.covidchecker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidchecker.model.CountryAdapterModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {

    private ArrayList<CountryAdapterModel> countries = new ArrayList<>();
    private ArrayList<CountryAdapterModel> countriesListFull = new ArrayList<>();
    private boolean isNull = false;

    public CountryAdapter(ArrayList<CountryAdapterModel> countries) {
        this.countries = countries;
        this.countriesListFull = new ArrayList<>(countries);
    }

    public boolean isNull() {
        return isNull;
    }

    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
//            constraint = constraint.length()==0? null:constraint;
            ArrayList<CountryAdapterModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(countriesListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (CountryAdapterModel countryAdapterModel: countriesListFull) {
                    if (countryAdapterModel.getCountry().toLowerCase().contains(filterPattern)){
                        filteredList.add(countryAdapterModel);
                    }
                }
            }
            if (filteredList.isEmpty()){
                isNull = true;
            } else {
                isNull = false;
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countries.clear();
            countries.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.country_name.setText(countries.get(position).getCountry());
        holder.country_continent.setText(countries.get(position).getContinent());
    }

    @Override
    public int getItemCount() {
        return countries != null ? countries.size() : 0;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        private TextView country_name;
        private TextView country_continent;
        private AppCompatImageButton btn_check_detail;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            country_name = (TextView) itemView.findViewById(R.id.country_name);
            country_continent = (TextView) itemView.findViewById(R.id.country_continent);
            btn_check_detail = (AppCompatImageButton) itemView.findViewById(R.id.btn_check_detail);
            btn_check_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, CountryDetailActivity.class);
                    i.putExtra("country", country_name.getText().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(i);

                }
            });
        }
    }
}
