package com.example.covidchecker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covidchecker.model.Profile;
import com.example.covidchecker.utils.Helper;
import com.example.covidchecker.utils.SessionManagementUtil;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {

    @Override
    public void onResume() {
        super.onResume();
        boolean isAllowed = SessionManagementUtil.getInstance().isSessionActive(ProfileActivity.this);
        if (!isAllowed){
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Profile userData = SessionManagementUtil.getInstance().getProfileFromPreference(ProfileActivity.this);

        ImageView image = findViewById(R.id.profile_avatar);
        TextView email = findViewById(R.id.profile_email);
        TextView username = findViewById(R.id.profile_username);
        TextView fullname = findViewById(R.id.profile_fullname);

        Drawable pic = null;
        try {
            InputStream is = getContentResolver().openInputStream(userData.getImageUrl());
            pic = Drawable.createFromStream(is,userData.getImageUrl().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (pic != null) {
            image.setImageDrawable(pic);
        }
        email.setText(userData.getEmail());
        username.setText(userData.getUsername());
        fullname.setText(userData.getFullname());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Profile");
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