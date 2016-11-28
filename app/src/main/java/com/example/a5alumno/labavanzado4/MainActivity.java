package com.example.a5alumno.labavanzado4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                break;
            case R.id.btn_add_db:

                break;
            case R.id.btn_delete_db:

                break;
            default:

                break;
        }
    }
}
