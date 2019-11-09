package com.example.mangaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LeituraActivity extends AppCompatActivity {
    private ArrayList<Integer> a = new ArrayList<Integer>();
    private ArrayList<Integer> b = new ArrayList<Integer>();
    private ImageView imageView1, imageView2;
    private Button choice1, choice2;
    private int pointer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leitura);

        this.choice1 = findViewById(R.id.btnEscolha1);
        this.choice2 = findViewById(R.id.btnEscolha2);

        this.choice1.setText("A");
        this.choice2.setText("B");

        this.imageView1 = findViewById(R.id.image1);
        this.imageView2 = findViewById(R.id.image2);

        a.add(R.drawable.a1);
        a.add(R.drawable.a2);
        a.add(R.drawable.a3);
        a.add(R.drawable.a4);
        a.add(R.drawable.a5);
        a.add(R.drawable.a6);
        b.add(R.drawable.b1);
        b.add(R.drawable.b2);
        b.add(R.drawable.b3);
        b.add(R.drawable.b4);
        b.add(R.drawable.b5);
        b.add(R.drawable.b6);
    }

    public void renderNextChoice(View view) {
        TextView editText = findViewById(R.id.makeChoice);
        editText.setVisibility(View.GONE);
        long choice = Integer.parseInt(view.getTag().toString(), 10);
        loadListContent(choice);
    }

    public void loadListContent(long choice) {
        if (this.pointer < 6) {
            if (choice == 1) {
                imageView1.setImageResource(a.get(pointer));
                imageView2.setImageResource(a.get(pointer + 1));
            } else {
                imageView1.setImageResource(b.get(pointer));
                imageView2.setImageResource(b.get(pointer + 1));
            }
            this.pointer += 2;
        }else {
            Toast.makeText(this, "História finalizada", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}