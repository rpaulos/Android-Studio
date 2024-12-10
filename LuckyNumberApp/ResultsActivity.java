package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvLuckyNumber = findViewById(R.id.tv_lucky_number);
        Button btnShare = findViewById(R.id.btn_share);
        Button btnBack = findViewById(R.id.btn_back);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int luckyNumber = intent.getIntExtra("luckyNumber", 0);

        tvLuckyNumber.setText(name + " Your lucky number is " + luckyNumber);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, " YOUR LUCKY NUMBER" + luckyNumber);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Your lucky number is " + luckyNumber);

                shareIntent.setPackage("com.google.android.gm");
                startActivity(shareIntent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(ResultActivity.this, MainActivity.class);
                backIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(backIntent);
                startActivity(backIntent);
                finish();
            }
        });
    }
}
