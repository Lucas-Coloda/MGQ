package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mangaq.database.AppDatabase;

public class MainMenuActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private AppDatabase db;
    private ImageView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btnLogout = findViewById(R.id.btn_logout);

        db = AppDatabase.getDatabase(getApplicationContext());

        preferences = getSharedPreferences("appPreference", Context.MODE_PRIVATE);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        loadLogin();
    }

    private void loadLogin() {
        Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void lerHistoria(View view) {
        Intent logar = new Intent(MainMenuActivity.this, LeituraActivity.class);
        startActivity(logar);
    }
}
