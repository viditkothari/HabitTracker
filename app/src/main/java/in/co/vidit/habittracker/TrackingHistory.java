/*************************
 * Copyright (c) 2017. This creation of Vidit Kothari (c) cannot be reproduced or modified or resell without prior written consent
 ************************/

package in.co.vidit.habittracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import in.co.vidit.habittracker.data.HabitTrackerContract.HabitsEntry;
import in.co.vidit.habittracker.data.HabitsDBHelper;

public class TrackingHistory extends AppCompatActivity {

    ArrayList<Habit> habits=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_history);
        ((ListView)findViewById(R.id.lv_habit_list)).setAdapter(new HabitArrayAdapter(this,readData()));
    }

    private ArrayList<Habit> readData(){
        HabitsDBHelper mDBHelper = new HabitsDBHelper(this);
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        String[] projection = {
                HabitsEntry._ID,
                HabitsEntry.COL_HABIT,
                HabitsEntry.COL_TIMESTAMP
        };

        // Perform a query on the pets table
        Cursor cursor = db.query(HabitsEntry.TABLE_NAME,projection,null,null,null,null,null);

        try {
            // Figure out the index of each column
            int idColIndex = cursor.getColumnIndex(HabitsEntry._ID);
            int habitColIndex = cursor.getColumnIndex(HabitsEntry.COL_HABIT);
            int timeColIndex = cursor.getColumnIndex(HabitsEntry.COL_TIMESTAMP);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                Log.i("col ID: ","" + cursor.getInt(idColIndex) + " | " + getHabitName(cursor.getInt(habitColIndex)) + " | " + cursor.getString(timeColIndex) );
                habits.add(new Habit(cursor.getInt(idColIndex),getHabitName(cursor.getInt(habitColIndex)),"Jan 77" /*cursor.getString(timeColIndex)*/));
                // Display the values from each column of the current row in the cursor in the TextView
            }
        } finally {
            // Closing the cursor when you're done reading from it. This releases all its resources and makes it invalid.
            cursor.close();
        }
        if(habits==null) {
            habits.add(new Habit(77," hjghj ","Porgo"));
        }
        return habits;
    }
    private String getHabitName(int habitno){
        switch (habitno){
            case 0:return "Water";
            case 1:return "Medicine";
        }
        return "Water";
    }
}