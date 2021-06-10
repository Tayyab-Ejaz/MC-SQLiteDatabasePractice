package com.example.animation_seekbar_practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PatientDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PatientDB";
    private static final String TABLE_NAME="Patient";
    private static final String KEY_ID = "ID";
    private static final String COLUMN_NAME_NAME="Name";
    private static final String COLUMN_NAME_AGE="Age";

    String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_NAME + " TEXT,"
            + COLUMN_NAME_AGE + " INTEGER" + ")";

    public PatientDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PATIENT_TABLE);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // code to add the new contact
    void AddPatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NAME, patient.getName()); // Contact Name
        values.put(COLUMN_NAME_AGE, patient.getAge()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    Boolean DeletePatient(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        // Define 'where' part of query.
        String selection = KEY_ID+ " = ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { Integer.toString(id) };
        db.delete(TABLE_NAME, selection,selectionArgs);
        return true;
    }

    ArrayList<Patient> GetAllPatients()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_NAME,
                null, null,
                null, null,
                null, null);

        if(cursor.moveToFirst())
        {
            ArrayList list= new ArrayList();
            do
            {
                Patient temp= new Patient(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2));
                list.add(temp);
            }while(cursor.moveToNext());
            db.close();
            return list;
        }
        else
        {
            db.close();

            return null;
        }
    }



}
