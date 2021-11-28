package com.example.covidchecker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covidchecker.model.api.Country;
import com.example.covidchecker.model.room.CountryDatabase;
import com.example.covidchecker.model.room.RoomCountry;
import com.example.covidchecker.model.room.RoomFavorite;
import com.example.covidchecker.retrofit.RetrofitInstanceLmao;
import com.example.covidchecker.utils.Helper;
import com.example.covidchecker.utils.SessionManagementUtil;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryDetailActivity extends AppCompatActivity {

    private Country country;
    private String countryName;
    ImageView detailFlagPicture;
    TextView detailCountryName;
    TextView detailContinentName;
    AppCompatImageButton not_favorite;
    AppCompatImageButton favorite;
    AppCompatImageButton share;
    ArrayList<Fragment> listFragment = new ArrayList<>();

    //database
    private CountryDatabase database;

    ///tab
    TabLayout tabLayout;
    ViewPager2 pager;
    CountryDetailFragmentPagerAdapter adapter;

    private RetrofitInstanceLmao retrofitInstance;

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(CountryDetailActivity.this);
        if (!isAllowed){
            Intent intent = new Intent(CountryDetailActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Detail");

        database = CountryDatabase.getInstance(getApplicationContext());

        detailFlagPicture = findViewById(R.id.detail_flag_picture);
        detailCountryName = findViewById(R.id.detail_country_name);
        detailContinentName = findViewById(R.id.detail_continent_name);

        not_favorite = findViewById(R.id.detail_not_favorite);
        not_favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);

        favorite = findViewById(R.id.detail_favorite);
        favorite.setImageResource(R.drawable.ic_baseline_favorite_24_black);
        favorite.setVisibility(View.GONE);

        share = findViewById(R.id.detail_share);
        share.setImageResource(R.drawable.ic_baseline_share_24);

        Intent intent = getIntent();
        countryName = intent.getStringExtra("country");

        getSpecificCountry(countryName);

        not_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jadikan favorit di database
                if (database.roomFavoriteDao().checkFavorite(countryName) == null){
                    database.roomFavoriteDao().setFavorite(countryName);
                    favorite.setVisibility(View.VISIBLE);
                    not_favorite.setVisibility(View.GONE);
                }
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hapus dari favorit
                database.roomFavoriteDao().deleteFavorite(countryName);
                not_favorite.setVisibility(View.VISIBLE);
                favorite.setVisibility(View.GONE);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toShare ="Data Harian Covid di negara " + country.country + "\n" +
                        "total kasus: "+ country.getCases() + "\n" +
                        "total kematian: "+ country.getDeaths() + "\n" +
                        "kasus aktif: "+ country.getActive() + "\n" +
                        "sembuh hari ini: "+ country.getTodayRecovered() + "\n" +
                        "kematian hari ini: "+ country.getTodayDeaths() + "\n" +
                        "terinfeksi hari ini: "+ country.getTodayCases() + "\n";

                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, toShare);
                startActivity(i);
            }
        });

        tabLayout = findViewById(R.id.sliding_tabs);
        pager = findViewById(R.id.viewpager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new CountryDetailFragmentPagerAdapter(fm, getLifecycle(), listFragment);
        pager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Statistik Covid"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
    private void sendInfoToFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("country_name", country.getCountry());
        bundle.putString("latitude", Double.toString(country.getCountryInfo().getLat()));
        bundle.putString("longitude", Double.toString(country.getCountryInfo().get_long()));
        bundle.putString("country_code", country.getCountryInfo().getIso3());

        InfoFragment infoFragment = new InfoFragment();
        infoFragment.setArguments(bundle);
        listFragment.add(infoFragment);
    }
    private void sendStatisticToFragment(){
        Bundle bundle = new Bundle();
        bundle.putInt("cases", country.getCases());
        bundle.putInt("today_cases", country.getTodayCases());
        bundle.putInt("deaths", country.getDeaths());
        bundle.putInt("today_deaths", country.getTodayDeaths());
        bundle.putInt("recovered", country.getRecovered());
        bundle.putInt("today_recovered", country.getTodayRecovered());

        StatisticFragment statisticFragment = new StatisticFragment();
        statisticFragment.setArguments(bundle);
        listFragment.add(statisticFragment);
    }

    private void getSpecificCountry(String countryName){
        retrofitInstance = new RetrofitInstanceLmao();
        retrofitInstance.getLMAO_API()
                .getSpecificCountry(countryName)
                .enqueue(new Callback<Country>() {
                    @Override
                    public void onResponse(Call<Country> call, Response<Country> response) {
                        Country result;
                        if (response.body() == null){
                            Snackbar.make(getWindow().getDecorView().getRootView(), "Negara tidak ditemukan", Snackbar.LENGTH_SHORT).show();
                        } else {
                            result = response.body();
                            country = new Country(response.body());
                            new RetrieveFlagImage().execute(result.getCountryInfo().getFlag());
                            detailCountryName.setText(result.getCountry());
                            detailContinentName.setText(result.getContinent());

                            //cek udah favorite atau blm
                            RoomFavorite roomFavorite = database.roomFavoriteDao().checkFavorite(countryName);
                            if (roomFavorite == null){
                                not_favorite.setVisibility(View.VISIBLE);
                                favorite.setVisibility(View.GONE);
                            } else if(roomFavorite.country.equalsIgnoreCase(result.getCountry())){
                                favorite.setVisibility(View.VISIBLE);
                                not_favorite.setVisibility(View.GONE);
                            }

                            sendInfoToFragment();
                            sendStatisticToFragment();
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<Country> call, Throwable t) {
                        //ambil dari database
                        RoomCountry roomCountry = database.roomCountryDao().getSpecificCountry(countryName);
                        if (roomCountry!=null){
                            country = new Country(roomCountry);
                            detailCountryName.setText(country.getCountry());
                            detailContinentName.setText(country.getContinent());

                            RoomFavorite roomFavorite = database.roomFavoriteDao().checkFavorite(countryName);
                            if (roomFavorite == null){
                                not_favorite.setVisibility(View.VISIBLE);
                                favorite.setVisibility(View.GONE);
                            } else if(roomFavorite.country.equalsIgnoreCase(country.getCountry())){
                                favorite.setVisibility(View.VISIBLE);
                                not_favorite.setVisibility(View.GONE);
                            }

                            sendInfoToFragment();
                            sendStatisticToFragment();
                            adapter.notifyDataSetChanged();
                        }
                        Snackbar.make(getWindow().getDecorView().getRootView(), "Periksa jaringan anda", Snackbar.LENGTH_SHORT).show();
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

    class RetrieveFlagImage extends AsyncTask<String, Void, Drawable>{

        @Override
        protected Drawable doInBackground(String... strings) {
            try {
                Bitmap x;

                HttpURLConnection connection = (HttpURLConnection) new URL(strings[0]).openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();

                x = BitmapFactory.decodeStream(input);
                return new BitmapDrawable(Resources.getSystem(), x);
            } catch (Exception e){
                return null;
            }
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            detailFlagPicture.setImageDrawable(drawable);
        }
    }

}