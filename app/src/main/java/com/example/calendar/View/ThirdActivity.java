package com.example.calendar.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.calendar.Controler.Cont_bis;
import com.example.calendar.Controler.MyAdapter_bis;
import com.example.calendar.Model.Calendar;
import com.example.calendar.Model.Leyning;
import com.example.calendar.R;

import java.util.List;


public class ThirdActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Cont_bis controlller;
    private List<Leyning> monteeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = findViewById(R.id.calendar_recycler_view);

        controlller = new Cont_bis(this);
        controlller.onCreate();
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateSwipeRight(this);
    }


    public void showList(List<Calendar> list) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter_bis(list);
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
                monteeList.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}