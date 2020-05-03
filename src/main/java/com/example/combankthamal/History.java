package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class History extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        drawer = (DrawerLayout) findViewById(R.id.drawer11);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(History.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(History.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(History.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(History.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_home){

            Intent intent4 = new Intent(History.this, HomePage.class);
            startActivity(intent4);


        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(History.this, BillHome.class);
            startActivity(intent);


        }
    }

}
