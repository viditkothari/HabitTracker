package in.co.vidit.habittracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import in.co.vidit.habittracker.data.HabitTrackerContract.HabitsEntry;
import in.co.vidit.habittracker.data.HabitsDBHelper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private HabitsDBHelper mDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new HabitsDBHelper(this);

        // Creating Button-type ArrayList to access the buttons using indexing
        ArrayList<Button> btns=new ArrayList<>(3);
        btns.add((Button)findViewById(R.id.btn_water)); // btn(0)
        btns.add((Button)findViewById(R.id.btn_medic)); // btn(1)
        btns.add((Button)findViewById(R.id.btn_tracker)); // btn(2)

        btns.get(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                insertRow(HabitsEntry.WATER,DateFormat.getDateTimeInstance().format(new Date()));
                Log.v("btn_water clicked!",HabitsEntry.WATER + " | " + DateFormat.getDateTimeInstance().format(new Date()));
            }
        }); // End of 'setOnClickListener' for 'btn_water'

        btns.get(1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                insertRow(HabitsEntry.MEDICINE,DateFormat.getDateTimeInstance().format(new Date()));
                Log.v("btn_medic clicked!",DateFormat.getDateTimeInstance().format(new Date()));
            }
        }); // End of 'setOnClickListener' for 'btn_medic'

        btns.get(2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),TrackingHistory.class));
                Log.v("btn_tracker clicked!"," :) ");
            }
        }); // End of 'setOnClickListener' for 'btn_tracker'

    }

    private void insertRow(int habitName, String timestamp){
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues habit_row=new ContentValues();
        habit_row.put(HabitsEntry.COL_HABIT,habitName);
        habit_row.put(HabitsEntry.COL_TIMESTAMP,timestamp);
        timestamp.getClass();
        long newRowId = db.insert(HabitsEntry.TABLE_NAME, null, habit_row);
        Log.i("Row inserted!", " Returned ID:" + newRowId);
    }
}