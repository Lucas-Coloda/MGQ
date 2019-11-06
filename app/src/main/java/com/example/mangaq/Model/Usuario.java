package com.example.mangaq.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="usuario_id")
    private long ID;
    @ColumnInfo(name="usuario_nome")
    private String nome;
    @ColumnInfo(name="usuario_sobre_nome")
    private String sobrenome;
    @ColumnInfo(name="usuario_nick")
    private String nick;
    @ColumnInfo(name="usuario_login")
    private String login;
    @ColumnInfo(name="usuario_senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, String sobrenome, String nick) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.sobrenome = sobrenome;
        this.nick = nick;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
