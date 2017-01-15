package in.co.vidit.habittracker;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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

        ArrayList<TextView> tvs=new ArrayList<>();
        tvs.add((TextView) convertView.findViewById(R.id.habit_slno));
        tvs.add((TextView) convertView.findViewById(R.id.habit_name));
        tvs.add((TextView) convertView.findViewById(R.id.habit_date));

        Habit habitObject=getItem(position);
        int vmID;
        String vmHabitName, vmDateTime;

        if(habitObject!=null){
            vmID=habitObject.getmID();
            vmHabitName=habitObject.getmHabitName();
            vmDateTime=habitObject.getmDateTime();

            tvs.get(0).setText(vmID);
            tvs.get(1).setText(vmHabitName);
            tvs.get(2).setText(vmDateTime);

            Log.i("ID: ",vmID+"");
            Log.i("Name: ",vmHabitName+"");
            Log.i("Date: ",vmDateTime+"");

            if(habitObject.getmHabitName().equalsIgnoreCase("Water"))
                convertView.findViewById(R.id.ll_habit_item).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWater));
            else
                convertView.findViewById(R.id.ll_habit_item).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorMedic));
            }
        /*
            catch (Exception e){
                Log.e("Exception found: ", "while accessing ID from arralist in ArrayAdapter.");
            }*/

        return convertView;
    }
}
