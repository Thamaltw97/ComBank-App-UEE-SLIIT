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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private DrawerLayout drawer;
    TextView tv, notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        notification = (TextView)findViewById(R.id.textView100);
        notification.setSelected(true);

        tv = (TextView)findViewById(R.id.scroll1);
        tv.setSelected(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(HomePage.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(HomePage.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(HomePage.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_fundtransfer){

            Intent intent4 = new Intent(HomePage.this, FundTransferHome.class);
            startActivity(intent4);

        }  else if (id == R.id.nav_payment){

            Intent intent5 = new Intent(HomePage.this, BillHome.class);
            startActivity(intent5);

        }
//            Toast.makeText(HomePage.this, "Logged out", Toast.LENGTH_LONG).show();

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(HomePage.this, "Logged out", Toast.LENGTH_LONG).show();

        }
    }



}
