package com.paydiluv.escapecamp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.paydiluv.escapecamp.R;
import com.paydiluv.escapecamp.utils.Logics;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.core.content.ContextCompat.getSystemService;
import static java.lang.Thread.sleep;

public class Map extends Fragment {

    @BindView(R.id.ltohome)
    public Button ltohome;

    @BindView(R.id.mapToCompass)
    public ImageButton mapToCompassButton;

    @BindView(R.id.marker1)
    public ImageButton marker1;

    @BindView(R.id.marker2)
    public ImageButton marker2;

    @BindView(R.id.marker3)
    public ImageButton marker3;

    @BindView(R.id.marker4)
    public ImageButton marker4;

    @BindView(R.id.marker5)
    public ImageButton marker5;

    @BindView(R.id.marker6)
    public ImageButton marker6;

    @BindView(R.id.marker7)
    public ImageButton marker7;

    @BindView(R.id.textView3)
    public TextView validity;
    private Context context;


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
    @SuppressLint("ResourceAsColor")
    public void setLogics(View view){
        validity.setTextColor(Color.GREEN);
        Logics.triggerMaps();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @SuppressLint("ResourceAsColor")
    public void wrongMarker(View view) {
        validity.setTextColor(Color.RED);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        ltohome.setOnClickListener(this::backToHome);
        mapToCompassButton.setOnClickListener(this::getToCompass);
        marker4.setOnClickListener(this::setLogics);
        marker1.setOnClickListener(this::wrongMarker);
        marker2.setOnClickListener(this::wrongMarker);
        marker3.setOnClickListener(this::wrongMarker);
        marker5.setOnClickListener(this::wrongMarker);
        marker6.setOnClickListener(this::wrongMarker);
        marker7.setOnClickListener(this::wrongMarker);
    }

}