package com.example.combankthamal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.combankthamal.Database.DatabaseHelper;

public class Account_selection extends AppCompatActivity {

    public static int create_again = 1;

    RelativeLayout relativeLayout1, relativeLayout2;
    ImageView userDetailsImage, hamButton;
    private DrawerLayout mDrawerLayout;
    LinearLayout home, signin, epassBook;
    TextView movingText, acc_name1, acc_no1, acc_type1, acc_balance1;
    TextView acc_name2, acc_no2, acc_type2, acc_balance2;
    public static DatabaseHelper userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_selection);


        relativeLayout1 = findViewById(R.id.relative1);
        relativeLayout2 = findViewById(R.id.relative2);
        userDetailsImage = findViewById(R.id.userDetailsIcon);
        hamButton = findViewById(R.id.hamBtnImg);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.epassBook_drawer);
        home = findViewById(R.id.homeNav);
        signin = findViewById(R.id.signinNav);
        epassBook = findViewById(R.id.epassBookNav);
        movingText = findViewById(R.id.scrollAccountSelection);
        movingText.setSelected(true);

        acc_name1 = findViewById(R.id.accname1);
        acc_no1 = findViewById(R.id.accno1);
        acc_type1 = findViewById(R.id.acctype1);
        acc_balance1 = findViewById(R.id.balance1);

        acc_name2 = findViewById(R.id.accname2);
        acc_no2 = findViewById(R.id.accno2);
        acc_type2 = findViewById(R.id.acctype2);
        acc_balance2 = findViewById(R.id.balance2);

        userDB = new DatabaseHelper(this);

        //INSERTING FOE ACC 1

        Cursor res = userDB.getAccountDetails("*****999999");
//        userDB.insertData();

        System.out.println("llll" + create_again);

        if(create_again==1){
            ++create_again;
            System.out.println("llll"  +userDB.insertData());
            System.out.println("llll"  +userDB.insertDataForSecondAccount());
            System.out.println("lll222" + create_again);

        }

        if(res.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        else {
//            Toast.makeText(this, "DATA added", Toast.LENGTH_SHORT).show();

            while(res.moveToNext()){
//                Toast.makeText(this, "acc name" + res.getString(0), Toast.LENGTH_SHORT).show();
                acc_name1.setText(res.getString(0));
                acc_no1.setText(res.getString(1));
                acc_type1.setText(res.getString(2));
                acc_balance1.setText(res.getString(3));
                System.out.println("llllllll" + res.getString(0));
            }

        }


        //INSERTING FOE ACC 2

        Cursor res2 = userDB.getAccountDetails("*****888888");
//        userDB.insertData();

        System.out.println("llll" + create_again);

        if(create_again==1){
            ++create_again;
            System.out.println("llll"  +userDB.insertData());
            System.out.println("llll"  +userDB.insertDataForSecondAccount());
            System.out.println("lll222" + create_again);

        }

        if(res2.getCount()==0){}

        else {
//            Toast.makeText(this, "DATA added", Toast.LENGTH_SHORT).show();

            while(res2.moveToNext()){
//                Toast.makeText(this, "acc name" + res.getString(0), Toast.LENGTH_SHORT).show();
                acc_name2.setText(res2.getString(0));
                acc_no2.setText(res2.getString(1));
                acc_type2.setText(res2.getString(2));
                acc_balance2.setText(res2.getString(3));
                System.out.println("llllllll" + res2.getString(0));
            }

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
                startActivity(new Intent(Account_selection.this, Account_selection.class));
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
                startActivity(new Intent(Account_selection.this, MainActivity.class));
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
                startActivity(new Intent(Account_selection.this, MainActivity.class));
            }
        });

        hamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        userDetailsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        userDetailsImage.setColorFilter(R.color.colorDark);
                    }
                    @Override
                    public void onFinish() {
                        userDetailsImage.setBackgroundResource(R.color.dgrey);
                    }
                }.start();
                startActivity(new Intent(Account_selection.this, CustomerDetails.class));
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        relativeLayout1.setBackgroundResource(R.color.colorDdark);
                    }
                    @Override
                    public void onFinish() {
                        relativeLayout1.setBackgroundResource(R.color.invisible);
                    }
                }.start();
                startActivity(new Intent(Account_selection.this, Transaction_history.class).putExtra("accno", acc_no1.getText()));
            }
        });

        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                        relativeLayout2.setBackgroundResource(R.color.colorDdark);
                    }
                    @Override
                    public void onFinish() {
                        relativeLayout2.setBackgroundResource(R.color.invisible);
                    }
                }.start();
                startActivity(new Intent(Account_selection.this, Transaction_history.class).putExtra("accno", acc_no2.getText()));
            }
        });





    }
}
