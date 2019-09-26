package com.owen.earthquakeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvvShow;

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String strJsonSample = " {  { \"Imports\" : [  { \"Cars\": \"BMW\"," +
                " \"Price\": \"500200\"}," +
                "\"Engine\": \"4-hourse\"]}}";

        try
        {
            JSONObject jsonObject = new JSONObject(strJsonSample);

            JSONArray jsonArray = jsonObject.getJSONArray("Imports");

            JSONObject jsonOne = jsonArray.getJSONObject(0);

            String bestCar = jsonOne.getString("Cars");

            int price = Integer.parseInt(jsonObject.optString("price").toString());

            float salary = Float.parseFloat(jsonObject.optString("Salary").toString());


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        ArrayList<String> earthQuake = new ArrayList<>();

        earthQuake.add("Nakuru");
        earthQuake.add("Eldoret");
        earthQuake.add("Embu");
        earthQuake.add("Merru");
        earthQuake.add("Kirinyaga");
        earthQuake.add("Bomet");
        earthQuake.add("Sotik");
        earthQuake.add("Bondo");
        earthQuake.add("Nakuru");
        earthQuake.add("Eldoret");
        earthQuake.add("Embu");
        earthQuake.add("Merru");
        earthQuake.add("Kirinyaga");
        earthQuake.add("Bomet");
        earthQuake.add("Sotik");
        earthQuake.add("Bondo");

        ListView listViewEarthQuakes = (ListView) findViewById(R.id.list_EarthQuake);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, earthQuake);

        listViewEarthQuakes.setAdapter(arrayAdapter);


    }
}
