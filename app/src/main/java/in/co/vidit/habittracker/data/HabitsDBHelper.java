/*************************
 * Copyright (c) 2017. This creation of Vidit Kothari (c) cannot be reproduced or modified or resell without prior written consent
 ************************/

package in.co.vidit.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import in.co.vidit.habittracker.data.HabitTrackerContract.HabitsEntry;

/**
 * Created by viditkothari on 1/14/2017.
 */

public class HabitsDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "HabitTracker.db";

    public HabitsDBHelper(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the Habits table
        String SQL_CREATE_HABITS_TABLE =  "CREATE TABLE " + HabitsEntry.TABLE_NAME + " ("
                + HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsEntry.COL_HABIT + " TEXT NOT NULL, "
                + HabitsEntry.COL_TIMESTAMP + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
