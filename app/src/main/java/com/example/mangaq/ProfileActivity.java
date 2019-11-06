package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mangaq.Model.Usuario;
import com.example.mangaq.database.AppDatabase;

public class ProfileActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private AppDatabase db;
    private ImageView btnLogout;
    private TextView name, lastname, nick, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Preload configurations
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        db = AppDatabase.getDatabase(getApplicationContext());
        preferences = getSharedPreferences("appPreference", Context.MODE_PRIVATE);

        // Get objects from view xml
        btnLogout = findViewById(R.id.btn_logout);
        name = findViewById(R.id.nome);
        lastname = findViewById(R.id.sobrenome);
        nick = findViewById(R.id.nick);
        email = findViewById(R.id.email);

        // Activate interaction functions
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        loadUserInformations();
    }
    private void loadUserInformations() {
        long user_id = preferences.getLong("id",1);
        Usuario user = db.usuarioDAO().getUserById(user_id);
        name.setText(user.getNome());
        lastname.setText(user.getSobrenome());
        nick.setText(user.getNick());
        email.setText(user.getLogin());
        System.out.println(user.getNome());
        System.out.println(user.getSobrenome());
        System.out.println(user.getNick());
        System.out.println(user.getLogin());
    }
    private void logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        loadLogin();
    }

    private void loadLogin() {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void voltar(View view) {
        Intent intent = new Intent(ProfileActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
