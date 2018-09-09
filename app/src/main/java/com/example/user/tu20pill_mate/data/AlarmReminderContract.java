package com.example.user.tu20pill_mate.data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Shusil
 */
public class AlarmReminderContract {

    private AlarmReminderContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.user.tu20pill_mate";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_VEHICLE = "reminder-path";

    public static final class AlarmReminderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_VEHICLE);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VEHICLE;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VEHICLE;

        public final static String TABLE_NAME = "vehicles";

        public final static String TABLE_NAME1 = "reminders";

        public final static String _ID = BaseColumns._ID;

        public static final String KEY_TITLE = "title";
        public static final String KEY_DATE = "date";
        public static final String KEY_TIME = "time";
        public static final String KEY_REPEAT = "repeat";
        public static final String KEY_REPEAT_NO = "repeat_no";
        public static final String KEY_DIN_NO = "din_no";
        public static final String KEY_QUANTITY_NO = "quantity_no";
        public static final String KEY_EXPIRY_DATE = "expiry_date";
        public static final String KEY_INSTRUCTIONS = "instructions";
        public static final String FIRST_NAME = "first_name";
        public static final String SECOND_NAME = "second_name";
        public static final String AGE = "age";
        public static final String ALLERGIES = "allergies";
        public static final String BLOOD_TYPE = "blood_type";
        public static final String WEIGHT = "weight";
        public static final String HEIGHT = "height";


        public static final String KEY_DOSAGE_NO = "dosage_no";
        public static final String KEY_DOSAGE_TYPE = "dosage_type";
        public static final String KEY_REPEAT_TYPE = "repeat_type";
        public static final String KEY_ACTIVE = "active";

    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }
}