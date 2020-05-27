package com.example.volleyball;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Data {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_TSM = "tsm";

    private static final String DB_NAME = "volleyball_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_MATCH = "scores";
    private static final String MATCH_ROW_TEAM_FIRST = "teamfirst";
    private static final String MATCH_ROW_TEAM_SECOND = "teamsecond";

    private static final String TABLE_ROUND = "round";
    private static final String ROUND_MATCH_ID = "match_id";

    public Data(Context context) {
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertRound(Round round) {
        String query = "INSERT INTO " + TABLE_ROUND + "("
                + ROUND_MATCH_ID + ", "
                + TABLE_ROW_TSM + ") "
                + "VALUES ("
                + "1, "
                + "'" + System.currentTimeMillis() + "');";
        db.execSQL(query);
    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String newTableMatchQuery = "create table "
                    + TABLE_MATCH + " ("
                    + TABLE_ROW_ID + " integer primary key autoincrement not null, "
                    + TABLE_ROW_TSM + " int8 not null)";
            db.execSQL(newTableMatchQuery);

            String newTableRoundQuery = "create table "
                    + TABLE_ROUND + "("
                    + TABLE_ROW_ID + " integer primary key autoincrement not null, "
                    + ROUND_MATCH_ID + " integer not null, "
                    + TABLE_ROW_TSM + " int8 not null)";
            db.execSQL(newTableRoundQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
