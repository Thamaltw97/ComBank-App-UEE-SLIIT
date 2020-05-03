package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class mobileConnection extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout dialog;
    private DrawerLayout drawer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_connection);

        btn = (Button)findViewById(R.id.btnBack);

        drawer = (DrawerLayout) findViewById(R.id.drawer9);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dialog = findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mobileConnection.this, "You Have Selected Mobile Connections", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mobileConnection.this,payment.class );
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mobileConnection.this, BillHome.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(mobileConnection.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(mobileConnection.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(mobileConnection.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(mobileConnection.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_home){

            Intent intent4 = new Intent(mobileConnection.this, HomePage.class);
            startActivity(intent4);


        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(mobileConnection.this, BillHome.class);
            startActivity(intent);


        }
    }

}
