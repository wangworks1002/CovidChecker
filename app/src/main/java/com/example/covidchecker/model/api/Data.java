package com.example.covidchecker.model.api;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Data {
    @SerializedName("id")
    @Expose
    @Nullable
    public String id;
    @SerializedName("email")
    @Expose
    @Nullable
    public String email;
    @SerializedName("oauth_uid")
    @Expose
    @Nullable
    public Object oauthUid;
    @SerializedName("oauth_provider")
    @Expose
    @Nullable
    public Object oauthProvider;
    @SerializedName("username")
    @Expose
    @Nullable
    public String username;
    @SerializedName("full_name")
    @Expose
    @Nullable
    public String fullName;
    @SerializedName("avatar")
    @Expose
    @Nullable
    public String avatar;
    @SerializedName("banned")
    @Expose
    @Nullable
    public String banned;
    @SerializedName("last_login")
    @Expose
    @Nullable
    public String lastLogin;
    @SerializedName("last_activity")
    @Expose
    @Nullable
    public String lastActivity;
    @SerializedName("date_created")
    @Expose
    @Nullable
    public String dateCreated;
    @SerializedName("forgot_exp")
    @Expose
    @Nullable
    public Object forgotExp;
    @SerializedName("remember_time")
    @Expose
    @Nullable
    public Object rememberTime;
    @SerializedName("remember_exp")
    @Expose
    @Nullable
    public Object rememberExp;
    @SerializedName("verification_code")
    @Expose
    @Nullable
    public Object verificationCode;
    @SerializedName("top_secret")
    @Expose
    @Nullable
    public Object topSecret;
    @SerializedName("ip_address")
    @Expose
    @Nullable
    public String ipAddress;
    @SerializedName("company_id")
    @Expose
    @Nullable
    public String companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getOauthUid() {
        return oauthUid;
    }

    public void setOauthUid(Object oauthUid) {
        this.oauthUid = oauthUid;
    }

    public Object getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(Object oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Object getForgotExp() {
        return forgotExp;
    }

    public void setForgotExp(Object forgotExp) {
        this.forgotExp = forgotExp;
    }

    public Object getRememberTime() {
        return rememberTime;
    }

    public void setRememberTime(Object rememberTime) {
        this.rememberTime = rememberTime;
    }

    public Object getRememberExp() {
        return rememberExp;
    }

    public void setRememberExp(Object rememberExp) {
        this.rememberExp = rememberExp;
    }

    public Object getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Object verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Object getTopSecret() {
        return topSecret;
    }

    public void setTopSecret(Object topSecret) {
        this.topSecret = topSecret;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
