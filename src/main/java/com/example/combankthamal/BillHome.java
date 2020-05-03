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

public class BillHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout telephone,electo,water,school,insurance,paytv;
    private Button butmain;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_home);

        drawer = (DrawerLayout) findViewById(R.id.drawer8);

        telephone = findViewById(R.id.telephone);
        butmain = findViewById(R.id.butmain);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BillHome.this, "You Have Selected Mobile Connections", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BillHome.this,mobileConnection.class );
                startActivity(intent);
            }
        });

        butmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BillHome.this, "You Have Selected To History", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BillHome.this,History.class );
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(BillHome.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(BillHome.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(BillHome.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(BillHome.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_home){

            Intent intent4 = new Intent(BillHome.this, HomePage.class);
            startActivity(intent4);


        }  else if (id == R.id.nav_fundtransfer){

            Intent intent5 = new Intent(BillHome.this, FundTransferHome.class);
            startActivity(intent5);

        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(BillHome.this, HomePage.class);
            startActivity(intent);


        }
    }

}
