package com.example.user.tu20pill_mate.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shusil
 */

public class AlarmReminderDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "medicineReminder.db";

    private static final int DATABASE_VERSION = 1;

    public AlarmReminderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the reminder table
        String SQL_CREATE_ALARM_TABLE = "CREATE TABLE " + AlarmReminderContract.AlarmReminderEntry.TABLE_NAME + " ("
                + AlarmReminderContract.AlarmReminderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_TITLE + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_DATE + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_TIME + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_DIN_NO + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_QUANTITY_NO + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_EXPIRY_DATE + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_INSTRUCTIONS + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.FIRST_NAME + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.SECOND_NAME + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.AGE + "TEXT,"
                + AlarmReminderContract.AlarmReminderEntry.BLOOD_TYPE + "TEXT,"
                + AlarmReminderContract.AlarmReminderEntry.HEIGHT + "TEXT,"
                + AlarmReminderContract.AlarmReminderEntry.WEIGHT + "TEXT,"
                + AlarmReminderContract.AlarmReminderEntry.ALLERGIES + "TEXT,"

                + AlarmReminderContract.AlarmReminderEntry.KEY_DOSAGE_NO + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_DOSAGE_TYPE + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE + " TEXT, "
                + AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE + " TEXT " + " );";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_ALARM_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}