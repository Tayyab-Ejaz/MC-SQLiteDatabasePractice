package com.example.animation_seekbar_practice;

public class Patient {
    public int ID;
    public String Name;
    public int Age;

    public Patient(String name, int age) {
        Name = name;
        Age = age;
    }

    public Patient(int ID, String name, int age) {
        this.ID = ID;
        Name = name;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
