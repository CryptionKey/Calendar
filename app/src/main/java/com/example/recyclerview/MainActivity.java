package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.recyclerview.Model.Calendar;
import com.example.recyclerview.Calendar.RestCalendarAPI;
import com.example.recyclerview.Model.RestCalendarResponse;
import com.example.recyclerview.Pokemon.Pokemon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Pokemon> listPokemon;
    private List<Calendar> calendarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recyclerView = (RecyclerView) findViewById(R.id.pokemon_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.calendar_recycler_view);


        //Créer objet Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //Créer objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://pokeapi.co/api/v2/")
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
                showList(calendarList);
            }

            @Override
            public void onFailure(Call<RestCalendarResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });

        //Créer instance
        //RestPokemonAPI restAPI = retrofit.create(RestPokemonAPI.class);
        //Call<RestPokemonResponse> call = restAPI.getListPokemon();
        //call.enqueue(new Callback<RestPokemonResponse>() {
        //    @Override
        //    public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
        //        RestPokemonResponse restPokemonResponse = response.body();
        //        listPokemon = restPokemonResponse.getResults();
        //        showList(listPokemon);
        //    }

         //   @Override
        //    public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
        //        Log.d("ERROR", "Api Error");
        //    }
        //});

    }

    /***public void randomMe(View view){
        //Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        //Get the text view that shows the count
        TextView showCountTextView = findViewById(R.id.textView);

        //Get the value of the text view
        String countString = showCountTextView.getText().toString();

        //Start the new activity
        startActivity(randomIntent);
    }***/

    private void showList(List<Calendar> list) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);
        attachSwipeListener();
    }

    private void attachSwipeListener() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                    target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                //listPokemon.remove(viewHolder.getAdapterPosition());
                calendarList.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}