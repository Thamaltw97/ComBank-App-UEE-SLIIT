package com.example.combankthamal.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(Context context) {
        super(context, "BankUser.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        sqLiteDatabase.execSQL("CREATE TABLE USER (LOGINID TEXT," +
                "                                   PASSWORD TEXT," +
                "                                   CURRENTBALANCE REAL," +
                "                                   AVAILABLEBALANCE REAL," +
                "                                   ACCOUNTNAME TEXT," +
                "                                   ACCOUNTTYPE TEXT," +
                "                                   ACCNUMBER TEXT PRIMARY KEY," +
                "                                   NAME TEXT," +
                "                                   PHONE TEXT," +
                "                                   EMAIL TEXT," +
                "                                   BRANCH TEXT," +
                "                                   ADDRESS TEXT)");

//        sqLiteDatabase.execSQL("CREATE TABLE Member (username text primary key, password text)");


    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
    }

    public boolean insertData(){
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ACCOUNTNAME", "MY ACCOUNT");
        contentValues.put("ACCNUMBER", "*****999999");
        contentValues.put("ACCOUNTTYPE", "SAVINGS ACCOUNT");
        contentValues.put("CURRENTBALANCE", "LKR : 2235.00");
        contentValues.put("AVAILABLEBALANCE", "LKR : 2589.00");
        contentValues.put("NAME", "JAYATISSA DGBU");
        contentValues.put("BRANCH", "KANDY");

        long insert = sq.insert("USER", null, contentValues);

        if(insert==-1)
            return false;
        else
            return true;
    }

    public boolean insertDataForSecondAccount(){
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ACCOUNTNAME", "NEW ACCOUNT");
        contentValues.put("ACCNUMBER", "*****888888");
        contentValues.put("ACCOUNTTYPE", "CURRENT ACCOUNT");
        contentValues.put("CURRENTBALANCE", "LKR : 3954.12");
        contentValues.put("AVAILABLEBALANCE", "LKR : 4500.00");
        contentValues.put("NAME", "JAYATISSA DGBU");
        contentValues.put("BRANCH", "COLOMBO");

        long insert = sq.insert("USER", null, contentValues);

        if(insert==-1)
            return false;
        else
            return true;
    }

    public Cursor getAccountDetails(String accountNumber){
        SQLiteDatabase sq = this.getWritableDatabase();
        Cursor res = sq.rawQuery("SELECT ACCOUNTNAME, ACCNUMBER, ACCOUNTTYPE, CURRENTBALANCE, AVAILABLEBALANCE, NAME, BRANCH FROM USER WHERE ACCNUMBER='" + accountNumber+ "'", null);
        return res;
    }

    public boolean updatData(String newAccName, String accNumber){
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ACCOUNTNAME", newAccName);
        sq.update("USER", contentValues, "ACCNUMBER=?", new String[]{ String.valueOf(accNumber)});
        return true;
    }
    
}
