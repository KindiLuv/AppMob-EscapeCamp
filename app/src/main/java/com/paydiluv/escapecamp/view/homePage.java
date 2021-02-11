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
    public Button button;

    public void homeToMap(View button){
       Navigation.findNavController(button).navigate(homePageDirections.homeToMap());
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
        button.setOnClickListener(this::homeToMap);
    }
}