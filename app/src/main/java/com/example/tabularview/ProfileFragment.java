package com.example.tabularview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ProfileFragment extends Fragment {

String[] options = {"Anyone","Connection Only"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        //Spinner spin = view.findViewById(spinner);
       // ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,options);
       // arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // spin.setAdapter(arr);
        return view;
    }
}