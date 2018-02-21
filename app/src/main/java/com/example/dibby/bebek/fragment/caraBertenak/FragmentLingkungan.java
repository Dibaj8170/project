package com.example.dibby.bebek.fragment.caraBertenak;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.dibby.bebek.R;

/**
 * Created by dibby on 13/02/2018.
 */

public class FragmentLingkungan extends Fragment{

    private OnFragmentInteractionListener listener;

    public static FragmentLingkungan newInstance(){
        return new FragmentLingkungan();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_lingkungan, container, false
        );
        String text1 = getResources().getString(R.string.ling_par1);
        String text2 = getResources().getString(R.string.ling_par2);
        String text3 = getResources().getString(R.string.ling_par3);
        String text4 = getResources().getString(R.string.ling_par4);
        String text5 = getResources().getString(R.string.ling_par5);
        String text6 = getResources().getString(R.string.ling_par6);
        String text7 = getResources().getString(R.string.ling_par7);

        WebView webView1 = view.findViewById(R.id.webview1);
        webView1.loadData("<p style=\"text-align: justify\">" + text1 + "</p>", "text/html", "UTF-8");

        WebView webView2 = view.findViewById(R.id.webview2);
        webView2.loadData("<p style=\"text-align: justify\">" + text2 + "</p>", "text/html", "UTF-8");

        WebView webView3 = view.findViewById(R.id.webview3);
        webView3.loadData("<p style=\"text-align: justify\">" + text3 + "</p>", "text/html", "UTF-8");

        WebView webView4 = view.findViewById(R.id.webview4);
        webView4.loadData("<p style=\"text-align: justify\">" + text4 + "</p>", "text/html", "UTF-8");

        WebView webView5 = view.findViewById(R.id.webview5);
        webView5.loadData("<p style=\"text-align: justify\">" + text5 + "</p>", "text/html", "UTF-8");

        WebView webView6 = view.findViewById(R.id.webview6);
        webView6.loadData("<p style=\"text-align: justify\">" + text6 + "</p>", "text/html", "UTF-8");

        WebView webView7 = view.findViewById(R.id.webview7);
        webView7.loadData("<p style=\"text-align: justify\">" + text7 + "</p>", "text/html", "UTF-8");

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentLingkungan.OnFragmentInteractionListener){
            listener = (FragmentLingkungan.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
    }

}
