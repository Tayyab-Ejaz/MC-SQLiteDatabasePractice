package com.example.animation_seekbar_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseActivityDeleteRecord extends AppCompatActivity {

    Button DeleteButton;
    EditText IDField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Remove title and action bars from top*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_database_delete_record);

        DeleteButton= findViewById(R.id.DeleteButton);
        IDField= findViewById(R.id.IDField);

        PatientDBHelper db = new PatientDBHelper(getApplicationContext());

        DeleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(IDField.getText().toString().equals(""))
                {
                    IDField.setError("ID is required to delete record");
                }
                else
                {
                    db.DeletePatient(Integer.parseInt(IDField.getText().toString()));
                    Toast toast= Toast.makeText(getApplicationContext(),"Record Deleted Successfully", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}