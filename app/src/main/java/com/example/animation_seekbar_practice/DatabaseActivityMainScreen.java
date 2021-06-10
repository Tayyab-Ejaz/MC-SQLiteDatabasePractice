package com.example.animation_seekbar_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class DatabaseActivityMainScreen extends AppCompatActivity {

    Button ViewPatientRecordButton, AddPatientRecordButton, DeletePatientRecordButton,UpdatePatientRecordButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Remove title and action bars from top*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_database_mainscreen);


        ViewPatientRecordButton = findViewById(R.id.ViewPatientRecordButton);
        AddPatientRecordButton = findViewById(R.id.AddPatientRecordButton);
        DeletePatientRecordButton = findViewById(R.id.DeletePatientRecordButton);
        UpdatePatientRecordButton = findViewById(R.id.UpdatePatientRecordButton);


        ViewPatientRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewRecordIntent= new Intent(getApplicationContext(),DatabaseActivityViewRecord.class);
                startActivity(ViewRecordIntent);
            }
        });

        AddPatientRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent ViewRecordIntent= new Intent(getApplicationContext(),DatabaseActivityAddRecord.class);
                startActivity(ViewRecordIntent);
            }
        });

        DeletePatientRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent ViewRecordIntent= new Intent(getApplicationContext(),DatabaseActivityDeleteRecord.class);
                startActivity(ViewRecordIntent);
            }
        });

    }
}