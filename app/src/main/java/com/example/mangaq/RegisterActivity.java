package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mangaq.Model.Usuario;
import com.example.mangaq.database.AppDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText editNome, editLogin, editNick, editSbrenome, editSenha;
    private Button btnCadastrar;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editNome = findViewById(R.id.edit_nome);
        editSbrenome = findViewById(R.id.edit_sobrenome);
        editNick = findViewById(R.id.edit_nick);
        editLogin = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        db = AppDatabase.getDatabase(getApplicationContext());

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
    }

    private void cadastrar() {
        String nome, login, senha, sobrenome, nick;
        nome = editNome.getText().toString().trim();
        login = editLogin.getText().toString().trim();
        senha = editSenha.getText().toString().trim();
        sobrenome = editSbrenome.getText().toString().trim();
        nick = editNick.getText().toString().trim();

        if(nome.isEmpty()){
            editNome.setError("Campo Obrigatório");
            editNome.requestFocus();
            return;
        }
        if(login.isEmpty()){
            editLogin.setError("Campo Obrigatório");
            editLogin.requestFocus();
            return;
        }
        if(senha.isEmpty()){
            editSenha.setError("Campo Obrigatório");
            editSenha.requestFocus();
            return;
        }
        if(nick.isEmpty()){
            editSenha.setError("Campo Obrigatório");
            editSenha.requestFocus();
            return;
        }
        if(sobrenome.isEmpty()){
            editSenha.setError("Campo Obrigatório");
            editSenha.requestFocus();
            return;
        }

        Usuario user = new Usuario(nome,login,senha, nick, sobrenome);

        long ID = db.usuarioDAO().insert(user);

        if(ID > 0){
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            goToLogin();
        }
        else{
            Toast.makeText(this, "Erro ao cadastrar o usuário.", Toast.LENGTH_SHORT).show();
        }
    }


    public void voltar(View view) {
        goToLogin();
    }

    private void goToLogin() {
        Intent logar = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(logar);
        finish();
    }
}
