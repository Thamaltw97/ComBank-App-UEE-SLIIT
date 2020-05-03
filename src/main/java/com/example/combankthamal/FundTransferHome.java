package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FundTransferHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btn1;
    Button btn2;
    Button btn3;
    TextView txtMarquee;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_transfers_home);

        drawer = (DrawerLayout) findViewById(R.id.drawer4);


        btn1 = (Button) findViewById(R.id.button2);
        btn2 = (Button) findViewById(R.id.button3);
        btn3 = (Button) findViewById(R.id.button4);
        txtMarquee = (TextView) findViewById(R.id.marquee);

        txtMarquee.setSelected(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent own = new Intent(getApplicationContext(), Own.class);
                startActivity(own);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tparty = new Intent(getApplicationContext(), ThirdParty.class);
                startActivity(tparty);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FundHistory.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(FundTransferHome.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(FundTransferHome.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(FundTransferHome.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(FundTransferHome.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_home){

            Intent intent4 = new Intent(FundTransferHome.this, HomePage.class);
            startActivity(intent4);


        }  else if (id == R.id.nav_payment){

            Intent intent5 = new Intent(FundTransferHome.this, BillHome.class);
            startActivity(intent5);

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(FundTransferHome.this, HomePage.class);
            startActivity(intent);


        }
    }

}
