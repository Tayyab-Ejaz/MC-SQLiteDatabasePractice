package com.example.animation_seekbar_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DatabaseActivityViewRecord extends AppCompatActivity {

    ListView patientListView;
    ArrayList<Patient> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Remove title and action bars from top*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_database_view_record);


        PatientDBHelper db= new PatientDBHelper(this);
        patientListView = findViewById(R.id.PatientListView);

        list=db.GetAllPatients();

        

        ParientArrayAdapter adapter = new ParientArrayAdapter(this, list, null);
        patientListView.setAdapter(adapter);

        patientListView.setOnItemClickListener(new ListView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Patient p = (Patient) parent.getItemAtPosition(position);
                db.DeletePatient(p.ID);
                adapter.PatientList.remove(p);
                adapter.notifyDataSetChanged();   //Repopulate
            }
        });

    }
}