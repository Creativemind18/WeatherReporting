package com.weatherreporting.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class Login extends AsyncTask<String,Void,String> {

    String add_info_url;
    private String Json_String;
    private ProgressDialog progress;
    private Context context;

    public Login(Context mainContext)
    {
        this.context = mainContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        add_info_url = "https://premset.schneider-electric.com:9050/api/users/GetAppVersion";//"http://karthik.test89.com/add_info.php";
    }

    @Override
    protected String doInBackground(String... args) {
        String Address,State,Dist;
        String data = "";

        try {
            URL url = new URL(add_info_url);
            HttpsURLConnection httpURLConnection = (HttpsURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            //httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            /*OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));


            data = URLEncoder.encode("Address", "UTF-8") + "=" + URLEncoder.encode(Address, "UTF-8")+"&"+
                    URLEncoder.encode("Dist", "UTF-8") + "=" + URLEncoder.encode(Dist, "UTF-8")+"&"+
                    URLEncoder.encode("State", "UTF-8") + "=" + URLEncoder.encode(State, "UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            os.close();*/
            InputStream inputStream = httpURLConnection.getInputStream();
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((Json_String = bufferedReader.readLine()) != null) {
                stringBuilder.append(Json_String + "\n");
            }

            bufferedReader.close();
            inputStream.close();
            //httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            //IS.close();
            //httpURLConnection.disconnect();
            //return "One row of data inserted ...";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(final String result) {
        Intent intent=new Intent(context, Main2Activity.class);
        intent.putExtra("sagar",result);
        context.startActivity(intent);
    }
}
