package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EndWorkout extends AppCompatActivity {
    private Button btnBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_workout);

        btnBack = findViewById(R.id.back_to);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(EndWorkout.this, MainWorkAct.class);
                finish();
                startActivity(a);
            }
        });
    }
}
