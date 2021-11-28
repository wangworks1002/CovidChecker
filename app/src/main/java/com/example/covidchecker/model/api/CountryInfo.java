package com.example.covidchecker.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CountryInfo {

    @SerializedName("_id")
    @Expose
    public Integer id;
    @SerializedName("iso2")
    @Expose
    public String iso2;
    @SerializedName("iso3")
    @Expose
    public String iso3;
    @SerializedName("lat")
    @Expose
    public Double lat;
    @SerializedName("long")
    @Expose
    public Double _long;
    @SerializedName("flag")
    @Expose
    public String flag;

    public CountryInfo(Integer id, String iso2, String iso3, Double lat, Double _long, String flag) {
        this.id = id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double get_long() {
        return _long;
    }

    public void set_long(Double _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
