package com.paydiluv.escapecamp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FlnFrDAO {
    @Query("Select * from FloraAndFauna")
    List<FloraAndFauna> getAll();

    @Insert
    void insert(FloraAndFauna a);
}
