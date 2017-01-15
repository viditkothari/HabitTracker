/*************************
 * Copyright (c) 2017. This creation of Vidit Kothari (c) cannot be reproduced or modified or resell without prior written consent
 ************************/

package in.co.vidit.habittracker;

/**
 * Created by viditkothari on 1/15/2017.
 */

public class Habit {
    private int mID;
    private String mHabitName;
    private String mDateTime;

    public Habit(int mID, String mHabitName, String mDateTime) {
        this.mID = mID;
        this.mHabitName = mHabitName;
        this.mDateTime = mDateTime;
    }

    public int getmID() {
        return mID;
    }

    public String getmHabitName() {
        return mHabitName;
    }

    public String getmDateTime() {
        return mDateTime;
    }
}
