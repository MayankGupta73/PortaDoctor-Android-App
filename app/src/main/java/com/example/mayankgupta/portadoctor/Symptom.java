package com.example.mayankgupta.portadoctor;

import java.util.ArrayList;

/**
 * Created by Mayank Gupta on 27-01-2017.
 */

public class Symptom {
    String name,description;
    ArrayList<String> symptoms;

    public Symptom(String name, String description, ArrayList<String> symptoms) {
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {

        return name;
    }
}
