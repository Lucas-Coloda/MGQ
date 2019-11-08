package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class LeituraActivity extends AppCompatActivity {
    private int[] a = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};
    private int[] b = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6};
    private Button choice1, choice2;
    private ListView history;
    private int pointer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leitura);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        this.history = findViewById(R.id.historyViewList);
        this.choice1 = findViewById(R.id.btnEscolha1);
        this.choice2 = findViewById(R.id.btnEscolha2);
    }

    public void renderNextChoice(View view) {
        long choice = Integer.parseInt(view.getTag().toString(), 10);
        loadListContent();
    }

    public void loadListContent() {
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.list_content, ["asd", "ewew"]);
        //history.setAdapter(adapter);

    }
}