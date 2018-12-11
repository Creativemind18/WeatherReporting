package com.weatherreporting.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public String loginResult;
    MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMyOpenHelper = new MyOpenHelper(Main2Activity.this, "userDB", null, 1);
        mDB = mMyOpenHelper.getWritableDatabase();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void onSignoutClick(View view) {
        mDB.execSQL("delete from userData where _id=1");
        finish();
        Intent loginActivity = new Intent(this,MainActivity.class);
        startActivity(loginActivity);
    }
}
