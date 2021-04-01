package com.paydiluv.escapecamp.utils;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.paydiluv.escapecamp.model.FlnFrDAO;
import com.paydiluv.escapecamp.model.FloraAndFauna;

@Database(entities = {FloraAndFauna.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FlnFrDAO fnfDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "appDatabase"
            ).fallbackToDestructiveMigration().build();
        } return instance;
    }
}
