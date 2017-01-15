package in.co.vidit.habittracker.data;

import android.provider.BaseColumns;

public final class HabitTrackerContract {

    private HabitTrackerContract(){
    }
    public static final class HabitsEntry implements BaseColumns{
        // Table definitions CONSTANTS
        public static final String TABLE_NAME="habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COL_HABIT="habitname";
        public static final String COL_TIMESTAMP="timestamp";

        // Other CONSTANTS
        public static final int WATER=0;
        public static final int MEDICINE=1;
    }
}
