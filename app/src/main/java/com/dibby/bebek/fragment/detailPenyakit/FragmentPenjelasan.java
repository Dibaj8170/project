package com.dibby.bebek.fragment.detailPenyakit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dibby.bebek.R;
import com.dibby.bebek.view.DetailPenyakit;

/**
 * Created by dibby on 13/02/2018.
 */

public class FragmentPenjelasan extends Fragment {

    String jelas;
    public FragmentPenjelasan(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penjelasan, container, false);

        TextView textView = view.findViewById(R.id.penjelasan);
        jelas = ((DetailPenyakit)getActivity()).getJelas();

        textView.setText(jelas);

        return view;

    }
}
