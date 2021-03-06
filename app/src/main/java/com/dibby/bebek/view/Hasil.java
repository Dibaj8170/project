package com.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dibby.bebek.R;

public class Hasil extends AppCompatActivity implements View.OnClickListener {

    TextView txtHasil1, txtHasil2, txtHasil3, txtHasil4, txtHasil5, txtHasil6,
            txtHasil7, txtHasil8, txtHasil9, txtHasil10, txtHasil11, txtHasil12;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        txtHasil1 =  findViewById(R.id.txtH1);
        txtHasil2 =  findViewById(R.id.txtH2);
        txtHasil3 =  findViewById(R.id.txtH3);
        txtHasil4 =  findViewById(R.id.txtH4);
        txtHasil5 =  findViewById(R.id.txtH5);
        txtHasil6 =  findViewById(R.id.txtH6);
        txtHasil7 =  findViewById(R.id.txtH7);
        txtHasil8 =  findViewById(R.id.txtH8);
        txtHasil9 =  findViewById(R.id.txtH9);
        txtHasil10 = findViewById(R.id.txtH10);
        txtHasil11 = findViewById(R.id.txtH11);
        txtHasil12 = findViewById(R.id.txtH12);

        double h1 = getIntent().getDoubleExtra("hasil1", 0);
        double h2 = getIntent().getDoubleExtra("hasil2", 0);
        double h3 = getIntent().getDoubleExtra("hasil3", 0);
        double h4 = getIntent().getDoubleExtra("hasil4", 0);
        double h5 = getIntent().getDoubleExtra("hasil5", 0);
        double h6 = getIntent().getDoubleExtra("hasil6", 0);
        double h7 = getIntent().getDoubleExtra("hasil7", 0);
        double h8 = getIntent().getDoubleExtra("hasil8", 0);
        double h9 = getIntent().getDoubleExtra("hasil9", 0);
        double h10 = getIntent().getDoubleExtra("hasil10", 0);
        double h11 = getIntent().getDoubleExtra("hasil11", 0);
        double h12 = getIntent().getDoubleExtra("hasil12", 0);

        txtHasil1.setText("SNOT / coryza = " + h1 + "%");
        txtHasil2.setText("Berak Kapur = " + h2 + "%");
        txtHasil3.setText("Berak Hijau = " + h3 + "%");
        txtHasil4.setText("Kolera = " + h4 + "%");
        txtHasil5.setText("Chronic Respiratory = " + h5 + "%");
        txtHasil6.setText("Colibacillosis = " + h6 + "%");
        txtHasil7.setText("Newcastle Disease (ND) = " + h7 + "%");
        txtHasil8.setText("Gumuro = " + h8 + "%");
        txtHasil9.setText("Bronchitis = " + h9 + "%");
        txtHasil10.setText("Avian Pox = " + h10 + "%");
        txtHasil11.setText("Marek = " + h11 + "%");
        txtHasil12.setText("Berak Darah = " + h12 + "%");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button :
                startActivity(new Intent(this, PenyakitBebek.class));
                break;
        }

    }
}
