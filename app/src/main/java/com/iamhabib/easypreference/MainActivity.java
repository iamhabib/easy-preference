package com.iamhabib.easypreference;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.iamhabib.easy_preference.EasyPreference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView value=(TextView)findViewById(R.id.value);

        if(EasyPreference.with(MainActivity.this).getBoolean("B",false)){
            value.setText("B: TRUE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
        }else{
            value.setText("B: FALSE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
        }

        EasyPreference.with(MainActivity.this)
                .addBoolean("B", true)
                .addString("S","HABIBUR")
                .addString("SS", "RAHMAN")
                .save();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(EasyPreference.with(MainActivity.this).getBoolean("B",false)){
                    value.setText("B: TRUE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
                }else{
                    value.setText("B: FALSE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
                }
            }
        },20000);
    }
}
