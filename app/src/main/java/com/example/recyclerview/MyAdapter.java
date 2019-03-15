package com.example.recyclerview;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.Model.Calendar;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Calendar> listData;

    class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader =  v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
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
    MyAdapter(List<Calendar> myDataset) {
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

        holder.txtHeader.setText(category);
        holder.txtFooter.setText(hebrew + "\n" + title + "\n" + date + "\n" + memo);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listData.size();
    }

}


