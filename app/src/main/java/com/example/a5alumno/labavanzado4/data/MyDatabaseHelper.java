package com.example.a5alumno.labavanzado4.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A5Alumno on 28/11/2016.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {//No define la base de datos, define el SQLite Helper

    public static final String CREATE_DB_TABLE = "CREATE TABLE " + ParamsDb.TABLE_NAME + " ("
            + ParamsDb._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ParamsDb.STUDENT_NAME + " TEXT , "
            + ParamsDb.STUDENT_AGE + " INTEGER);";

    public MyDatabaseHelper(Context context) {
        //Lo hemos modificado, hemos creado un constructor propio
        super(context, ParamsDb.DB_NAME, null, ParamsDb.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Estoy creando la tabla, no la base de datos
        db.execSQL(MyDatabaseHelper.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
