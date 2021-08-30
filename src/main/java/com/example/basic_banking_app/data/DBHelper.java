package com.example.basic_banking_application.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.basic_banking_application.adapter.RecyclerViewAdapter1;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userhistory.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userhistory(sender TEXT, reciever TEXT, money TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userhistory");
    }

    public void inserthistory(String sender, String reciever, String money)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sender", sender);
        contentValues.put("reciever", reciever);
        contentValues.put("money", money);
        DB.insert("Userhistory", null, contentValues);
        return ;
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userhistory", null);
        return cursor;

    }
}