package com.paydiluv.escapecamp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.paydiluv.escapecamp.R;
import com.paydiluv.escapecamp.utils.Logics;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class homePage extends Fragment {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.mapButton)
    public ImageButton mapButton;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.LexiconButton)
    public ImageButton lexiconButton;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.propButton)
    public ImageButton propButton;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.notesButton)
    public ImageButton notesButton;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.finalcode)
    public TextInputEditText finalcode;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.escaped)
    public TextView escaped;
    private Context context;

    public void homeToMap(View button){
       Navigation.findNavController(button).navigate(homePageDirections.homeToMap());
    }

    public void homeToProp(View button){
       Navigation.findNavController(button).navigate(homePageDirections.propButton());
    }

    public void homeToLexicon(View button){
        Navigation.findNavController(button).navigate(homePageDirections.homeToLexicon());
    }

    public void homeToNotes(View button){
        Navigation.findNavController(button).navigate(homePageDirections.homeToNotes());
    }

    public boolean validator(View v, int keyCode, KeyEvent event){
        if( keyCode == KeyEvent.KEYCODE_ENTER && Logics.mapTrig && Logics.notescleared){
            System.out.println("obj");
            System.out.println(finalcode.getEditableText().toString().trim());
            if(finalcode.getEditableText().toString().trim().equals("64152")) {
                escaped.setTextColor(Color.WHITE);
                System.out.println("visibility changed");
            }
        }
        System.out.println(keyCode);
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mapButton.setOnClickListener(this::homeToMap);
        lexiconButton.setOnClickListener(this::homeToLexicon);
        notesButton.setOnClickListener(this::homeToNotes);
        propButton.setOnClickListener(this::homeToProp);
        finalcode.setOnKeyListener(this::validator);
    }
}