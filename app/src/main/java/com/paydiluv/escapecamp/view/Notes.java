package com.paydiluv.escapecamp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.paydiluv.escapecamp.R;
import com.paydiluv.escapecamp.utils.Logics;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class Notes extends Fragment {

    private ArrayList<Integer> inputs;

    @BindView(R.id.notestoHome)
    public Button notestoHomeButton;

    @BindView(R.id.noteswitch1)
    public Switch one;

    @BindView(R.id.noteswitch2)
    public Switch two;

    @BindView(R.id.noteswitch3)
    public Switch three;

    @BindView(R.id.noteswitch4)
    public Switch four;

    @BindView(R.id.noteswitch5)
    public Switch five;

    @BindView(R.id.noteswitch6)
    public Switch six;
    private Context context;

    public void backToHome(View button){
        Navigation.findNavController(button).navigate(NotesDirections.actionNotesToHomePage());
    }

    public void orders(CompoundButton compoundButton, boolean b){
        if(b){
            inputs.add(compoundButton.getId());
            if(compoundButton.getId() == Logics.getnoteatindex(inputs.size())-1){}
            else{
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                inputs.clear();
            }
            if(inputs.size()==6) {
                Logics.triggernotes();
            }
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
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        notestoHomeButton.setOnClickListener(this::backToHome);
        one.setOnCheckedChangeListener(this::orders);
        two.setOnCheckedChangeListener(this::orders);
        three.setOnCheckedChangeListener(this::orders);
        four.setOnCheckedChangeListener(this::orders);
        five.setOnCheckedChangeListener(this::orders);
        six.setOnCheckedChangeListener(this::orders);
    }

}