package in.co.vidit.habittracker;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import in.co.vidit.habittracker.Habit;

import java.util.ArrayList;


public class HabitArrayAdapter extends ArrayAdapter<Habit> {

    public HabitArrayAdapter(Context context, ArrayList<Habit> habits){
        super(context,0,habits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.habit_list_item,parent,false);

        Habit habitObject=getItem(position);
        if(habitObject!=null){
            try {
                ((TextView) convertView.findViewById(R.id.habit_slno)).setText(habitObject.getmID());
                ((TextView) convertView.findViewById(R.id.habit_name)).setText(habitObject.getmHabitName());
                ((TextView) convertView.findViewById(R.id.habit_date)).setText(habitObject.getmDateTime());
                if(habitObject.getmHabitName().equalsIgnoreCase("Water"))
                    convertView.findViewById(R.id.ll_habit_item).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWater));
                else
                    convertView.findViewById(R.id.ll_habit_item).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorMedic));
            }
            catch (Exception e){
                Log.e("Exception found: ", "while accessing ID from arralist in ArrayAdapter.");
            }
        }
        return convertView;
    }
}
