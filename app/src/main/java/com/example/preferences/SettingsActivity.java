package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mConstraintLayout = findViewById(R.id.settingsLayout);

        TextView textView = findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
        String color = sharedPreferences.getString("colorSetting", "RED");


        textView.setText(color);

        if(color.compareToIgnoreCase("red") == 0){
            mConstraintLayout.setBackgroundColor(Color.RED);
        }if(color.compareToIgnoreCase ("blue")==0){
            mConstraintLayout.setBackgroundColor(Color.BLUE);
        }if(color.compareToIgnoreCase("green") == 0){
            mConstraintLayout.setBackgroundColor(Color.GREEN);
        }

        Button save = findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editTextColor);
                String color = editText.getText().toString();

                SharedPreferences settingsPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
                SharedPreferences.Editor editor =  settingsPreferences.edit();
                editor.putString("colorSetting", color);
                editor.commit();
                if(color.compareToIgnoreCase("red") == 0){
                    mConstraintLayout.setBackgroundColor(Color.RED);
                }if(color.compareToIgnoreCase ("blue")==0){
                    mConstraintLayout.setBackgroundColor(Color.BLUE);
                }
                Toast.makeText(SettingsActivity.this, "color setting saved", Toast.LENGTH_LONG).show();
            }
        });
    }

}