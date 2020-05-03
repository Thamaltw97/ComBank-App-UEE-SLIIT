package com.example.combankthamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ThirdParty extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView txtMarquee;
    Spinner spinner;
    EditText acc;
    EditText Amount;
    Button submit;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party);

        drawer = (DrawerLayout) findViewById(R.id.drawer6);

        txtMarquee=(TextView)findViewById(R.id.marquee);
        spinner=(Spinner) findViewById(R.id.spinnerdebit);
        txtMarquee.setSelected(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<String> Accounts=new ArrayList<>();
        Accounts.add(0,"Select Debit Account");
        Accounts.add("081020236644");
        Accounts.add("045330566678");
        Accounts.add("256489756020");

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Accounts);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getItemAtPosition(i).equals("Select Debit Account")){

                }
                else{
                    String item=adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(adapterView.getContext(),"Selected : "+item,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit=(Button)findViewById(R.id.buttonconfirm);
        acc=(EditText)findViewById(R.id.editText3);
        Amount=(EditText)findViewById(R.id.editText4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String debacc =spinner.getSelectedItem().toString();
                String credacc=acc.getText().toString();
                String amount =Amount.getText().toString();

                if(debacc.equals("Select Debit Account") || debacc.length()==0){
                    openDialog();
                } else if(credacc.equals("Enter Credit Account No") || credacc.length()== 0 ){
                    acc.setError("Enter Credit Account Number");

                }else{
                    Intent intent=new Intent(ThirdParty.this,ThirdConfirm.class);


                    intent.putExtra("Deb",debacc);
                    intent.putExtra("Cred",credacc);
                    intent.putExtra("Amount",amount);
                    startActivity(intent);

                }


            }

            private void openDialog() {
                DialogBox dialogBox=new DialogBox();
                dialogBox.show(getSupportFragmentManager(),"dialog box");

            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if(id == R.id.nav_help){

            Intent intent1 = new Intent(ThirdParty.this, Help.class);
            startActivity(intent1);

        } else if (id == R.id.nav_contactus){

            Intent intent2 = new Intent(ThirdParty.this, ContactUs.class);
            startActivity(intent2);

        }  else if (id == R.id.nav_logout){

            Intent intent3 = new Intent(ThirdParty.this, MainActivity.class);
            startActivity(intent3);
            Toast.makeText(ThirdParty.this, "Logged out", Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_home){

            Intent intent4 = new Intent(ThirdParty.this, HomePage.class);
            startActivity(intent4);


        }  else if (id == R.id.nav_payment){

            Intent intent5 = new Intent(ThirdParty.this, BillHome.class);
            startActivity(intent5);

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Intent intent = new Intent(ThirdParty.this, FundTransferHome.class);
            startActivity(intent);


        }
    }

}
