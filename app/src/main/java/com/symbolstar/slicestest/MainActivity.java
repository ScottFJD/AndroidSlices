package com.symbolstar.slicestest;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Properties properties = new Properties();
        try {
            InputStream in = getAssets().open("bing.properties");
            properties.load(in);
            in.close();
            Log.e("mainActivity", properties.get("aaa").toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.e("mainActivity", "Exception");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
//        Locale locale1 = new Locale("en", "US");
//        ResourceBundle resb1 = ResourceBundle.getBundle("com.symbolstar.slicestest.Search",locale1);
//        Log.e("MainActivity", resb1.getString("wish"));
////        System.out.println(resb1.getString("aaa"));
    }

}
