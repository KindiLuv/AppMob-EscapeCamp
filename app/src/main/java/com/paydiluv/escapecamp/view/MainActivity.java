package com.paydiluv.escapecamp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import com.paydiluv.escapecamp.R;
import com.paydiluv.escapecamp.model.FlnFrDAO;
import com.paydiluv.escapecamp.model.FloraAndFauna;
import com.paydiluv.escapecamp.utils.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlnFrDAO flora;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getInstance(this);
        flora = db.fnfDao();
        // init data
        new ATaskIns().execute();
    }
    public class ATaskIns extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            db.clearAllTables();
            flora.insert(new FloraAndFauna(1, "Loup", "Canis Lupus", "Danger!"));
            flora.insert(new FloraAndFauna(2, "Cerf", "Cervus Elaphus", "Pas de danger"));
            flora.insert(new FloraAndFauna(3, "Amanite Tue Mouche", "Amanita Muscaria", "Danger!"));
            flora.insert(new FloraAndFauna(4, "Trompettes de la mort", "Craterellus cornucopioides", "Pas de danger"));
            return null;
        }
    }
}