package com.example.mlclub;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Dispatcher extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(
                    prefs.getString("lastActivity",LoginActivity.class.getName()));
        } catch(ClassNotFoundException ex) {
            activityClass = LoginActivity.class;
        }

        startActivity(new Intent(this, activityClass));
    }
}
