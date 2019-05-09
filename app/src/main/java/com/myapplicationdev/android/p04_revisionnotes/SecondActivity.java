package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> alNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);


		lv = findViewById(R.id.lv);
		alNote = new ArrayList<>();


		DBHelper db = new DBHelper(this);

		ArrayList<Note> data = db.getAllNotes();
		db.close();

//		String txt = "";
		for (int i = 0; i < data.size(); i++) {

			alNote.add(data.get(i));
//			String name = alNote.get(i).getContent();
			int stars = alNote.get(i).getStars();

		}
		aa = new RevisionNotesArrayAdapter(this,R.layout.row,alNote);

		lv.setAdapter(aa);

	}
}
