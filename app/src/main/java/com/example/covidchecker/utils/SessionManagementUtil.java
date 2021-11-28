package com.example.covidchecker.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import com.example.covidchecker.model.Profile;
import com.example.covidchecker.model.api.LoginResponse;

import java.util.Calendar;
import java.util.Date;

public class SessionManagementUtil {

    private final static String SESSION_PREFERENCE ="com.example.covidchecker.utils.SessionManagementUtil.SESSION_PREFERENCE";
    private final static String SESSION_EXPIRY_TIME = "com.example.covidchecker.utils.SessionManagementUtil.SESSION_EXPIRY_TIME";
    private final static String SESSION_USER_AVATAR = "com.example.covidchecker.utils.SessionManagementUtil.SESSION_USER_AVATAR";
    private final static String SESSION_USER_EMAIL = "com.example.covidchecker.utils.SessionManagementUtil.SESSION_USER_EMAIL";
    private final static String SESSION_USER_NAME = "com.example.covidchecker.utils.SessionManagementUtil.SESSION_USER_NAME";
    private final static String SESSION_USER_FULL_NAME = "com.example.covidchecker.utils.SessionManagementUtil.SESSION_USER_FULL_NAME";

    public static SessionManagementUtil INSTANCE;

    public static SessionManagementUtil getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SessionManagementUtil();
        }
        return INSTANCE;
    }

    public void startUserSession(Context context, int expiredTime, LoginResponse result){
        Calendar calendar = Calendar.getInstance();
        Date userLoginTime= calendar.getTime();
        calendar.setTime(userLoginTime);
        calendar.add(Calendar.SECOND, expiredTime);
        Date expireTime = calendar.getTime();
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(SESSION_EXPIRY_TIME, expireTime.getTime());
        editor.putString(SESSION_USER_AVATAR, result.getData().getAvatar().toString());
        editor.putString(SESSION_USER_EMAIL, result.getData().getEmail());
        editor.putString(SESSION_USER_NAME, result.getData().getUsername());
        editor.putString(SESSION_USER_FULL_NAME, result.getData().getFullName());
        editor.apply();
    }

    public void endUserSession(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean isSessionActive(Context context){
        Long expiryTime = getExpiredDateFromPreference(context);
        Date expiredTimeDate = new Date(expiryTime);
        Date now = Calendar.getInstance().getTime();
        Log.e("expired", String.valueOf(expiredTimeDate));
        return !now.after(expiredTimeDate);
    }

    private Long getExpiredDateFromPreference(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getLong(SESSION_EXPIRY_TIME, 0);
    }

    public Profile getProfileFromPreference(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        String avatar = sharedPreferences.getString(SESSION_USER_AVATAR, "");
        String email = sharedPreferences.getString(SESSION_USER_EMAIL, "");
        String username = sharedPreferences.getString(SESSION_USER_NAME, "");
        String fullname = sharedPreferences.getString(SESSION_USER_FULL_NAME, "");

        Log.e("data user", avatar + " " + email + " " + username + " " + fullname);

        Profile profile = new Profile(
                Uri.parse(sharedPreferences.getString(SESSION_USER_AVATAR, "")),
                sharedPreferences.getString(SESSION_USER_EMAIL, ""),
                sharedPreferences.getString(SESSION_USER_NAME, ""),
                sharedPreferences.getString(SESSION_USER_FULL_NAME, "")
        );
        return profile;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences;
    }
}
