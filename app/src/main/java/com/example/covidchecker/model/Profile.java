package com.example.covidchecker.model;

import android.net.Uri;

public class Profile {

    private Uri imageUrl;
    private String email;
    private String username;
    private String fullname;

    public Profile(Uri imageUrl, String email, String username, String fullname) {
        this.imageUrl = imageUrl;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
    }

    public Uri getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Uri imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
