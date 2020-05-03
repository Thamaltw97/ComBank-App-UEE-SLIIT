package com.example.combankthamal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ContactUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private DrawerLayout drawer2;
    TextView tv;
//    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

//        home = (Button) findViewById(R.id.btnhome);
        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        drawer2 = (DrawerLayout) findViewById(R.id.drawer2);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer2, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer2.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tv = (TextView) findViewById(R.id.scroll2);
        tv.setSelected(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(ContactUs.this, HomePage.class);
//                startActivity(intent);
//
//            }
//        });


        int id = menuItem.getItemId();

        if (id == R.id.nav_help) {

            Intent intent1 = new Intent(ContactUs.this, Help.class);
            startActivity(intent1);

        }
        else if (id == R.id.nav_home) {

            Intent intent2 = new Intent(ContactUs.this, HomePage.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(ContactUs.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(ContactUs.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_fundtransfer){

            Intent intent4 = new Intent(ContactUs.this, FundTransferHome.class);
            startActivity(intent4);

        }  else if (id == R.id.nav_payment){

            Intent intent5 = new Intent(ContactUs.this, BillHome.class);
            startActivity(intent5);

        }
//            Toast.makeText(ContactUs.this, "Logged out", Toast.LENGTH_LONG).show();

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer2.isDrawerOpen(GravityCompat.START)) {
            drawer2.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(ContactUs.this, HomePage.class);
            startActivity(intent);

        }
    }

}
