package com.paydiluv.escapecamp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.paydiluv.escapecamp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Properties extends Fragment {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.propToHome)
    public Button propToHome;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.darkthemeswitch)
    public Switch switchToDark;

    @BindView(R.id.frameLayout3)
    public ConstraintLayout lay;
    private Context context;

    public void backToHome(View button){
        Navigation.findNavController(button).navigate(PropertiesDirections.actionPropertiesToHomePage());
    }

    @SuppressLint("ResourceAsColor")
    private void themeswitch(CompoundButton compoundButton, boolean b) {
        if(b){
            lay.setBackgroundResource(R.color.black);
        }else{
            lay.setBackgroundResource(R.color.white);
        }
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
        View view = inflater.inflate(R.layout.fragment_properties, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        propToHome.setOnClickListener(this::backToHome);
        switchToDark.setOnCheckedChangeListener(this::themeswitch);
    }
}