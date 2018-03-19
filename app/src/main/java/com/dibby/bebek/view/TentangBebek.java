package com.dibby.bebek.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dibby.bebek.R;
import com.dibby.bebek.fragment.bebek.FragmentBebek;
import com.dibby.bebek.fragment.bebek.FragmentDaging;
import com.dibby.bebek.fragment.bebek.FragmentTelur;

public class TentangBebek extends AppCompatActivity implements
        FragmentTelur.OnFragmentInteractionListener,
        FragmentDaging.OnFragmentInteractionListener,
        FragmentBebek.OnFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_bebek);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bebek_frame_layout, FragmentBebek.newInstance());
        fragmentTransaction.commit();

        bottomMenu = findViewById(R.id.bebek_bottom_menu);
        bottomMenu.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_bebek :
                fragment = FragmentBebek.newInstance();
                break;
            case R.id.menu_telur :
                fragment = FragmentTelur.newInstance();
                break;
            case R.id.menu_daging :
                fragment = FragmentDaging.newInstance();
                break;
        }

        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.bebek_frame_layout, fragment);
            fragmentTransaction.commit();
        }
        return true;
    }
}
