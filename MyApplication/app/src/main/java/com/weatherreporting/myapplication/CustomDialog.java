package com.weatherreporting.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;


public class CustomDialog {

    private Context uiContext;
    public CustomDialog(Context userContext)
    {
        uiContext = userContext;
    }
    public void CreateDialogYN(String title, String message, DialogInterface.OnClickListener YESlistener, DialogInterface.OnClickListener NOlistener)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(uiContext).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", YESlistener);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", NOlistener);
        alertDialog.show();
    }
    public void CreateDialog(String title, String message, DialogInterface.OnClickListener listener)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(uiContext).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }
}
