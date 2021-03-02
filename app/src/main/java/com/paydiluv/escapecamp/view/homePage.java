package com.paydiluv.escapecamp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.paydiluv.escapecamp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class homePage extends Fragment {

    @BindView(R.id.mapButton)
    public Button mapButton;

    @BindView(R.id.LexiconButton)
    public Button lexiconButton;

    @BindView(R.id.propButton)
    public Button propButton;

    @BindView(R.id.notesButton)
    public Button notesButton;

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
    }
}