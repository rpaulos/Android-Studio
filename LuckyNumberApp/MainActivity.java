package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etName = findViewById(R.id.et_name);
        Button btnGenerate = findViewById(R.id.btn_generate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();

                if (!name.isEmpty()) {
                    Random random = new Random();
                    int luckyNumber = random.nextInt(100) + 1;

                    Intent explicitIntent = new Intent(MainActivity.this, ResultActivity.class);
                    explicitIntent.putExtra("name", name);
                    explicitIntent.putExtra("luckyNumber", luckyNumber);
                    startActivity(explicitIntent);
                } else {
                    etName.setError("Please enter your name");
                }
            }
        });


    }
}