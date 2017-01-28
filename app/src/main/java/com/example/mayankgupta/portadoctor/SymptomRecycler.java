package com.example.mayankgupta.portadoctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mayank Gupta on 27-01-2017.
 */

public class SymptomRecycler extends RecyclerView.Adapter<SymptomRecycler.Holder>  {

    Context context;
    ArrayList<Symptom> symptomList;

    public SymptomRecycler(Context context, ArrayList<Symptom> symptomList) {
        this.context = context;
        this.symptomList = symptomList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.symptom,parent,false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Symptom symptom = symptomList.get(position);
        holder.tvName.setText(symptom.getName());
        holder.tvDesc.setText(symptom.getDescription());
        ArrayList<String> symps = symptom.getSymptoms();
        String symptomView = String.valueOf(symps.get(0)+" , "+symps.get(1)+" , "+symps.get(2)+" ...");
        holder.tvSymptom.setText(symptomView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Symptom2Activity.class);
                i.putExtra("name",symptom.getName());
                i.putExtra("description",symptom.getDescription());
                i.putStringArrayListExtra("symptoms",symptom.getSymptoms());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return symptomList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView tvName, tvDesc, tvSymptom;
        View itemView;

        public Holder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvSymptom = (TextView) itemView.findViewById(R.id.tvSymptom);
        }
    }
}
