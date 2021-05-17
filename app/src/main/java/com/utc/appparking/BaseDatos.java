package com.utc.appparking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public static final String nombreBdd="bdd_parking";//definiendo el nombre de la bdd
    public static final int versionBdd=1;
    public static final String tablaUsuario="create table usuario(id_usu integer primary key autoincrement," +
            "apellidos_usu text,nombres_usu text, email_usu text, password_usu text, telefono_usu text, direccion_usu text)";//Estructura de tabla usuario
    //constructor

    public BaseDatos (Context contexto){super(contexto, nombreBdd,null, versionBdd);}

    //proceso1: metodo q ejecuta automaticamente al construir la clase Base Datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuario);//ejeucutando el ddl para crear la tabla usuario


    }
    //proceso2: metodo que se ejcuta cuando se detectan cambios en la version de la bdd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS usuario");//se borra la version anterior de la tabla
    db.execSQL(tablaUsuario);//se crea nuevamente la tabla usuario
    }
}
