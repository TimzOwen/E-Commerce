package com.owen.netmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvConsumers = (TextView)findViewById(R.id.tv_Consumer);

        tvConsumers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsumerActivity.class);
                startActivity(intent);
            }
        });

        TextView tvDrivers = (TextView)findViewById(R.id.tv_Driver);

        tvDrivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsumerActivity.class);
                startActivity(intent);
            }
        });
        TextView tvProducts = (TextView)findViewById(R.id.tv_Products);

        tvProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsumerActivity.class);
                startActivity(intent);
            }
        });
        TextView tvFamers = (TextView)findViewById(R.id.tv_Famers);

        tvFamers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsumerActivity.class);
                startActivity(intent);
            }
        });




    }
}
