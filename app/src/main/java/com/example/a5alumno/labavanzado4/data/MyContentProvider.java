package com.example.a5alumno.labavanzado4.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
    //Las hacemos public:
    public static final String PROVIDER_AUTHORITY = "com.example.a5alumno.labavanzado4";
    public static final Uri CONTENT_URI = Uri.parse("content://" + MyContentProvider.PROVIDER_AUTHORITY);

    private MyDatabaseHelper myDatabaseHelper;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

//        SQLiteDatabase db = this.myDatabaseHelper.getWritableDatabase();
//        int regId = db.delete(ParamsDb.TABLE_NAME, selection, selectionArgs);

        int regId = this.myDatabaseHelper.getWritableDatabase().delete(ParamsDb.TABLE_NAME, selection, selectionArgs);
        return regId;

    }

    @Override
    public String getType(Uri uri) {

        //Tengo que


        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {


        long regId = this.myDatabaseHelper.getWritableDatabase().insert(ParamsDb.TABLE_NAME, null, values);
        /* En dos pasos
        SQLiteDatabase db = this.myDatabaseHelper.getWritableDatabase();
        long regId = db.insert();

         Yo podría hacer una inserción a lo bruto, usando db.execSQL, pero no tiene mucho sentido
         utilizar capas de abstracción y después hacer esta inserción.
         */
        return ContentUris.withAppendedId(MyContentProvider.CONTENT_URI, regId);
    }

    @Override
    public boolean onCreate() {

        //Crear la Base de Datos
        this.myDatabaseHelper = new MyDatabaseHelper(this.getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = this.myDatabaseHelper.getReadableDatabase();
        return db.query(ParamsDb.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
