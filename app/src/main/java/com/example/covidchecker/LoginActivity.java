package com.example.covidchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.covidchecker.model.api.LoginResponse;
import com.example.covidchecker.retrofit.RetrofitInstanceOne;
import com.example.covidchecker.utils.SessionManagementUtil;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private RetrofitInstanceOne retrofitInstance;
    private Intent i;
    private ProgressBar pb;

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(this);
        if (isAllowed){

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        i = new Intent(this, HomeActivity.class);

        pb = (ProgressBar) findViewById(R.id.login_pb);
        pb.setVisibility(View.GONE);

        EditText edit_username = findViewById(R.id.edit_username);
        EditText edit_password = findViewById(R.id.edit_password);

        Button btn_login = (Button) findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(edit_username.getText().toString(), edit_password.getText().toString());
            }
        });
    }

    private void login(String email, String password){
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Snackbar.make(getWindow().getDecorView().getRootView(), "Username atau Password tidak boleh kosong", Snackbar.LENGTH_SHORT).show();
        }
        pb.setVisibility(View.VISIBLE);
        retrofitInstance = new RetrofitInstanceOne();
        retrofitInstance.getONE_API()
                .login(email, password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse result;
                        if (response.body() == null){
                            Snackbar.make(getWindow().getDecorView().getRootView(), "Username atau Password salah", Snackbar.LENGTH_SHORT).show();
                        } else {
                            result = response.body();
                            if (result.getStatus()){
                                //login berhasil
                                saveSession(result);
                                pb.setVisibility(View.GONE);
//                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        pb.setVisibility(View.GONE);
                        Snackbar.make(getWindow().getDecorView().getRootView(), "Silahkan coba lagi nanti", Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    public void saveSession(LoginResponse result){
        SessionManagementUtil.getInstance().startUserSession(this, 300, result);
    }

    public void clearSession(){
        SessionManagementUtil.getInstance().endUserSession(this);
    }


}