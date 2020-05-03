package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Submitted extends AppCompatActivity {
    private Button mainbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);

        mainbutton = findViewById(R.id.mainbutton);
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Submitted.this, "Go Back To the Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Submitted.this, BillHome.class );
                startActivity(intent);
            }
        });
    }
}

    