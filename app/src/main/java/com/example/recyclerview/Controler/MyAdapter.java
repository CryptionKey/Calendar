package com.example.recyclerview.Controler;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.Model.Calendar;
import com.example.recyclerview.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Calendar> listData;

    class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView line_1;
        TextView line_2;
        TextView line_3;
        TextView line_4;
        TextView line_5;

        View layout;

     public ViewHolder(View v) {
            super(v);
            layout = v;
            line_1 = (TextView) v.findViewById(R.id.firstLine);
            line_2 = (TextView) v.findViewById(R.id.secondLine);
            line_3 = (TextView) v.findViewById(R.id.thirdLine);
            line_4 = (TextView) v.findViewById(R.id.fourthLine);
            line_5 = (TextView) v.findViewById(R.id.fifthLine);
     }
    }

    public void add(int position, Calendar item) {
        listData.add(position, item);
        notifyItemInserted(position);
    }

    private void remove(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Calendar> myDataset) {
        listData = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Calendar selectedCalendar = listData.get(position);
        final String category = selectedCalendar.getCategory();
        final String title = selectedCalendar.getTitle();
        final String hebrew = selectedCalendar.getHebrew();
        final String memo = selectedCalendar.getMemo();
        final String date = selectedCalendar.getDate();

        holder.line_1.setText(category);
        holder.line_2.setText(hebrew);
        holder.line_3.setText(title);
        holder.line_4.setText(date);
        holder.line_5.setText(memo);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listData.size();
    }

}


