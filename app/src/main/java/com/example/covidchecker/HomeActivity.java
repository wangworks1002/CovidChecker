package com.example.covidchecker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.room.Transaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.covidchecker.model.api.AllResponse;
import com.example.covidchecker.model.room.CountryDatabase;
import com.example.covidchecker.model.room.RoomGlobal;
import com.example.covidchecker.retrofit.RetrofitInstanceLmao;
import com.example.covidchecker.utils.SessionManagementUtil;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RetrofitInstanceLmao retrofitInstance;

    //database
    private CountryDatabase database;

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(HomeActivity.this);
        if (!isAllowed){
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn_logout = (Button) findViewById(R.id.logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManagementUtil.getInstance().endUserSession(HomeActivity.this);
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        Button btn_move_country = (Button) findViewById(R.id.home_move_country);
        btn_move_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, CountryActivity.class);
                startActivity(i);
            }
        });

        database = CountryDatabase.getInstance(getApplicationContext());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Covid Apps");
        actionBar.setDisplayHomeAsUpEnabled(true);

        getAllCases();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        MenuItem buttonItem = menu.findItem(R.id.home_profile);
        ImageButton buttonProfile = (ImageButton) buttonItem.getActionView();
        buttonProfile.setBackground(getResources().getDrawable(R.drawable.ic_baseline_account_circle_28));

        Intent i = new Intent(this, ProfileActivity.class);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                recreate();
            }
        });

        return super.onPrepareOptionsMenu(menu);
    }

    private void getAllCases(){
        retrofitInstance = new RetrofitInstanceLmao();
        retrofitInstance.getLMAO_API()
                .allCases()
                .enqueue(new Callback<AllResponse>() {

                    TextView confirmed = (TextView) findViewById(R.id.home_confirmed);
                    TextView active = (TextView) findViewById(R.id.home_active);
                    TextView recovered = (TextView) findViewById(R.id.home_recovered);
                    TextView death = (TextView) findViewById(R.id.home_death);

                    @Override
                    public void onResponse(Call<AllResponse> call, Response<AllResponse> response) {
                        AllResponse result = response.body();
                        //isi datanya
                        confirmed.setText(result.getCases()==null? "0" : String.format("%,d",result.getCases()));
                        active.setText(result.getActive()==null? "0" : String.format("%,d",result.getActive()));
                        recovered.setText(result.getRecovered()==null? "0" : String.format("%,d",result.getRecovered()));
                        death.setText(result.getDeaths()==null? "0" : String.format("%,d",result.getDeaths()));

                        deleteAndInsert(result);
                    }

                    @Override
                    public void onFailure(Call<AllResponse> call, Throwable t) {
                        //tambah logika ambil dari database data terakhir kali diambil
                        RoomGlobal allCases = database.roomGlobalDao().getAllCases();
                        if (allCases != null){
                            confirmed.setText(allCases.getCases()==null? "0" : String.format("%,d", allCases.getCases()));
                            active.setText(allCases.getActive()==null? "0" : String.format("%,d", allCases.getActive()));
                            recovered.setText(allCases.getCases()==null? "0" : String.format("%,d", allCases.getRecovered()));
                            death.setText(allCases.getActive()==null? "0" : String.format("%,d", allCases.getDeaths()));
                        }

                        Snackbar.make(getWindow().getDecorView().getRootView(), "Anda tidak terhubung ke internet", Snackbar.LENGTH_SHORT).show();
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

    @Transaction
    void deleteAndInsert(AllResponse result){
        database.roomGlobalDao().deleteAll();
        database.roomGlobalDao().insertAll(new RoomGlobal(result.getCases(), result.getActive(), result.getRecovered(), result.getDeaths()));
    }
}