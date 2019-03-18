package com.example.recyclerview.Controler;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.Model.Calendar;
import com.example.recyclerview.Model.Montee;
import com.example.recyclerview.R;


public class MyAdapter_bis extends RecyclerView.Adapter<MyAdapter_bis.ViewHolder> {
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
            line_1 = v.findViewById(R.id.firstLine_bis);
            line_2 = v.findViewById(R.id.secondLine_bis);
            line_3 = v.findViewById(R.id.thirdLine_bis);
            line_4 = v.findViewById(R.id.fourthLine_bis);
            line_5 = v.findViewById(R.id.fifthLine_bis);
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
    public MyAdapter_bis(List<Calendar> myDataset) {
        listData = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter_bis.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View v = inflater.inflate(R.layout.row_bis, parent, false);
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
        Montee selectedMontee = selectedCalendar.getMontee();
        if (selectedMontee != null) {
            final String torah = selectedMontee.getTorah();
            final String un = selectedMontee.getUn();
            final String deux = selectedMontee.getDeux();
            final String trois = selectedMontee.getTrois();
            final String quatre = selectedMontee.getQuatre();
            final String cinq = selectedMontee.getCinq();
            final String six = selectedMontee.getSix();
            final String sept = selectedMontee.getSept();
            final String maftir = selectedMontee.getMaftir();
            final String haftara = selectedMontee.getHaftara();

            holder.line_1.setText("\tLecture complète : "+torah);
            holder.line_2.setText("1er montée : "+un);
            holder.line_3.setText("2ème montée : "+deux);
            holder.line_4.setText("3ème montée : "+trois);
            holder.line_5.setText("4ème montée : "+quatre);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listData.size();
    }

}


