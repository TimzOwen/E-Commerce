package com.owen.netmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsumerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);

        ArrayList<String> consumers = new ArrayList<>();

        consumers.add("Kamau");
        consumers.add("Njoroge");
        consumers.add("Karanja");
        consumers.add("Kimani");
        consumers.add("Njoki");
        consumers.add("Maina");
        consumers.add("omondi");
        consumers.add("Wafula");
        consumers.add("Owen");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,consumers);

        ListView listView = (ListView)findViewById(R.id.list_consumers);

        TextView textView = new TextView(this);

        listView.setAdapter(arrayAdapter);


    }
}
