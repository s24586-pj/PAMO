package com.example.zadanienrdwa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import android.webkit.WebView;

public class BmiChartFragment extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Ładowanie widoku->znajdowanie elementu->setJavaScriptEnabled->wstawienie pliku html
        View view = inflater.inflate(R.layout.fragment_bmi_chart, container, false);

        webView = view.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);


        webView.loadUrl("file:///android_asset/bmi_chart.html");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webView = null;
    }
}
