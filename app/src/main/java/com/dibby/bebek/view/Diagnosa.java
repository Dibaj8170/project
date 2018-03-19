package com.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.dibby.bebek.R;
import com.dibby.bebek.db.DatabaseHandler;
import com.dibby.bebek.pojo.Gejala;

import java.util.ArrayList;
import java.util.Arrays;

public class Diagnosa extends AppCompatActivity implements View.OnClickListener {

    Button btnAnalisa, btnReset;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12,
            cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24,
            cb25, cb26, cb27, cb28, cb29, cb30, cb31, cb32, cb33, cb34, cb35, cb36, cb37, cb38;
    Double[] bobot = new Double[38];
    String[] idGejala = new String[38];
    ArrayList<Gejala> mGejala = new ArrayList<>();
    int i = 0;

    Double[] bobotP01 = new Double[7];
    Double[] bobotP02 = new Double[7];
    Double[] bobotP03 = new Double[5];
    Double[] bobotP04 = new Double[7];
    Double[] bobotP05 = new Double[6];
    Double[] bobotP06 = new Double[6];
    Double[] bobotP07 = new Double[7];
    Double[] bobotP08 = new Double[5];
    Double[] bobotP09 = new Double[5];
    Double[] bobotP10 = new Double[3];
    Double[] bobotP11 = new Double[5];
    Double[] bobotP12 = new Double[6];

    String[] P01 = {"G01","G02","G03","G04","G05","G06","G07"};
    String[] P02 = {"G05","G08","G09","G10","G11","G12","G13"};
    String[] P03 = {"G05","G09","G14","G15","G33"};
    String[] P04 = {"G05","G16","G17","G18","G19","G20","G21"};
    String[] P05 = {"G02","G05","G20","G22","G23","G24"};
    String[] P06 = {"G05","G09","G16","G22","G25","G26"};
    String[] P07 = {"G05","G14","G15","G22","G23","G24","G38"};
    String[] P08 = {"G05","G15","G30","G31","G32"};
    String[] P09 = {"G05","G07","G22","G33","G34"};
    String[] P10 = {"G05","G07","G18"};
    String[] P11 = {"G06","G21","G26","G27","G28"};
    String[] P12 = {"G05","G07","G18","G35","G36","G37"};


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
        cb38 = findViewById(R.id.g38);

        btnReset.setOnClickListener(this);
        btnAnalisa.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.diagnosa_reset :
                resetAll();
                break;

