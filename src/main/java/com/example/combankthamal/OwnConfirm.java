package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnConfirm extends AppCompatActivity {

    TextView marqueeText;
    TextView acc1;
    TextView acc2;
    TextView Amount;

    Button cancel;
    Button conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_confirm);

        marqueeText =(TextView)findViewById(R.id.marquee);
        marqueeText.setSelected(true);

        acc1=(TextView)findViewById(R.id.debacc);
        acc2=(TextView)findViewById(R.id.credacc);
        Amount=(TextView)findViewById(R.id.amount);

        String deb = getIntent().getExtras().getString("debit");
        String cred=getIntent().getExtras().getString("cred");
        String amount=getIntent().getExtras().getString("amount");

        acc1.setText(deb);
        acc2.setText(cred);
        Amount.setText(amount);

        cancel=(Button)findViewById(R.id.buttonCancel);
        conf=(Button)findViewById(R.id.buttonconfirm);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cance=new Intent(getApplicationContext(),Own.class);
                startActivity(cance);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OwnConfirm.this,"Money Transferred",Toast.LENGTH_SHORT).show();
                Intent nh=new Intent(getApplicationContext(), FundTransferHome.class);
                startActivity(nh);

            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(OwnConfirm.this, Own.class);
        startActivity(intent);

    }

}
