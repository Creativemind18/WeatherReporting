package com.weatherreporting.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;
    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mDB;
    private Spinner langSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameET = (EditText) findViewById(R.id.username);
        passwordET = (EditText) findViewById(R.id.password);
        mMyOpenHelper = new MyOpenHelper(MainActivity.this,"userDB",null,1);
        mDB = mMyOpenHelper.getWritableDatabase();
        getSupportActionBar().hide();

        /*langSpinner = findViewById(R.id.languageSpinner);
        langSpinner.setSelection(0);
        final Activity thisActivity = this;
        langSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String valueSelected = (String)langSpinner.getItemAtPosition(position);
                        Locale locale = new Locale(valueSelected);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });*/
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        startActivity(new Intent(this,MainActivity.class));
    }*/
    private void setAppLocale(String locale)
    {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();

        conf.setLocale(new Locale(locale.toLowerCase()));
        res.updateConfiguration(conf,dm);
        this.setContentView(R.layout.activity_main);
    }
    public void onSigninClick(View view) {
        ContentValues cv = new ContentValues();
        cv.put("userName",usernameET.getText().toString());
        cv.put("password",passwordET.getText().toString());
        long id = mDB.insert("userData",null,cv);
        //Toast.makeText(MainActivity.this, String.valueOf(id),Toast.LENGTH_LONG).show();
        finish();
        Intent homeIntent = new Intent(this,Main2Activity.class);
        startActivity(homeIntent);
    }

    public void onSignupClick(View view) {
        //ReadUserData();
    }

    private int CountUserData() {
        Cursor c = mDB.query("userData",null,null,null,null,null,null);
        /*while(c.moveToNext()){
            Toast.makeText(MainActivity.this,c.getString(1)+"" + c.getString(2),Toast.LENGTH_LONG).show();
        }*/

        return c.getCount();
    }

    public void onEnClick(View view) {
        setAppLocale("en");
    }

    public void onTeClick(View view) {
        setAppLocale("te");
    }

    public void onHiClick(View view) {
        setAppLocale("hi");
    }
}
