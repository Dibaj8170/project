package com.example.dibby.bebek.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dibby.bebek.R;

public class Diagnosa extends AppCompatActivity implements View.OnClickListener {

    Button btnAnalisa, btnReset;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12,
            cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24,
            cb25, cb26, cb27, cb28, cb29, cb30, cb31, cb32, cb33, cb34, cb35, cb36, cb37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);

        btnAnalisa = findViewById(R.id.diagnosa_analisa);
        btnReset = findViewById(R.id.diagnosa_reset);

        cb1 = findViewById(R.id.g1);
        cb2 = findViewById(R.id.g2);
        cb3 = findViewById(R.id.g3);
        cb4 = findViewById(R.id.g4);
        cb5 = findViewById(R.id.g5);
        cb6 = findViewById(R.id.g6);
        cb7 = findViewById(R.id.g7);
        cb8 = findViewById(R.id.g8);
        cb9 = findViewById(R.id.g9);
        cb10 = findViewById(R.id.g10);
        cb11 = findViewById(R.id.g11);
        cb12 = findViewById(R.id.g12);
        cb13 = findViewById(R.id.g13);
        cb14 = findViewById(R.id.g14);
        cb15 = findViewById(R.id.g15);
        cb16 = findViewById(R.id.g16);
        cb17 = findViewById(R.id.g17);
        cb18 = findViewById(R.id.g18);
        cb19 = findViewById(R.id.g19);
        cb20 = findViewById(R.id.g20);
        cb21 = findViewById(R.id.g21);
        cb22 = findViewById(R.id.g22);
        cb23 = findViewById(R.id.g23);
        cb24 = findViewById(R.id.g24);
        cb25 = findViewById(R.id.g25);
        cb26 = findViewById(R.id.g26);
        cb27 = findViewById(R.id.g27);
        cb28 = findViewById(R.id.g28);
        cb29 = findViewById(R.id.g29);
        cb30 = findViewById(R.id.g30);
        cb31 = findViewById(R.id.g31);
        cb32 = findViewById(R.id.g32);
        cb33 = findViewById(R.id.g33);
        cb34 = findViewById(R.id.g34);
        cb35 = findViewById(R.id.g35);
        cb36 = findViewById(R.id.g36);
        cb37 = findViewById(R.id.g37);

        btnReset.setOnClickListener(this);
        btnAnalisa.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.diagnosa_reset :

                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(false);
                cb4.setChecked(false);
                cb5.setChecked(false);
                cb6.setChecked(false);
                cb7.setChecked(false);
                cb8.setChecked(false);
                cb9.setChecked(false);
                cb10.setChecked(false);
                cb11.setChecked(false);
                cb12.setChecked(false);
                cb13.setChecked(false);
                cb14.setChecked(false);
                cb15.setChecked(false);
                cb16.setChecked(false);
                cb17.setChecked(false);
                cb18.setChecked(false);
                cb19.setChecked(false);
                cb20.setChecked(false);
                cb21.setChecked(false);
                cb22.setChecked(false);
                cb23.setChecked(false);
                cb24.setChecked(false);
                cb25.setChecked(false);
                cb26.setChecked(false);
                cb27.setChecked(false);
                cb28.setChecked(false);
                cb29.setChecked(false);
                cb30.setChecked(false);
                cb31.setChecked(false);
                cb32.setChecked(false);
                cb33.setChecked(false);
                cb34.setChecked(false);
                cb35.setChecked(false);
                cb36.setChecked(false);
                cb37.setChecked(false);

                break;

            case R.id.diagnosa_analisa :
                break;
        }
    }
}
