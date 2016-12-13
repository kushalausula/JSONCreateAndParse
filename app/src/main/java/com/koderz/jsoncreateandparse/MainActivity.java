package com.koderz.jsoncreateandparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json = getString(R.string.jsonString);
        parseJsonAndPrint(json);

    }

    private void parseJsonAndPrint(String json) {

        try {
            JSONObject jsonOjMain = new JSONObject(json);

            String greet = jsonOjMain.getString("greet");
            boolean inClass = jsonOjMain.getBoolean("inclass");
            int score = jsonOjMain.getInt("score");

            String test = jsonOjMain.getJSONObject("test").toString();
            JSONObject jsonOBjTest = new JSONObject(test);

            String data = jsonOBjTest.getString("data");
            String imgUrl = jsonOBjTest.getString("imgUrl");


            Log.i("TAG", "parseJsonAndPrint:" + jsonOjMain.getString("greet") + " " + jsonOjMain.getBoolean("inclass") + "  "
                    + data + " " + imgUrl);

            JSONArray jArrayData = new JSONArray();

            jArrayData = jsonOjMain.getJSONArray("data");

            for (int i = 0; i < jArrayData.length(); i++) {

                JSONObject jSubObj = new JSONObject(jArrayData.get(i).toString());

                Log.i("TAG", "parseJsonAndPrint: " + jSubObj.getString("data") + "    " +
                        jSubObj.getString("imgUrl"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
