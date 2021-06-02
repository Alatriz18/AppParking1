package com.utc.appparking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String nombreBdd="bdd_parking";//definiendo el nombre de la bdd
    private static final int versionBdd=1;
    private static final String tablaUsuario="create table usuario(id_usu integer primary key autoincrement," +
            "apellidos_usu text, nombres_usu text, email_usu text, password_usu text, telefono_usu text, direccion_usu text, fecha_usu text)";//Estructura de tabla usuario
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

    //Proceso3 captura de la fecha de registro de usuario
    private String getFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM//yyyy hh:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //Proceso 4 //registro de informacion de usurio
    public boolean registraUsuario(String apellidos, String nombres, String email, String password, String telefono, String direccion){
        SQLiteDatabase miBase=getWritableDatabase();
        if (miBase!=null){
            miBase.execSQL("insert into usuario(apellidos_usu, nombres_usu, email_usu, password_usu,telefono_usu, direccion_usu, fecha_usu) " +
                    "values('"+apellidos+"', '"+nombres+"', '"+email+"', '"+password+"', '"+telefono+"', '"+direccion+"', '"+getFecha()+"')");
            miBase.close();
            return true;
        }
        return false;
    }

    //Proceso 5 para consultar usuarios por email y password.
    public Cursor obtenerUsuarioPorEmailPassword(String email, String password){
        SQLiteDatabase miBase=getWritableDatabase(); // llamado a la base de datos
        //crear un cursor donde inserto la consulta sql y almaceno los resultados en el objeto usuario
        Cursor usuario = miBase.rawQuery("select * from usuario where " +
                "email_usu='"+email+"' and password_usu = '"+password+"';", null);

        //validar si existe o no la consulta
        if(usuario.moveToFirst()){ //metodo movetofirst nueve al primer elemento encontrado si hay el usuario
            return usuario; //retornamos los datos encontrados
        }else{
            //no se encuentra informacion de usuaio -> no existe o porque el email y password son incorrectos
            return null; //devuelvo null si no hay
        }
    }
}