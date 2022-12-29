package com.example.CleaningService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CleaningService.R;

import java.util.ArrayList;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private Context context;


    private Button btnGetJob;
        private ArrayList cusName_id, jobType_id, conNumber_id, jobDate_id, jobTime_id, noRooms_id, noBrooms_id, floorType_id;

    public MyAdapter(Context context, ArrayList cusName_id, ArrayList jobType_id, ArrayList conNumber_id, ArrayList jobDate_id, ArrayList jobTime_id, ArrayList noRooms_id, ArrayList noBrooms_id, ArrayList floorType_id) {
        this.context = context;
        this.cusName_id = cusName_id;
        this.jobType_id = jobType_id;
        this.conNumber_id = conNumber_id;
        this.jobDate_id = jobDate_id;
        this.jobTime_id = jobTime_id;
        this.noRooms_id = noRooms_id;
        this.noBrooms_id = noBrooms_id;
        this.floorType_id = floorType_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cusName_id.setText(String.valueOf((cusName_id.get(position))));
        holder.jobType_id.setText(String.valueOf((jobType_id.get(position))));
        holder.conNumber_id.setText(String.valueOf((conNumber_id.get(position))));
        holder.jobDate_id.setText(String.valueOf((jobDate_id.get(position))));
        holder.jobTime_id.setText(String.valueOf((jobTime_id.get(position))));
        holder.noRooms_id.setText(String.valueOf((noRooms_id.get(position))));
        holder.noBrooms_id.setText(String.valueOf((noBrooms_id.get(position))));
        holder.floorType_id.setText(String.valueOf((floorType_id.get(position))));


    }

    @Override
    public int getItemCount() {
        return cusName_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cusName_id, jobType_id, conNumber_id, jobDate_id, jobTime_id,noRooms_id, noBrooms_id, floorType_id ;
            public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cusName_id = itemView.findViewById(R.id.txtcusName);
            jobType_id = itemView.findViewById(R.id.txtjobType);
            conNumber_id = itemView.findViewById(R.id.txtconNumber);
            jobDate_id = itemView.findViewById(R.id.txtjobDate);
            jobTime_id= itemView.findViewById(R.id.txtjobTime);
            noRooms_id = itemView.findViewById(R.id.txtnumofRooms);
            noBrooms_id = itemView.findViewById(R.id.txtnumofBrooms);
            floorType_id = itemView.findViewById(R.id.txtFloorType);
        }
    }



}

