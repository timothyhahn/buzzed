package net.timothyhahn.Buzzed.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tim on 4/13/14.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String TABLE_NAME = "alarms";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ALARM = "alarm";

    public DatabaseHandler(Context context) {
        super(context, "alarmHandler", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ALARM_TABLE_SQL = "CREATE TABLE" + TABLE_NAME
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_ALARM + " TEXT"  +")";
        db.execSQL(CREATE_ALARM_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
