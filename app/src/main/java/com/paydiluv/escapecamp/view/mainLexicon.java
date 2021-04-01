package com.paydiluv.escapecamp.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.paydiluv.escapecamp.R;
import com.paydiluv.escapecamp.model.FlnFrDAO;
import com.paydiluv.escapecamp.model.FloraAndFauna;
import com.paydiluv.escapecamp.model.LexiconAdapter;
import com.paydiluv.escapecamp.utils.AppDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class mainLexicon extends Fragment {
    @BindView(R.id.lexiconToHome)
    public Button lexitoHomeButton;
    @BindView(R.id.datarecycler)
    public RecyclerView recycle;

    private Context context;
    private AppDatabase db;
    private FlnFrDAO dao;
    private List<FloraAndFauna> data;

    public void backToHome(View button){
        Navigation.findNavController(button).navigate(mainLexiconDirections.actionMainLexiconToHomePage());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_lexicon, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.context = getContext();
        db = AppDatabase.getInstance(getActivity());
        dao = db.fnfDao();
        new AtaskLexicon().execute();
        //recycler
        lexitoHomeButton.setOnClickListener(this::backToHome);
    }

    private class AtaskLexicon extends AsyncTask<Void, Void, List<FloraAndFauna>>{

        @Override
        protected List<FloraAndFauna> doInBackground(Void... voids) {
            data = dao.getAll();
            return data;
        }

        @Override
        protected void onPostExecute(List<FloraAndFauna> floraAndFaunas) {
            super.onPostExecute(floraAndFaunas);
            LexiconAdapter adapter = new LexiconAdapter(data);
            recycle.setLayoutManager(new LinearLayoutManager(context));
            recycle.setAdapter(adapter);
        }
    }
}