package com.example.recyclerview.Controler;

import com.example.recyclerview.Model.RestCalendarResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestCalendarAPI {

    @GET("hebcal/?v=1&cfg=json&maj=on&min=on&mod=on&nx=on&year=now&month=x&ss=on&mf=on&c=on&geo=geoname&geonameid=3448439&m=50&s=on")
    Call<RestCalendarResponse> getListCalendar();
}





