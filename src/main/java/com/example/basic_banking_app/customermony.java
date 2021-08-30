package com.example.basic_banking_application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.basic_banking_application.adapter.RecyclerViewAdapter;
import com.example.basic_banking_application.adapter.RecyclerViewAdapter1;
import com.example.basic_banking_application.data.MyDbHandler;
import com.example.basic_banking_application.model.Customers;

import java.util.ArrayList;
import java.util.List;

public class customermony extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter1 recyclerViewAdapter1;
    private ArrayList<Customers> customersArrayList;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customermony);

        Intent intent = getIntent();
        String mony = intent.getStringExtra("mony");
        String position = intent.getStringExtra("position");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(customermony.this);
        int id = Integer.parseInt(position)+1;
        db.UpdateCustomersById(id,mony);


        customersArrayList= new ArrayList<>();

        List<Customers> allCustomers = db.getAllCustomers();
        for(Customers customers: allCustomers){
            customersArrayList.add(customers);
        }

        recyclerViewAdapter1 = new RecyclerViewAdapter1(customermony.this, customersArrayList);
        recyclerView.setAdapter(recyclerViewAdapter1);


    }
}