package com.paydiluv.escapecamp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FloraAndFauna")
public class FloraAndFauna {

    public FloraAndFauna() {
    }

    public FloraAndFauna(int i, String spe, String info, String b){
        this.uid = i;
        this.species= spe;
        this.info = info;
        this.danger = b;
    }

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "species")
    public String species;

    @ColumnInfo(name = "info")
    public String info;

    @ColumnInfo(name="dangerous")
    public String danger;
}
