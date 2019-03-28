package com.example.calendar.Controler;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calendar.Model.Calendar;
import com.example.calendar.Model.Leyning;
import com.example.calendar.R;


public class MyAdapter_bis extends RecyclerView.Adapter<MyAdapter_bis.ViewHolder> {
    private List<Calendar> listData;

    class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView line_1;
        TextView line_2;
        TextView line_3;
        TextView line_4;
        TextView line_5;
        TextView line_6;
        TextView line_7;
        TextView line_8;
        TextView line_9;
        TextView line_10;
        ImageView image;

        View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            line_1 = v.findViewById(R.id.firstLine_bis);
            line_2 = v.findViewById(R.id.secondLine_bis);
            line_3 = v.findViewById(R.id.thirdLine_bis);
            line_4 = v.findViewById(R.id.fourthLine_bis);
            line_5 = v.findViewById(R.id.fifthLine_bis);
            line_6 = v.findViewById(R.id.sixthLine_bis);
            line_7 = v.findViewById(R.id.seventhLine_bis);
            line_8 = v.findViewById(R.id.eightLine_bis);
            line_9 = v.findViewById(R.id.ninthLine_bis);
            line_10 = v.findViewById(R.id.tenthLine_bis);
            image = v.findViewById(R.id.vignette_bis);
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
        Leyning selectedLeyning = selectedCalendar.getLeyning();
        if (selectedLeyning!= null) {
            final String torah = selectedLeyning.getTorah();
            final String un = selectedLeyning.getUn();
            final String deux = selectedLeyning.getDeux();
            final String trois = selectedLeyning.getTrois();
            final String quatre = selectedLeyning.getQuatre();
            final String cinq = selectedLeyning.getCinq();
            final String six = selectedLeyning.getSix();
            final String sept = selectedLeyning.getSept();
            final String maftir = selectedLeyning.getMaftir();
            final String haftarah = selectedLeyning.getHaftarah();

            holder.line_1.setText(String.format("\tLecture complète : %s", torah));
            holder.line_2.setText(String.format("1er montée : %s", un));
            holder.line_3.setText(String.format("2ème montée : %s", deux));
            holder.line_4.setText(String.format("3ème montée : %s", trois));
            holder.line_5.setText(String.format("4ème montée : %s", quatre));
            holder.line_6.setText(String.format("5ème montée : %s", cinq));
            holder.line_7.setText(String.format("6ème montée : %s",six));
            holder.line_8.setText(String.format("7ème montée : %s",sept));
            holder.line_9.setText(String.format("Maftir : %s",maftir));
            holder.line_10.setText(String.format("Haftara : %s",haftarah));
        }
        else{
           // holder.image.setVisibility(View.GONE);
            holder.line_1.setText("Pas de lecture prévue");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listData.size();
    }

}


