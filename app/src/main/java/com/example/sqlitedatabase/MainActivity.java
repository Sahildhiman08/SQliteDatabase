package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR ,age INT(3), id INTEGER PRIMARY KEY )");

            //myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('nick' ,25)");
            //myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('Sam' ,15)");
            //myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('Sam' ,23)");

            //How to delete particular user from database
            myDatabase.execSQL("DELETE FROM newUsers WHERE id = 3");

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 18 AND name = 'Sam' ", null);

            //finds a name starts with n
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'n%' ", null);

            //finds a name which have a in it
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1", null);

            //How to delete user from database
            //myDatabase.execSQL("DELETE FROM users WHERE name = 'sam'");

            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers ", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while (!c.isAfterLast()) {

                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                Log.i("id", Integer.toString(c.getInt(idIndex)));
                c.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



         /*
        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE,null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4) )");
            myDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Diwali', 2020)");
            myDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Holi', 2020)");
            myDatabase.execSQL("INSERT INTO events (name, year) VALUES ('New Year', 2020)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM events", null);

            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");

            c.moveToFirst();

            while (!c.isAfterLast()){

                Log.i("Results - name", c.getString(nameIndex));
                Log.i("Results  - year", Integer.toString(c.getInt(yearIndex)));

                c.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        } */
    }
}