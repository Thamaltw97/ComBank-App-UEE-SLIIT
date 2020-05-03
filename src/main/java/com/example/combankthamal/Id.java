package com.example.combankthamal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Id extends AppCompatActivity {

    Button btn3;
    EditText id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        btn3 = (Button)findViewById(R.id.button3);
        id = (EditText)findViewById(R.id.editText);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(id.getText().toString().equals("thamal")){

                Intent intent = new Intent(Id.this, Password.class);
                startActivity(intent);
                } else {
                    Toast.makeText(Id.this, "Invalid Username. Try again !", Toast.LENGTH_LONG).show();
                    id.setText("");
                }

            }
        });

    }
}
