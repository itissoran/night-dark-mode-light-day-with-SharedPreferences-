package com.kurdfoxx.nightmodewithsharedprefrense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    Switch mySwitch;
    boolean isDarkMode =false;
    private static final String DARKMODE = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myboolian();
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            isDarkMode =true;

        } else {
            setTheme(R.style.AppTheme);
            isDarkMode =false;


        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toast.makeText(this, ""+ isDarkMode, Toast.LENGTH_SHORT).show();
        mySwitch = findViewById(R.id.switch1);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();

                }
            }
        });


        Button buttonGoMain=findViewById(R.id.btn_go_MainAct);
        buttonGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myboolian();
                startActivity(new Intent(SettingActivity.this,MainActivity.class));

            }
        });


    }

    public void restartApp() {
        Intent intentRestartApp = new Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intentRestartApp);
        finish();

    }
    public void myboolian(){
      //     isDarkMode =!isDarkMode;  //change isDarkMode from false to true by this
        SharedPreferences sharedPreferences =getSharedPreferences(DARKMODE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("ISDARKMODE", isDarkMode);
        editor.apply();


    }

    @Override
    protected void onRestart() {
        myboolian();

        super.onRestart();
    }

    @Override
    protected void onResume() {
        myboolian();

        super.onResume();
    }

    @Override
    protected void onDestroy() {
        myboolian();

        super.onDestroy();
    }

    @Override
    protected void onStart() {        myboolian();

        super.onStart();
    }
    @Override
    protected void onStop() {
        myboolian();
        super.onStop();
    }
}