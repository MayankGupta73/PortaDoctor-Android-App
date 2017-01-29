package com.example.mayankgupta.portadoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSearch;
    TextView tvList;
    Button btnGo,btnSearch,btnClear;
    ArrayList<String> symptomList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = (Button) findViewById(R.id.btnGo);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnClear = (Button) findViewById(R.id.btnClear);
        tvList = (TextView) findViewById(R.id.tvList);
        etSearch = (EditText) findViewById(R.id.etSearch);

        etSearch.clearFocus();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = etSearch.getText().toString();
                query = query.toLowerCase().trim();
                tvList.append("- "+query+"\n");
                symptomList.add(query);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                symptomList.clear();
                tvList.setText("");
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(symptomList.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter some Symptoms",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent i = new Intent(MainActivity.this,SymptomActivity.class);
                    i.putExtra("symptoms",symptomList);
                    startActivity(i);
                }
            }
        });
    }
}
