package com.example.mayankgupta.portadoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Symptom2Activity extends AppCompatActivity {

    TextView tvName, tvSymptom, tvDesc;
    Button btnOnline, btnForum, btnCall;

    public static final String number = "12345678";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom2);

        tvName = (TextView) findViewById(R.id.tvName);
        tvSymptom = (TextView) findViewById(R.id.tvSymptom);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnForum = (Button) findViewById(R.id.btnForum);
        btnOnline = (Button) findViewById(R.id.btnOnline);

        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        ArrayList<String> symptoms = i.getStringArrayListExtra("symptoms");
        String desc = i.getStringExtra("description");

        tvName.setText(name);
        tvDesc.setText(desc);

        StringBuilder stringBuilder = new StringBuilder();
        for (int n=0; n<symptoms.size();n++){
            stringBuilder.append(symptoms.get(n)).append(", ");
        }
        tvSymptom.setText(stringBuilder.toString());

        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent online = new Intent(Intent.ACTION_VIEW);
                online.setData(Uri.parse("http://www.google.com/search?q="+name));
                startActivity(online);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:+91"+number));
                startActivity(call);
            }
        });

        btnForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Has code to connect to forums
            }
        });
    }
}
