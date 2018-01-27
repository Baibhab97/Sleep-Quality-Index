package com.example.baibhab.sleep1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BAIBHAB on 6/9/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sleep.db";
    public static final String TABLE_NAME = "sleep_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATE_TIME";
    public static final String COL_3 = "q1";
    public static final String COL_4 = "q2";
    public static final String COL_5 = "q3";
    public static final String COL_6 = "q4";
    public static final String COL_7 = "q5a";
    public static final String COL_8 = "q5b";
    public static final String COL_9 = "q5c";
    public static final String COL_10 = "q5d";
    public static final String COL_11 = "q5e";
    public static final String COL_12 = "q5f";
    public static final String COL_13 = "q5g";
    public static final String COL_14 = "q5h";
    public static final String COL_15 = "q5i";
    public static final String COL_16 = "q5j";
    public static final String COL_17 = "q6";
    public static final String COL_18 = "q7";
    public static final String COL_19 = "q8";
    public static final String COL_20 = "q9";
    public static final String COL_21 = "DATE";
    public static final String COL_22 = "RATING";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE_TIME DATETIME,q1 TEXT,q2 TEXT,q3 TEXT,q4 TEXT,q5a TEXT,q5b TEXT,q5c TEXT,q5d TEXT,q5e TEXT, q5f TEXT,q5g TEXT,q5h TEXT,q5i TEXT,q5j TEXT,q6 TEXT,q7 TEXT,q8 TEXT,q9 TEXT,DATE TEXT,RATING REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public long insertData_date(String date, float rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_21,date);
        values.put(COL_22,rating);
        long result = db.insert(TABLE_NAME, null, values);
        return result;
    }

    public boolean update_screen1(String q1Answer, String q2Answer, String q3Answer, String q4Answer,long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "id=?";
        String[] whereArgs = new String[] {Long.toString(id)};
        ContentValues values = new ContentValues();
        values.put(COL_2,getDateTime());
        values.put(COL_3,q1Answer);
        values.put(COL_4,q2Answer);
        values.put(COL_5,q3Answer);
        values.put(COL_6,q4Answer);
        long result = db.update(TABLE_NAME, values, where, whereArgs);
        if(result == -1)
            return false;
        else
            return true;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean update_screen2(String q5aAnswer, String q5bAnswer, String q5cAnswer, String q5dAnswer, String q5eAnswer, String q5fAnswer, String q5gAnswer, String q5hAnswer, String q5iAnswer, String q5jAnswer, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "id=?";
        String[] whereArgs = new String[] {Long.toString(id)};
        ContentValues values = new ContentValues();
        values.put(COL_7,q5aAnswer);
        values.put(COL_8,q5bAnswer);
        values.put(COL_9,q5cAnswer);
        values.put(COL_10,q5dAnswer);
        values.put(COL_11,q5eAnswer);
        values.put(COL_12,q5fAnswer);
        values.put(COL_13,q5gAnswer);
        values.put(COL_14,q5hAnswer);
        values.put(COL_15,q5iAnswer);
        values.put(COL_16,q5jAnswer);
        long result = db.update(TABLE_NAME, values, where, whereArgs);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean update_screen3(String q6Answer, String q7Answer, String q8Answer, String q9Answer, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "id=?";
        String[] whereArgs = new String[] {Long.toString(id)};
        ContentValues values = new ContentValues();
        values.put(COL_17,q6Answer);
        values.put(COL_18,q7Answer);
        values.put(COL_19,q8Answer);
        values.put(COL_20,q9Answer);
        long result = db.update(TABLE_NAME, values, where, whereArgs);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" order by "+COL_21+" desc",null);
        return res;
    }

    public Cursor getSpecificData(String check) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+ " where "+ COL_21 +" = ?",new String[]{check},null);
        return res;
    }

}