package com.example.covidchecker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.covidchecker.model.CountryAdapterModel;
import com.example.covidchecker.model.api.Country;
import com.example.covidchecker.model.room.CountryDatabase;
import com.example.covidchecker.model.room.RoomCountry;
import com.example.covidchecker.model.room.RoomCountryDao;
import com.example.covidchecker.retrofit.RetrofitInstanceLmao;
import com.example.covidchecker.utils.SessionManagementUtil;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private RetrofitInstanceLmao retrofitInstance;
    private ArrayList<CountryAdapterModel> countryAdapterModels = new ArrayList<>();
    private ProgressBar pb;

    //database
    private CountryDatabase database;

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(CountryActivity.this);
        if (!isAllowed){
            Intent intent = new Intent(CountryActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        pb = (ProgressBar) findViewById(R.id.country_pb);
        pb.setVisibility(View.GONE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Global");

        database = CountryDatabase.getInstance(getApplicationContext());

        try {
            getAllCountry();
        } catch (IOException e) {
            //ambil dari database
            e.printStackTrace();
        }

    }

    private void setRecyclerView(){
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.country_recycle_view);
        countryAdapter = new CountryAdapter(countryAdapterModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.country_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.country_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        MenuItem buttonItem = menu.findItem(R.id.country_favorite);
        AppCompatImageButton buttonFavorite = (AppCompatImageButton) buttonItem.getActionView();
        buttonFavorite.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));

        Intent i = new Intent(this, FavoriteActivity.class);
        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                recreate();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (countryAdapter.isNull()){
                    Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), "Data tidak ditemukan", BaseTransientBottomBar.LENGTH_SHORT);
                    snackbar.show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countryAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    public void getAllCountry() throws IOException {
        pb.setVisibility(View.VISIBLE);
        retrofitInstance = new RetrofitInstanceLmao();
        retrofitInstance.getLMAO_API()
                .countries()
                .enqueue(new Callback<ArrayList<Country>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                        ArrayList<Country> result = response.body();
                        if (!result.isEmpty()){
                            for (Country country: result) {
                                countryAdapterModels.add(new CountryAdapterModel(country));
                                //simpan ke database
                                try {
                                    database.roomCountryDao().insertAll(new RoomCountry(country, country.getCountryInfo()));
                                } catch (Exception e){
                                    database.roomCountryDao().update(new RoomCountry(country, country.getCountryInfo()));
                                }
                            }

                            pb.setVisibility(View.GONE);
                            setRecyclerView();
                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Country>> call, Throwable t) {
                        //ambil dari database
                        for (RoomCountry roomCountry : database.roomCountryDao().getAll()){
                            countryAdapterModels.add(new CountryAdapterModel(roomCountry));
                        }
                        pb.setVisibility(View.GONE);
                        Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), "Periksa jaringan anda, menampilkan data sebelumnya", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        setRecyclerView();
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}