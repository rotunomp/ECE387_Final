package com.example.nfcreader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "workout_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "machine";
    private static final String COL3 = "reps";
    private static final String COL4 = "weight";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " INT UNSIGNED, " +
                COL4 + " INT UNSIGNED)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String machine, int reps, int weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, machine);
        contentValues.put(COL3, reps);
        contentValues.put(COL4, weight);

        Log.d(TAG, "addData: Adding " + machine + " with " + reps + " reps and a weight of " + weight);

        long result = db.insert(TABLE_NAME, null, contentValues);

        // if the result equals -1 it was unsuccessful
        return result != -1;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getColumn(String column) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT " + column +" FROM " + TABLE_NAME, null);
        return data;
    }
}
