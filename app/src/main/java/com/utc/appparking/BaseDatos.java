package com.utc.appparking;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public static final String nombreBdd="bdd_parking";//definiendo el nombre de la bdd
    public static final int versionBdd=1;
    public static final String tablaUsuario="";//definiendo la estructura de la tabla usuario
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
