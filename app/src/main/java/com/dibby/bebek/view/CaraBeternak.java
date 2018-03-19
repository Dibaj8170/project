package com.dibby.bebek.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dibby.bebek.R;
import com.dibby.bebek.fragment.caraBertenak.FragmentLingkungan;
import com.dibby.bebek.fragment.caraBertenak.FragmentNewBorn;
import com.dibby.bebek.fragment.caraBertenak.FragmentPedaging;
import com.dibby.bebek.fragment.caraBertenak.FragmentPetelur;

public class CaraBeternak extends AppCompatActivity implements
        FragmentPedaging.OnFragmentInteractionListener,
        FragmentNewBorn.OnFragmentInteractionListener,
        FragmentPetelur.OnFragmentInteractionListener,
        FragmentLingkungan.OnFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomMenuCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_beternak);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.cara_frame_layout, FragmentNewBorn.newInstance());
        fragmentTransaction.commit();

        bottomMenuCara = findViewById(R.id.cara_bottom_menu);
        bottomMenuCara.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_new_born :
                fragment = FragmentNewBorn.newInstance();
                break;
            case R.id.menu_petelur :
                fragment = FragmentPetelur.newInstance();
                break;
            case R.id.menu_pedaging :
                fragment = FragmentPedaging.newInstance();
                break;
            case R.id.menu_lingkungan :
                fragment = FragmentLingkungan.newInstance();
                break;
        }

        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.cara_frame_layout, fragment);
            fragmentTransaction.commit();
        }
        return true;
    }
}
