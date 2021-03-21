package com.paydiluv.escapecamp.utils;

public class Logics {

    public static boolean mapTrig = false;
    public static int[] noteslogics = {2,5,4,3,6,1};
    public static boolean notescleared = false;

    public static void triggerMaps(){
        mapTrig = true;
    }

    public static int getnoteatindex(int i){
        return noteslogics[i];
    }

    public static void triggernotes(){
        notescleared = true;
    }
}
