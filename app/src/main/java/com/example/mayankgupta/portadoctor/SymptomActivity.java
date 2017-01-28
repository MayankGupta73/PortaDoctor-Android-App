package com.example.mayankgupta.portadoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SymptomActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tvResult;
    Button btnOnline;
    ArrayList<Symptom> symptomArrayList = new ArrayList<>();
    SymptomRecycler symptomRecycler = new SymptomRecycler(this,symptomArrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        // TODO: Replace the ArrayList with an actual database preferably SQL.
        //Dummy Data
        symptomArrayList.add(new Symptom("Common Cold","A common cold. Not a big deal, chill take some cetrizine.",new ArrayList<String>(Arrays.asList("headache","sore throat","runny nose"))));
        symptomArrayList.add(new Symptom("Viral Fever","Bad luck. You'll need to stay home for a few days. Treat with paracetamol .",new ArrayList<String>(Arrays.asList("headache","high temperature","fatigue"))));
        symptomArrayList.add(new Symptom("Heat Stroke","You're dehydrated. Stay indoors and drink plenty of fluids.",new ArrayList<String>(Arrays.asList("dizziness","fatigue","rapid heartbeat"))));
        symptomArrayList.add(new Symptom("Diarrhea","You'll be exploding from both ends soon. Good luck.",new ArrayList<String>(Arrays.asList("watery stool","fever","abdominal pain"))));
        symptomArrayList.add(new Symptom("Heart Attack","If you were actually having one you probably wouldn't be reading this.",new ArrayList<String>(Arrays.asList("chest pain","dizziness","fatigue","nausea","anxiety","light headedness"))));
        symptomArrayList.add(new Symptom("Acidity","You probably ate too much. Have an antacid",new ArrayList<String>(Arrays.asList("stomachache","indigestion","constipation"))));

        recyclerView = (RecyclerView) findViewById(R.id.symptomRecycler);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnOnline = (Button) findViewById(R.id.btnOnline);

        final ArrayList<String> symptoms;
        Intent i = getIntent();
        symptoms = i.getStringArrayListExtra("symptoms");

        tvResult.setText("Found "+symptomArrayList.size()+" results.");
        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                for(int n=0; n<symptoms.size();n++){
                    stringBuilder.append(symptoms.get(n)).append(" ,");
                }

                Intent online = new Intent(Intent.ACTION_VIEW);
                online.setData(Uri.parse("http://www.google.com/search?q="+stringBuilder.toString()));
                startActivity(online);
            }
        });

        // TODO: search list and send the correct ArrayList to the recycler.

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(symptomRecycler);

    }
}
