package com.iamhabib.easypreference;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.iamhabib.easy_preference.EasyPreference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyObject object=new MyObject(409, "Habibur Rahman");

        final TextView value=(TextView)findViewById(R.id.value);

        if(EasyPreference.with(MainActivity.this).getBoolean("B",false)){
            value.setText("B: TRUE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
        }else{
            value.setText("B: FALSE, "+EasyPreference.with(MainActivity.this).getString("S","")+" "+EasyPreference.with(MainActivity.this).getString("SS",""));
        }

        EasyPreference
                .with(MainActivity.this)
                .addBoolean("B", true)
                .addString("S","HABIBUR")
                .addString("SS", "RAHMAN")
                .addObject("O", object)
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyObject object1=EasyPreference.with(MainActivity.this)
                        .getObject("O", MyObject.class);
                value.setText(object1.getId()+" "+object1.getName());
            }
        },40000);
    }

    public class MyObject{
        private int id;
        private String name;

        public MyObject(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
