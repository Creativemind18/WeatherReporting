package com.weatherreporting.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Locale;

public class mainEmptyActivity extends AppCompatActivity {
    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent activityIntent;

        mMyOpenHelper = new MyOpenHelper(mainEmptyActivity.this,"userDB",null,1);
        mDB = mMyOpenHelper.getWritableDatabase();
        if(CountUserData() == 0)
        {
            activityIntent = new Intent(this, MainActivity.class);
        } else {
            activityIntent = new Intent(this, Main2Activity.class);
        }

        startActivity(activityIntent);
        finish();
    }

    private int CountUserData() {
        Cursor c = mDB.query("userData",null,null,null,null,null,null);
        /*while(c.moveToNext()){
            Toast.makeText(mainEmptyActivity.this,c.getString(1)+"" + c.getString(2),Toast.LENGTH_LONG).show();
        }*/

        return c.getCount();
    }
}
