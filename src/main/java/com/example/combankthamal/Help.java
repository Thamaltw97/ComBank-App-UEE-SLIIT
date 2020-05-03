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

public class Help extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    private DrawerLayout drawer3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        drawer3 = (DrawerLayout) findViewById(R.id.drawer3);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer3, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer3.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tv = (TextView) findViewById(R.id.scroll3);
        tv.setSelected(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.nav_contactus){

            Intent intent = new Intent(Help.this, ContactUs.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_home) {

            Intent intent2 = new Intent(Help.this, HomePage.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(Help.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(Help.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_fundtransfer){

            Intent intent4 = new Intent(Help.this, FundTransferHome.class);
            startActivity(intent4);

        }  else if (id == R.id.nav_payment){

            Intent intent5 = new Intent(Help.this, BillHome.class);
            startActivity(intent5);

        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer3.isDrawerOpen(GravityCompat.START)) {
            drawer3.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(Help.this, HomePage.class);
            startActivity(intent);

        }
    }

}
