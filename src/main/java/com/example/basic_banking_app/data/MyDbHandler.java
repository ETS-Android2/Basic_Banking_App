package com.example.basic_banking_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basic_banking_app.All_Costumers;
import com.example.basic_banking_app.adapter.RecyclerViewAdapter1;
import com.example.basic_banking_app.model.Customers;
import com.example.basic_banking_app.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
                + " TEXT, " + Params.KEY_MONEY + " TEXT, " + Params.KEY_Photo + " TEXT," + Params.KEY_Email + " TEXT"+")";
        Log.d("dbkaushal", "Query being run is : "+ create);
        db.execSQL(create);

    }

    public void addCustomers(Customers customers){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_ID,customers.getId());
        values.put(Params.KEY_NAME, customers.getName());
        values.put(Params.KEY_MONEY, customers.getAmount());
        values.put(Params.KEY_Email,customers.getEmail());
        values.put(Params.KEY_Photo,customers.getphoto());

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("dbkaushal", "Successfully inserted");
        db.close();
    }

    public List<Customers> getAllCustomers(){
        List<Customers> customersList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                Customers customers = new Customers();
                customers.setId(Integer.parseInt(cursor.getString(0)));
                customers.setName(cursor.getString(1));
                customers.setAmount(cursor.getString(2));
                customers.setEmail(cursor.getString(4));
                customers.setphoto(Integer.parseInt(cursor.getString(3)));
                customersList.add(customers);
            }while(cursor.moveToNext());
        }
        return customersList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public int updateCustomers(Customers customers){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_ID, customers.getId());
        values.put(Params.KEY_NAME, customers.getName());
        values.put(Params.KEY_MONEY, customers.getAmount());
        values.put(Params.KEY_Photo,customers.getphoto());
        values.put(Params.KEY_Email,customers.getEmail());
        //Lets update now
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(customers.getId())});
    }

    public int UpdateCustomersById(int id,String money){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_MONEY,money);
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
    }

    public void deleteCustomersById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteCustomers(){
        SQLiteDatabase db = this.getWritableDatabase();
    //    db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(customers.getId())});
        db.delete(Params.TABLE_NAME,null,null);
        db.close();
    }

}