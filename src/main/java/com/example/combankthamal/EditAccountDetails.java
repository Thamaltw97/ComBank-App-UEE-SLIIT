package com.example.combankthamal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.combankthamal.Account_selection.userDB;

public class EditAccountDetails extends AppCompatActivity {


    ImageView hamButton;
    Button donBtn, backBtm;
    private DrawerLayout mDrawerLayout;
    LinearLayout home, signin, epassBook;
    TextView movingText, changeAccName;
    String accNoClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_details);

        hamButton = findViewById(R.id.backBtneditaccDetails);
        donBtn = findViewById(R.id.doneBtn);
        backBtm = findViewById(R.id.backBtn);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.editAccountDtailsDrawer);
        home = findViewById(R.id.homeNav);
        signin = findViewById(R.id.signinNav);
        epassBook = findViewById(R.id.epassBookNav);
        changeAccName = findViewById(R.id.accountnamechange);

        movingText = findViewById(R.id.scrollEditAccount);
        movingText.setSelected(true);

        accNoClicked = getIntent().getStringExtra("accno");
        System.out.println("ppppp" + accNoClicked);


        Cursor res2 = userDB.getAccountDetails(accNoClicked);

        while(res2.moveToNext()){
            changeAccName.setText(res2.getString(0));
        }



        epassBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        epassBook.setBackgroundResource(R.color.colorDark);
                    }
                    @Override
                    public void onFinish() {
                        epassBook.setBackgroundResource(R.color.colorLight);
                    }
                }.start();
                startActivity(new Intent(EditAccountDetails.this, Account_selection.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        home.setBackgroundResource(R.color.dgrey);
                    }
                    @Override
                    public void onFinish() {
                        home.setBackgroundResource(R.color.grey);
                    }
                }.start();
                startActivity(new Intent(EditAccountDetails.this, MainActivity.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        signin.setBackgroundResource(R.color.ddgrey);
                    }
                    @Override
                    public void onFinish() {
                        signin.setBackgroundResource(R.color.dgrey);
                    }
                }.start();
                startActivity(new Intent(EditAccountDetails.this, MainActivity.class));
            }
        });

        hamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!changeAccName.getText().toString().equalsIgnoreCase("")){
                    userDB.updatData(changeAccName.getText().toString(), accNoClicked);
                    Toast.makeText(EditAccountDetails.this, "ACCOUNT NAME UPDATED!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EditAccountDetails.this, Transaction_history.class).putExtra("accno", accNoClicked));
                }else
                    Toast.makeText(EditAccountDetails.this, "Insert Account Name to Update!", Toast.LENGTH_SHORT).show();

            }
        });

        backBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditAccountDetails.this, Transaction_history.class).putExtra("accno", accNoClicked));
            }
        });
    }
}