            case R.id.diagnosa_analisa :
                checkBox();
                checkPenyakit();
                analisis();
                break;
        }
    }

    private void resetAll() {

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
        
    }

    public void checkBox(){
        DatabaseHandler db = new DatabaseHandler(this);


        if (cb1.isChecked()){
            mGejala.add(db.getGejala("G01"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb2.isChecked()){
            mGejala.add(db.getGejala("G02"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb3.isChecked()){
            mGejala.add(db.getGejala("G03"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb4.isChecked()){
            mGejala.add(db.getGejala("G04"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb5.isChecked()){
            mGejala.add(db.getGejala("G05"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb6.isChecked()){
            mGejala.add(db.getGejala("G06"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb7.isChecked()){
            mGejala.add(db.getGejala("G07"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb8.isChecked()){
            mGejala.add(db.getGejala("G08"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb9.isChecked()){
            mGejala.add(db.getGejala("G09"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb10.isChecked()){
            mGejala.add(db.getGejala("G10"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb11.isChecked()){
            mGejala.add(db.getGejala("G11"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb12.isChecked()){
            mGejala.add(db.getGejala("G12"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb13.isChecked()){
            mGejala.add(db.getGejala("G13"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb14.isChecked()){
            mGejala.add(db.getGejala("G14"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb15.isChecked()){
            mGejala.add(db.getGejala("G15"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb16.isChecked()){
            mGejala.add(db.getGejala("G16"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb17.isChecked()){
            mGejala.add(db.getGejala("G17"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb18.isChecked()){
            mGejala.add(db.getGejala("G18"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb19.isChecked()){
            mGejala.add(db.getGejala("G19"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb20.isChecked()){
            mGejala.add(db.getGejala("G20"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb21.isChecked()){
            mGejala.add(db.getGejala("G21"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb22.isChecked()){
            mGejala.add(db.getGejala("G22"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb23.isChecked()){
            mGejala.add(db.getGejala("G23"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb24.isChecked()){
            mGejala.add(db.getGejala("G24"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb25.isChecked()){
            mGejala.add(db.getGejala("G25"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb26.isChecked()){
            mGejala.add(db.getGejala("G26"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb27.isChecked()){
            mGejala.add(db.getGejala("G27"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb28.isChecked()){
            mGejala.add(db.getGejala("G28"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb29.isChecked()){
            mGejala.add(db.getGejala("G29"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb30.isChecked()){
            mGejala.add(db.getGejala("G30"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb31.isChecked()){
            mGejala.add(db.getGejala("G31"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb32.isChecked()){
            mGejala.add(db.getGejala("G32"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb33.isChecked()){
            mGejala.add(db.getGejala("G33"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb34.isChecked()){
            mGejala.add(db.getGejala("G34"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb35.isChecked()){
            mGejala.add(db.getGejala("G35"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb36.isChecked()){
            mGejala.add(db.getGejala("G36"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb37.isChecked()){
            mGejala.add(db.getGejala("G37"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
        if (cb38.isChecked()){
            mGejala.add(db.getGejala("G38"));
            Gejala g = mGejala.get(i);
            bobot[i] = g.getAngka();
            idGejala[i] = g.getID();
            Log.i("Gejala", "Angka = " + bobot[i]);
            i++;
        }
    }
    
    public void checkPenyakit(){
        int jmlGejala = 0;
        //gejala yg di checkbox
        for (int x=0; x<i; x++){
            //setiap penyakit
            for(int y=1; y<=12; y++ ){
                if(y==1){jmlGejala = P01.length;}
                if(y==2){jmlGejala = P02.length;}
                if(y==3){jmlGejala = P03.length;}
                if(y==4){jmlGejala = P04.length;}
                if(y==5){jmlGejala = P05.length;}
                if(y==6){jmlGejala = P06.length;}
                if(y==7){jmlGejala = P07.length;}
                if(y==8){jmlGejala = P08.length;}
                if(y==9){jmlGejala = P09.length;}
                if(y==10){jmlGejala = P10.length;}
                if(y==11){jmlGejala = P11.length;}
                if(y==12){jmlGejala = P12.length;}

                //gejala yang ada di setiap penyakit
                for(int j=0; j<jmlGejala; j++){
                    if(y==1){
                        if(idGejala[x].equals(P01[j])){
                            bobotP01[j] = bobot[x];
                        }
                    }
                    if(y==2){
                        if(idGejala[x].equals(P02[j])){
                            bobotP02[j] = bobot[x];
                        }
                    }
                    if(y==3){
                        if(idGejala[x].equals(P03[j])){
                            bobotP03[j] = bobot[x];
                        }
                    }
                    if(y==4){
                        if(idGejala[x].equals(P04[j])){
                            bobotP04[j] = bobot[x];
                        }
                    }
                    if(y==5){
                        if(idGejala[x].equals(P05[j])){
                            bobotP05[j] = bobot[x];
                        }
                    }
                    if(y==6){
                        if(idGejala[x].equals(P06[j])){
                            bobotP06[j] = bobot[x];
                        }
                    }
                    if(y==7){
                        if(idGejala[x].equals(P07[j])){
                            bobotP07[j] = bobot[x];
                        }
                    }
                    if(y==8){
                        if(idGejala[x].equals(P08[j])){
                            bobotP08[j] = bobot[x];
                        }
                    }
                    if(y==9){
                        if(idGejala[x].equals(P09[j])){
                            bobotP09[j] = bobot[x];
                        }
                    }
                    if(y==10){
                        if(idGejala[x].equals(P10[j])){
                            bobotP10[j] = bobot[x];
                        }
                    }
                    if(y==11){
                        if(idGejala[x].equals(P11[j])){
                            bobotP11[j] = bobot[x];
                        }
                    }
                    if(y==12){
                        if(idGejala[x].equals(P12[j])){
                            bobotP12[j] = bobot[x];
                        }
                    }
                }
            }
        }
    }

    public void analisis(){
        Double tmpP1 = 0.0;
        Double tmpP2 = 0.0;
        Double tmpP3 = 0.0;
        Double tmpP4 = 0.0;
        Double tmpP5 = 0.0;
        Double tmpP6 = 0.0;
        Double tmpP7 = 0.0;
        Double tmpP8 = 0.0;
        Double tmpP9 = 0.0;
        Double tmpP10 = 0.0;
        Double tmpP11 = 0.0;
        Double tmpP12 = 0.0;

        if(bobotP01.length>1){
            
            Double a = null;
            int k = 0;
            for(int n = 0; n < P01.length; n++){
                if(bobotP01[n]!=null && k == 0) {
                    a = bobotP01[n];
                    k++;
                } else if(bobotP01[n]!=null && k == 1){
                    tmpP1 = (a * bobotP01[n]) + (a * (1-bobotP01[n])) + (bobotP01[n] * (1-a));
                    k++;
                } else if(bobotP01[n]!=null){
                    tmpP1 = (tmpP1 * bobotP01[n]) + (tmpP1 * (1-bobotP01[n])) + (bobotP01[n] * (1-tmpP1));
                }
            }
            tmpP1 = tmpP1 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP1));
        }
        if(bobotP02.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P02.length; n++){
                if(bobotP02[n]!=null && k == 0) {
                    a = bobotP02[n];
                    k++;
                } else if(bobotP02[n]!=null && k == 1){
                    tmpP2 = (a * bobotP02[n]) + (a * (1-bobotP02[n])) + (bobotP02[n] * (1-a));
                    k++;
                } else if(bobotP02[n]!=null){
                    tmpP2 = (tmpP2 * bobotP02[n]) + (tmpP2 * (1-bobotP02[n])) + (bobotP02[n] * (1-tmpP2));
                }
            }
            tmpP2 = tmpP2 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP2));
        }
        if(bobotP03.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P03.length; n++){
                if(bobotP03[n]!=null && k == 0) {
                    a = bobotP03[n];
                    k++;
                } else if(bobotP03[n]!=null && k == 1){
                    tmpP3 = (a * bobotP03[n]) + (a * (1-bobotP03[n])) + (bobotP03[n] * (1-a));
                    k++;
                } else if(bobotP03[n]!=null){
                    tmpP3 = (tmpP3 * bobotP03[n]) + (tmpP3 * (1-bobotP03[n])) + (bobotP03[n] * (1-tmpP3));
                }
            }
            tmpP3 = tmpP3 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP3));
        }
        if(bobotP04.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P04.length; n++){
                if(bobotP04[n]!=null && k == 0) {
                    a = bobotP04[n];
                    k++;
                } else if(bobotP04[n]!=null && k == 1){
                    tmpP4 = (a * bobotP04[n]) + (a * (1-bobotP04[n])) + (bobotP04[n] * (1-a));
                    k++;
                } else if(bobotP04[n]!=null){
                    tmpP4 = (tmpP4 * bobotP04[n]) + (tmpP4 * (1-bobotP04[n])) + (bobotP04[n] * (1-tmpP4));
                }
            }
            tmpP4 = tmpP4 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP4));
        }
        if(bobotP05.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P05.length; n++){
                if(bobotP05[n]!=null && k == 0) {
                    a = bobotP05[n];
                    k++;
                } else if(bobotP05[n]!=null && k == 1){
                    tmpP5 = (a * bobotP05[n]) + (a * (1-bobotP05[n])) + (bobotP05[n] * (1-a));
                    k++;
                } else if(bobotP05[n]!=null){
                    tmpP5 = (tmpP5 * bobotP05[n]) + (tmpP5 * (1-bobotP05[n])) + (bobotP05[n] * (1-tmpP5));
                }
            }
            tmpP5 = tmpP5 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP5));
        }
        if(bobotP06.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P06.length; n++){
                if(bobotP06[n]!=null && k == 0) {
                    a = bobotP06[n];
                    k++;
                } else if(bobotP06[n]!=null && k == 1){
                    tmpP6 = (a * bobotP06[n]) + (a * (1-bobotP06[n])) + (bobotP06[n] * (1-a));
                    k++;
                } else if(bobotP06[n]!=null){
                    tmpP6 = (tmpP6 * bobotP06[n]) + (tmpP6 * (1-bobotP06[n])) + (bobotP06[n] * (1-tmpP6));
                }
            }
            tmpP6 = tmpP6 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP6));
        }
        if(bobotP07.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P07.length; n++){
                if(bobotP07[n]!=null && k == 0) {
                    a = bobotP07[n];
                    k++;
                } else if(bobotP07[n]!=null && k == 1){
                    tmpP7 = (a * bobotP07[n]) + (a * (1-bobotP07[n])) + (bobotP07[n] * (1-a));
                    k++;
                } else if(bobotP07[n]!=null){
                    tmpP7 = (tmpP7 * bobotP07[n]) + (tmpP7 * (1-bobotP07[n])) + (bobotP07[n] * (1-tmpP7));
                }
            }
            tmpP7 = tmpP7 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP7));
        }
        if(bobotP08.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P08.length; n++){
                if(bobotP08[n]!=null && k == 0) {
                    a = bobotP08[n];
                    k++;
                } else if(bobotP08[n]!=null && k == 1){
                    tmpP8 = (a * bobotP08[n]) + (a * (1-bobotP08[n])) + (bobotP08[n] * (1-a));
                    k++;
                } else if(bobotP08[n]!=null){
                    tmpP8 = (tmpP8 * bobotP08[n]) + (tmpP8 * (1-bobotP08[n])) + (bobotP08[n] * (1-tmpP8));
                }
            }
            tmpP8 = tmpP8 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP8));
        }
        if(bobotP09.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P09.length; n++){
                if(bobotP09[n]!=null && k == 0) {
                    a = bobotP09[n];
                    k++;
                } else if(bobotP09[n]!=null && k == 1){
                    tmpP9 = (a * bobotP09[n]) + (a * (1-bobotP09[n])) + (bobotP09[n] * (1-a));
                    k++;
                } else if(bobotP09[n]!=null){
                    tmpP9 = (tmpP9 * bobotP09[n]) + (tmpP9 * (1-bobotP09[n])) + (bobotP09[n] * (1-tmpP9));
                }
            }
            tmpP9 = tmpP9 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP9));
        }
        if(bobotP10.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P10.length; n++){
                if(bobotP10[n]!=null && k == 0) {
                    a = bobotP10[n];
                    k++;
                } else if(bobotP10[n]!=null && k == 1){
                    tmpP10 = (a * bobotP10[n]) + (a * (1-bobotP10[n])) + (bobotP10[n] * (1-a));
                    k++;
                } else if(bobotP10[n]!=null){
                    tmpP10 = (tmpP10 * bobotP10[n]) + (tmpP10 * (1-bobotP10[n])) + (bobotP10[n] * (1-tmpP10));
                }
            }
            tmpP10 = tmpP10 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP10));
        }
        if(bobotP11.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P11.length; n++){
                if(bobotP11[n]!=null && k == 0) {
                    a = bobotP11[n];
                    k++;
                } else if(bobotP11[n]!=null && k == 1){
                    tmpP11 = (a * bobotP11[n]) + (a * (1-bobotP11[n])) + (bobotP11[n] * (1-a));
                    k++;
                } else if(bobotP11[n]!=null){
                    tmpP11 = (tmpP11 * bobotP11[n]) + (tmpP11 * (1-bobotP11[n])) + (bobotP11[n] * (1-tmpP11));
                }
            }
            tmpP11 = tmpP11 * 100;
            Log.e("hasil1 = ", String.valueOf(tmpP11));
        }
        if(bobotP12.length>1){
            Double a = null;
            int k = 0;
            for(int n = 0; n < P12.length; n++){
                if(bobotP12[n]!=null && k == 0) {
                    a = bobotP12[n];
                    k++;
                } else if(bobotP12[n]!=null && k == 1){
                    tmpP12 = (a * bobotP12[n]) + (a * (1-bobotP12[n])) + (bobotP12[n] * (1-a));
                    k++;
                } else if(bobotP12[n]!=null){
                    tmpP12 = (tmpP12 * bobotP12[n]) + (tmpP12 * (1-bobotP12[n])) + (bobotP12[n] * (1-tmpP12));
                }
            }
            tmpP12 = tmpP12 * 100;

            Log.e("hasil1 = ", String.valueOf(tmpP12));
            
            
        }

        Intent i=new Intent(this, Hasil.class);
        i.putExtra("hasil1", tmpP1);
        i.putExtra("hasil2", tmpP2);
        i.putExtra("hasil3", tmpP3);
        i.putExtra("hasil4", tmpP4);
        i.putExtra("hasil5", tmpP5);
        i.putExtra("hasil6", tmpP6);
        i.putExtra("hasil7", tmpP7);
        i.putExtra("hasil8", tmpP8);
        i.putExtra("hasil9", tmpP9);
        i.putExtra("hasil10", tmpP10);
        i.putExtra("hasil11", tmpP11);
        i.putExtra("hasil12", tmpP12);
        startActivity(i);
        finish();
    }
}
