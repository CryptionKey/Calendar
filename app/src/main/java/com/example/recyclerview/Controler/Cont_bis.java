package com.example.recyclerview.Controler;

import android.util.Log;

import com.example.recyclerview.Model.Calendar;
import com.example.recyclerview.Model.RestCalendarResponse;
import com.example.recyclerview.View.ThirdActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cont_bis {

    private List<Calendar> calendarList;
    private ThirdActivity view;

    public Cont_bis(ThirdActivity view) {
        this.view = view;
    }



    public void onCreate() {

        //Créer objet Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //Créer objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.hebcal.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestCalendarAPI restCalendarAPI = retrofit.create(RestCalendarAPI.class);
        Call<RestCalendarResponse> call = restCalendarAPI.getListCalendar();
        call.enqueue(new Callback<RestCalendarResponse>() {
            @Override
            public void onResponse(Call<RestCalendarResponse> call, Response<RestCalendarResponse> response) {
                RestCalendarResponse restCalendarResponse = response.body();
                calendarList = restCalendarResponse.getItems();
                view.showList(calendarList);
            }

            @Override
            public void onFailure(Call<RestCalendarResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });



    }

}
