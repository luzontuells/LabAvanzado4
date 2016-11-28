package com.example.a5alumno.labavanzado4.data;

/**
 * Created by A5Alumno on 28/11/2016.
 */

public abstract class ParamsDb { //La declaro como abstract porque no necesito instancias a esta clase
    public static final String _ID = "_id"; //Este es un campo obligatorio llamado _ID
    public static final String DB_NAME = "MyDatabase";
    public static final String TABLE_NAME = "MyTable";
    public static final int DB_VERSION = 1;
    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_AGE = "age";
}
