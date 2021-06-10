package com.example.animation_seekbar_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DatabaseActivityAddRecord extends AppCompatActivity {

    EditText NameField;
    EditText AgeField;
    Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Remove title and action bars from top*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_database_add_record);
        PatientDBHelper db= new PatientDBHelper(this);
        NameField = findViewById(R.id.nameField);
        AgeField = findViewById(R.id.ageField);
        AddButton = findViewById(R.id.addButton);


        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(NameField.getText().toString().equals("") )
                {
                    NameField.setError("Name is Required");
                }
                else if (AgeField.getText().toString().equals(""))
                {
                    AgeField.setError("Age is Required");
                }
                else
                {
                    Patient patient=new Patient(NameField.getText().toString(),Integer.parseInt(AgeField.getText().toString()));
                    db.AddPatient(patient);
                    Toast t= Toast.makeText(getApplicationContext(), "Patient Added", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }
}