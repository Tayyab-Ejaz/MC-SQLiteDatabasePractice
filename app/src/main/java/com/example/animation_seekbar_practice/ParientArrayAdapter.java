package com.example.animation_seekbar_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ParientArrayAdapter extends BaseAdapter {
    Context context;
    public ArrayList<Patient> PatientList;
    int flags[];
    LayoutInflater inflater;

    public ParientArrayAdapter(Context context, ArrayList<Patient> PatientList, int[] flags) {
        this.context = context;
        this.PatientList = PatientList;
        this.flags = flags;
        this.inflater =  LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return PatientList.size();
    }

    @Override
    public Object getItem(int position) {
        return PatientList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return PatientList.get(position).getID();
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        itemView = inflater.inflate(R.layout.activity_list_item, null);
        TextView IDField =  itemView.findViewById(R.id.IDField);
        TextView Name = itemView.findViewById(R.id.NameField);
        TextView AgeField =  itemView.findViewById(R.id.AgeField);

        Name.setText(PatientList.get(position).getName());
        AgeField.setText(Integer.toString(PatientList.get(position).getAge()));
        IDField.setText(Integer.toString(PatientList.get(position).getID()));

        return itemView;
    }
}
