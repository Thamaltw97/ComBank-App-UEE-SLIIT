package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerDetails extends AppCompatActivity {

    ImageView backBtn;
    TextView movingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        backBtn = findViewById(R.id.backBtneditaccDetails);
        movingText = findViewById(R.id.scrollCustomerDetails);

        movingText.setSelected(true);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerDetails.this, Account_selection.class));
            }
        });
    }
}
