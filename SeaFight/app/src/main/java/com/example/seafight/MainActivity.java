package com.example.seafight;

import android.app.Activity;
import android.os.Bundle;

//AppCompatActivity -> Activity if we wanna remove action bar
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}