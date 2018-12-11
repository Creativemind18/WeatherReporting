package com.weatherreporting.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SESA373142 on 11/12/2016.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    private String dbName;

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.dbName = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table userData(_id integer primary key, userName text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);

    }
}
