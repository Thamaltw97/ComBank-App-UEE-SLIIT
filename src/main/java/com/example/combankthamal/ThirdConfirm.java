package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdConfirm extends AppCompatActivity {

    TextView marquee;
    TextView deb;
    TextView cred;
    TextView Amount;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_confirm);

        marquee=(TextView)findViewById(R.id.marquee);
        marquee.setSelected(true);

        deb=(TextView)findViewById(R.id.debacc);
        cred=(TextView)findViewById(R.id.credacc);
        Amount=(TextView)findViewById(R.id.amount);

        String acc1 =getIntent().getExtras().getString("Deb");
        String acc2 =getIntent().getExtras().getString("Cred");
        String amount =getIntent().getExtras().getString("Amount");

        deb.setText(acc1);
        cred.setText(acc2);
        Amount.setText(amount);


        btn1=(Button)findViewById(R.id.buttonconfirm);
        btn2=(Button)findViewById(R.id.buttonCancel);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdConfirm.this,"Transfer Success",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),FundTransferHome.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ThirdParty.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ThirdConfirm.this, ThirdParty.class);
        startActivity(intent);

    }

}
