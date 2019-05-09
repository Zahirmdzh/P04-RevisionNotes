package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowlist;
    EditText etTextNote;
    RadioGroup rgStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShowlist = findViewById(R.id.buttonShowList);
        etTextNote = findViewById(R.id.editTextNote);
        rgStars = findViewById(R.id.radioGroupStars);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper db = new DBHelper(MainActivity.this);
                db.getWritableDatabase();

                String note = etTextNote.getText().toString();
                int selectedstars = rgStars.getCheckedRadioButtonId();

                RadioButton rb = findViewById(selectedstars);
                String value = rb.getText().toString();


                if (note != null) {
                    db.insertNote(note, Integer.parseInt(value));

                    Toast.makeText(MainActivity.this,"Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Please enter note", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });


        btnShowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }
}
