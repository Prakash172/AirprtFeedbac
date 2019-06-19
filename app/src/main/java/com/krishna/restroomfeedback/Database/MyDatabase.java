package com.krishna.restroomfeedback.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabase {

    private DBHelper dbHelper;

    private SQLiteDatabase database;

    public final static String TABLE="feedback"; // name of table
    public final static String VALUE = "value";

    /**
     *
     * @param context
     */
    public MyDatabase(Context context){
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public long createRecords(int value){
        ContentValues values = new ContentValues();
        values.put(VALUE, value);
        return database.insert(TABLE, null, values);
    }

    public Cursor selectRecords() {
        Cursor mCursor = database.rawQuery("select * from "+TABLE,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }
}
