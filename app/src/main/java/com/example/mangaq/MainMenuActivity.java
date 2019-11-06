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

import com.example.mangaq.Model.Usuario;
import com.example.mangaq.database.AppDatabase;

public class MainMenuActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private AppDatabase db;
    private Button btnProfile;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Preload configurations
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        db = AppDatabase.getDatabase(getApplicationContext());
        preferences = getSharedPreferences("appPreference", Context.MODE_PRIVATE);

        // Get objects from view xml
        btnProfile = findViewById(R.id.btn_profile);

        // Activate interaction functions
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
            }
        });
    }

    private void goToProfile() {
        Intent intent = new Intent(MainMenuActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void lerHistoria(View view) {
        Intent ler = new Intent(MainMenuActivity.this, LeituraActivity.class);
        startActivity(ler);
    }
}
