package com.example.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.db.DatabaseHandler;
import com.example.dibby.bebek.pojo.Gejala;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView btnBebek, btnPenyakit, btnDiagnosa, btnCaraBertenak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBebek = findViewById(R.id.main_button_bebek);
        btnPenyakit = findViewById(R.id.main_button_penyakit);
        btnDiagnosa = findViewById(R.id.main_button_diagnosa);
        btnCaraBertenak = findViewById(R.id.main_button_cara_bertenak);

        btnBebek.setOnClickListener(this);
        btnPenyakit.setOnClickListener(this);
        btnDiagnosa.setOnClickListener(this);
        btnCaraBertenak.setOnClickListener(this);

        DatabaseHandler db = new DatabaseHandler(this);

        //*
        // * CRUD Operations
        // Inserting Contacts

        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Gejala(12,"Ravi", "9100000000", 0.5));
        db.addContact(new Gejala(11,"Srinivas", "9199999999",0.1));
        db.addContact(new Gejala(13,"Tommy", "9522222222",0.2));
        db.addContact(new Gejala(14,"Karthik", "9533333333",0.4));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Gejala> contacts = db.getAllContacts();

        for (Gejala cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber()+" ,Angka: " + cn.getAngka() ;
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button_bebek :
                startActivity(new Intent(this, TentangBebek.class));
                break;

            case R.id.main_button_penyakit :
                startActivity(new Intent(this, Penyakit.class));
                break;

            case R.id.main_button_diagnosa :
                startActivity(new Intent(this, Diagnosa.class));
                break;

            case R.id.main_button_cara_bertenak :
                startActivity(new Intent(this, CaraBeternak.class));
                break;
        }
    }
}
