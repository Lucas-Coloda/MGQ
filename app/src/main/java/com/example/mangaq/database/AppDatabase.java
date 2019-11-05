package com.example.mangaq.database;

import android.content.ClipData;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mangaq.DAO.UsuarioDAO;
import com.example.mangaq.Model.Usuario;


@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    public abstract UsuarioDAO usuarioDAO();

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"db_mangaq").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
