package com.example.tabularview;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ContactsUs extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_contacts_us, container, false);
        TextView textview = view.findViewById(R.id.notification);
       String text = "Malik Muazzam viewed your profile. See all views.";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        return view;
    }
}