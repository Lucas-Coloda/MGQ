package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mangaq.Model.Usuario;
import com.example.mangaq.database.AppDatabase;

public class EditProfileActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private AppDatabase db;
    private Usuario user;
    private EditText nome, sobrenome, nick, email, senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Preload configurations
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.db = AppDatabase.getDatabase(getApplicationContext());
        this.preferences = getSharedPreferences("appPreference", Context.MODE_PRIVATE);
        this.user = new Usuario();
        // Get objects from view xml
        this.nome = findViewById(R.id.ep_edit_nome);
        this.sobrenome = findViewById(R.id.ep_edit_sobrenome);
        this.nick = findViewById(R.id.ep_edit_nick);
        this.email = findViewById(R.id.ep_edit_email);
        this.senha = findViewById(R.id.ep_edit_senha);

        // Load utilities
        this.user.setID(getIntent().getLongExtra("userId", 0));

        loadEditUserForm();
    }

    private void loadEditUserForm() {
        this.user = this.db.usuarioDAO().getUserById(this.user.getID());
        this.nome.setText(this.user.getNome());
        this.sobrenome.setText(this.user.getSobrenome());
        this.email.setText(this.user.getLogin());
        this.nick.setText(this.user.getNick());
        this.senha.setText(this.user.getSenha());
    }

    public void voltar(View view) {
        Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }
    public void salvar(View view) {
        salvarUsuario();
        Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void salvarUsuario() {
        String nome, sobrenome, nick, email, senha;

        nome = this.nome.getText().toString();
        sobrenome = this.sobrenome.getText().toString();
        nick = this.nick.getText().toString();
        email = this.email.getText().toString();
        senha = this.senha.getText().toString();

        this.user.setNome(nome);
        this.user.setSobrenome(sobrenome);
        this.user.setNick(nick);
        this.user.setLogin(email);
        this.user.setSenha(senha);

        this.db.usuarioDAO().update(this.user);
    }
}
