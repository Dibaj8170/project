package com.example.dibby.bebek.fragment.detailPenyakit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.view.DetailPenyakit;

/**
 * Created by dibby on 13/02/2018.
 */

public class FragmentPenularan extends Fragment {

    String tai;
    public FragmentPenularan(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penularan, container, false);

        TextView textView = view.findViewById(R.id.penularan);
        tai = ((DetailPenyakit)getActivity()).getCegah();

        textView.setText(tai);


        return view;
    }
}
