package com.example.a5alumno.labavanzado4.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a5alumno.labavanzado4.R;
import com.example.a5alumno.labavanzado4.data.MyContentProvider;
import com.example.a5alumno.labavanzado4.data.MyDatabaseHelper;
import com.example.a5alumno.labavanzado4.data.ParamsDb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private EditText edtName, edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edtName = (EditText) findViewById(R.id.edt_text_name);
        this.edtAge = (EditText) findViewById(R.id.edt_txt_age);

        final Button btnQueryDb = (Button) this.findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);

        final Button btnAddDb = (Button) this.findViewById(R.id.btn_add_db);
        btnAddDb.setOnClickListener(this);

        final Button btnDeleteDb = (Button) this.findViewById(R.id.btn_delete_db);
        btnDeleteDb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query_db:

                Cursor queryCursor = getContentResolver().query(MyContentProvider.CONTENT_URI, null, null, null, null);

                StringBuilder dbContent = new StringBuilder("");

                //Primero: recorrer el cursor

                while (queryCursor.moveToNext()) {


                    dbContent.append("\n " + queryCursor.getString(queryCursor.getColumnIndex(ParamsDb.STUDENT_NAME))
                            + " " + queryCursor.getInt(queryCursor.getColumnIndex(ParamsDb.STUDENT_AGE))
                            + "\n"); //Añadimos los campos que queremos.
                    //dbContent.append("\n " + queryCursor.getString(1) + " " + queryCursor.getInt(2)); //Evitamos Magic Numbers!
                    //Aquí se usa concatenación de Strings en un StringBuilder, no es buena práctica, pero era para ahorrar tiempo.

                }

                //¡Siempre! Hay que cerrar el Cursor

                queryCursor.close();

                Toast.makeText(this, dbContent.toString(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_add_db:

                ContentValues insertValues = new ContentValues();

                insertValues.put(ParamsDb.STUDENT_NAME, this.edtName.getText().toString()); //Introducimos los valores: Nombre de columna, Datos.
                insertValues.put(ParamsDb.STUDENT_AGE, this.edtAge.getText().toString());

                Uri insertUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, insertValues);

                break;
            case R.id.btn_delete_db:

                String deleteName = this.edtName.getText().toString();
                String deleteAge = this.edtAge.getText().toString();

                int deleteUri = getContentResolver().delete(MyContentProvider.CONTENT_URI, ParamsDb.STUDENT_NAME + "=? AND "
                        +ParamsDb.STUDENT_AGE +"=?",
                        new String[]{deleteName,deleteAge});

                Toast.makeText(this, deleteName + ", with an age of " + deleteAge + ", has been removed" ,Toast.LENGTH_SHORT).show();
                break;
            default:

                break;
        }
    }
}
