package com.example.CleaningService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.CleaningService.R;
import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder1> {
    private Context context;
    private ArrayList customerName_id, cleanerName_id, reviewbyCustomer_id;

    public CustomerAdapter(Context context, ArrayList customerName_id, ArrayList cleanerName_id, ArrayList reviewbyCustomer_id) {
        this.context = context;
        this.customerName_id = customerName_id;
        this.cleanerName_id = cleanerName_id;
        this.reviewbyCustomer_id = reviewbyCustomer_id;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customerentry,parent,false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        holder.customerName_id.setText(String.valueOf(customerName_id.get(position)));
        holder.cleanerName_id.setText(String.valueOf(cleanerName_id.get(position)));
        holder.reviewbyCustomer_id.setText(String.valueOf(reviewbyCustomer_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return customerName_id.size();
    }
    public class MyViewHolder1 extends RecyclerView.ViewHolder{
    TextView customerName_id, cleanerName_id, reviewbyCustomer_id;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            customerName_id = itemView.findViewById(R.id.customerName);
            cleanerName_id = itemView.findViewById(R.id.cleanerName);
            reviewbyCustomer_id = itemView.findViewById(R.id.reviewbyCustomer);
        }
    }
}
