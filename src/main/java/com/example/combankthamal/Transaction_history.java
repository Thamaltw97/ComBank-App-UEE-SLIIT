package com.example.combankthamal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.combankthamal.Account_selection.userDB;

public class Transaction_history extends AppCompatActivity {

    ImageView backBtn, editImageBtn;
    TextView editBtn, c_balancead, a_balance, acc_name, acc_no, acc_type, branch;
    TextView movingText;
    String accNoClicked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        TextView dateView=findViewById(R.id.dateViewer);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        dateView.setText(currentDateandTime);

        accNoClicked = getIntent().getStringExtra("accno");

        backBtn = findViewById(R.id.backbtnImg);
        editImageBtn = findViewById(R.id.editImage);
        editBtn = findViewById(R.id.editTextView);
        movingText = findViewById(R.id.scrollTransactionHistory);
        movingText.setSelected(true);

        c_balancead = findViewById(R.id.cbalancead);
        a_balance = findViewById(R.id.abalancead);
        acc_name = findViewById(R.id.accnamead);
        acc_no = findViewById(R.id.accnoad);
        acc_type = findViewById(R.id.acctypead);
        branch = findViewById(R.id.branchad);


        Cursor res = userDB.getAccountDetails(accNoClicked);

        if(res.getCount()==0){}
//            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        else {
//            Toast.makeText(this, "DATA added", Toast.LENGTH_SHORT).show();

            while(res.moveToNext()){
//                Toast.makeText(this, "acc name" + res.getString(0), Toast.LENGTH_SHORT).show();
                c_balancead.setText(res.getString(3));
                a_balance.setText(res.getString(4));
                acc_name.setText(res.getString(5));
                acc_no.setText(res.getString(1));
                acc_type.setText(res.getString(2));
                branch.setText(res.getString(6));

                System.out.println("llllllll" + res.getString(0));
            }

        }



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Transaction_history.this, Account_selection.class));
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        editBtn.setBackgroundResource(R.color.dgrey);
                    }
                    @Override
                    public void onFinish() {
                        editBtn.setBackgroundResource(R.color.invisible);
                    }
                }.start();
                startActivity(new Intent(Transaction_history.this, EditAccountDetails.class).putExtra("accno", accNoClicked));
            }
        });

        editImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        editImageBtn.setBackgroundResource(R.color.dgrey);
                    }
                    @Override
                    public void onFinish() {
                        editImageBtn.setBackgroundResource(R.color.invisible);
                    }
                }.start();
                startActivity(new Intent(Transaction_history.this, EditAccountDetails.class).putExtra("accno", accNoClicked));
            }
        });

    }
}
