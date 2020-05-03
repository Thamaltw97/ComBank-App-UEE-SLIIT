package com.example.combankthamal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {

    Button btn4;
    EditText pw;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        btn4 = (Button) findViewById(R.id.button4);
        pw = (EditText) findViewById(R.id.editText);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pw.getText().toString().equals("apple")) {
                    Intent intent = new Intent(Password.this, HomePage.class);
                    startActivity(intent);
                    Toast.makeText(Password.this, "Successfully signed in", Toast.LENGTH_LONG).show();

                } else {
                    counter--;
                    if (counter > 0) {
                        Toast.makeText(Password.this, "Invalid password! " + counter + "attempts left", Toast.LENGTH_LONG).show();
                        pw.setText("");
                    } else if (counter == 0) {
                        btn4.setEnabled(false);
                        Toast.makeText(Password.this, "Exceeded # of attempts. Account blocked", Toast.LENGTH_LONG).show();
                        pw.setText("");
                    }

                }


            }
        });

    }
}
