package com.kurdfoxx.nightmodewithsharedprefrense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String DARKMODE = "login";
    boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getData();
        if (isDarkMode){

            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                setTheme(R.style.darkTheme);
                isDarkMode =true;
            } else {
                setTheme(R.style.AppTheme);
                isDarkMode =false;

            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button_go_to_setting_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
            }
        });

    }
    private void getData() {

        SharedPreferences sharedPreferences = getSharedPreferences(DARKMODE, MODE_PRIVATE);
        isDarkMode = sharedPreferences.getBoolean("ISDARKMODE", false);

    }

    @Override
    protected void onStart() {
        getData();
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        getData();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        getData();
        super.onResume();
    }

    @Override
    protected void onStop() {
        getData();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        getData();
        super.onRestart();
    }

}
