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
import android.widget.ProgressBar;

import com.example.covidchecker.model.CountryAdapterModel;
import com.example.covidchecker.model.room.CountryDatabase;
import com.example.covidchecker.model.room.RoomCountry;
import com.example.covidchecker.model.room.RoomFavorite;
import com.example.covidchecker.utils.SessionManagementUtil;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private ArrayList<CountryAdapterModel> countryAdapterModels = new ArrayList<>();
    //database
    private CountryDatabase database;
    ProgressBar pb;

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(FavoriteActivity.this);
        if (!isAllowed){
            Intent intent = new Intent(FavoriteActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        pb = (ProgressBar) findViewById(R.id.favorite_pb);
        pb.setVisibility(View.GONE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Disukai");

        database = CountryDatabase.getInstance(getApplicationContext());

        getAllData();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorite_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.favorite_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

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

    private void setRecyclerView(){
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.favorite_recycle_view);
        countryAdapter = new CountryAdapter(countryAdapterModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

    private void getAllData(){
        List<RoomCountry> roomCountries = database.roomCountryDao().getAll();
        List<RoomFavorite> roomFavorites = database.roomFavoriteDao().getAll();

        List<RoomCountry> favorited = new ArrayList<>();
        for (RoomFavorite favorites: roomFavorites) {
            for (RoomCountry roomCountry : roomCountries) {
                if (favorites.country.equalsIgnoreCase(roomCountry.country)){
                    favorited.add(roomCountry);
                }
            }
        }

        for (RoomCountry favor :favorited) {
            countryAdapterModels.add(new CountryAdapterModel(favor));
        }
        pb.setVisibility(View.GONE);
        if (countryAdapterModels.isEmpty()){
            Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), "Periksa jaringan anda, menampilkan data sebelumnya", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
        setRecyclerView();

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