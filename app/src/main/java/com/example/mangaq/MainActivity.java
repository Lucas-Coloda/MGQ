package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mangaq.Model.Usuario;
import com.example.mangaq.database.AppDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private AppDatabase db;
    private EditText editLogin, editSenha;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        preferences = getSharedPreferences("appPreference", Context.MODE_PRIVATE);

        db = AppDatabase.getDatabase(getApplicationContext());

        btnLogin = findViewById(R.id.btn_login);
        editLogin = findViewById(R.id.edit_login);
        editSenha = findViewById(R.id.edit_senha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        validateUser();
    }

    private void validateUser() {
        boolean loggedIn = preferences.getBoolean("logged", false);
        if (loggedIn) {
            Intent mainMenu = new Intent(MainActivity.this, MainMenuActivity.class);
            startActivity(mainMenu);
            finish();
        }
    }

    private void setLoggedUser(Long id) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("logged", true);
        editor.putLong("id", id);
        editor.commit();
    }

    private void loginUser() {
        String login, senha;
        login = editLogin.getText().toString().trim();
        senha = editSenha.getText().toString().trim();

        if (login.isEmpty()) {
            editLogin.setError("Campo Obrigatório");
            editLogin.requestFocus();
            return;
        }

        if (senha.isEmpty()) {
            editSenha.setError("Campo Obrigatório");
            editSenha.requestFocus();
            return;
        }

        Usuario user = db.usuarioDAO().getUser(login, senha);

        if (user == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "Email ou senha incorretos", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        setLoggedUser(user.getID());
        Intent menu = new Intent(MainActivity.this, MainMenuActivity.class);
        startActivity(menu);
        finish();
    }

    public void registrar(View view) {
        Intent registrar = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registrar);
        finish();
    }
}
