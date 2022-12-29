package com.example.CleaningService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CleanerAdapter extends RecyclerView.Adapter<CleanerAdapter.MyViewHolder2> {
    private Context context;
    private ArrayList cleanerName_id, customerName_id, reviewbyCleaner_id;

    public CleanerAdapter(Context context, ArrayList cleanerName_id, ArrayList customerName_id, ArrayList reviewbyCleaner_id) {
        this.context = context;
        this.cleanerName_id = cleanerName_id;
        this.customerName_id = customerName_id;
        this.reviewbyCleaner_id = reviewbyCleaner_id;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cleanerentry,parent,false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.cleanerName_id.setText(String.valueOf(cleanerName_id.get(position)));
        holder.customerName_id.setText(String.valueOf(customerName_id.get(position)));
        holder.reviewbyCleaner_id.setText(String.valueOf(reviewbyCleaner_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return cleanerName_id.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView cleanerName_id, customerName_id, reviewbyCleaner_id;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            cleanerName_id = itemView.findViewById(R.id.txtcleanerName);
            customerName_id = itemView.findViewById(R.id.txtcustomerName);
            reviewbyCleaner_id = itemView.findViewById(R.id.txtreviewbyCleaner);

        }
    }
}
