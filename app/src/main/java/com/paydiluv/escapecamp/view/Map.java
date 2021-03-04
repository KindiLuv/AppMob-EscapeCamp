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
import android.widget.ImageButton;

import com.paydiluv.escapecamp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Map extends Fragment {

    @BindView(R.id.ltohome)
    public Button ltohome;

    @BindView(R.id.mapToCompass)
    public ImageButton mapToCompassButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void backToHome(View button){
        Navigation.findNavController(button).navigate(MapDirections.mapToHomePage());
    }

    public void getToCompass(View button){
        Navigation.findNavController(button).navigate(MapDirections.mapToCompass());
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        ltohome.setOnClickListener(this::backToHome);
        mapToCompassButton.setOnClickListener(this::getToCompass);
    }
}