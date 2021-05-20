package com.example.basic_banking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.basic_banking_app.adapter.RecyclerViewAdapter;
import com.example.basic_banking_app.data.MyDbHandler;
import com.example.basic_banking_app.model.Customers;

import java.util.ArrayList;
import java.util.List;

public class All_Costumers extends AppCompatActivity {

    ListView listView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private  ArrayList<Customers> customersArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__costumers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(All_Costumers.this);

        // Creating a contact object for the db
        Customers Kaushal = new Customers();
        Kaushal.setId(1);
        Kaushal.setAmount("100000.0");
        Kaushal.setName("Rohit Sharma");
        Kaushal.setEmail("rohit@gmail.com");
        Kaushal.setphoto(R.drawable.pic0);

        // Adding a contact to the db
        db.addCustomers(Kaushal);

        // Creating a contact object for the db
        Customers Kishan = new Customers();
        Kishan.setId(2);
        Kishan.setAmount("100000.0");
        Kishan.setName("Shikhar Dhawan");
        Kishan.setEmail("shikhar@gmail.com");
        Kishan.setphoto(R.drawable.pic1);
        // Adding a contact to the db
        db.addCustomers(Kishan);

        // Creating a contact object for the db
        Customers Kunal = new Customers();
        Kunal.setId(3);
        Kunal.setAmount("100000.0");
        Kunal.setName("Kl Rahul");
        Kunal.setEmail("rahul@gmail.com");
        Kunal.setphoto(R.drawable.pic2);
        // Adding a contact to the db
        db.addCustomers(Kunal);

        // Creating a contact object for the db
        Customers Kaushal1 = new Customers();
        Kaushal1.setId(4);
        Kaushal1.setAmount("100000.0");
        Kaushal1.setEmail("Virat@gmail.com");
        Kaushal1.setName("Virat Kohli");
        Kaushal1.setphoto(R.drawable.pic3);
        // Adding a contact to the db
        db.addCustomers(Kaushal1);

        // Creating a contact object for the db
        Customers Kishan1 = new Customers();
        Kishan1.setId(5);
        Kishan1.setAmount("100000.0");
        Kishan1.setName("Rishabh Pant");
        Kishan1.setEmail("pant@gmail.com");
        Kishan1.setphoto(R.drawable.pic4);
        // Adding a contact to the db
        db.addCustomers(Kishan1);

        // Creating a contact object for the db
        Customers Kunal1 = new Customers();
        Kunal1.setId(6);
        Kunal1.setAmount("100000.0");
        Kunal1.setName("MS Dhoni");
        Kunal1.setEmail("dhoni@gmail.com");
        Kunal1.setphoto(R.drawable.pic5);
        // Adding a contact to the db
        db.addCustomers(Kunal1);

        // Creating a contact object for the db
        Customers Kaushal2 = new Customers();
        Kaushal2.setId(7);
        Kaushal2.setAmount("100000.0");
        Kaushal2.setName("Hardik Pandya");
        Kaushal2.setEmail("hardik@gmail.com");
        Kaushal2.setphoto(R.drawable.pic6);
        // Adding a contact to the db
        db.addCustomers(Kaushal2);

        // Creating a contact object for the db
        Customers Kishan2 = new Customers();
        Kishan2.setId(8);
        Kishan2.setAmount("100000.0");
        Kishan2.setName("Ravindra Jadeja");
        Kishan2.setEmail("jadeja@gmail.com");
        Kishan2.setphoto(R.drawable.pic7);
        // Adding a contact to the db
        db.addCustomers(Kishan2);

        // Creating a contact object for the db
        Customers Kunal2 = new Customers();
        Kunal2.setId(9);
        Kunal2.setAmount("100000.0");
        Kunal2.setName("Ajuvendra Chahal");
        Kunal2.setEmail("chahal@gmail.com");
        Kunal2.setphoto(R.drawable.pic8);
        // Adding a contact to the db
        db.addCustomers(Kunal2);

        // Creating a contact object for the db
        Customers Kaushal3 = new Customers();
        Kaushal3.setId(10);
        Kaushal3.setAmount("100000.0");
        Kaushal3.setName("Bhuvi Kumar");
        Kaushal3.setEmail("bhuvi@gmail.com");
        Kaushal3.setphoto(R.drawable.pic9);
        // Adding a contact to the db
        db.addCustomers(Kaushal3);

        // Creating a contact object for the db
        Customers Kishan3 = new Customers();
        Kishan3.setId(11);
        Kishan3.setAmount("100000.0");
        Kishan3.setName("Jasprit Bumrah");
        Kishan3.setEmail("bumrah@gmail.com");
        Kishan3.setphoto(R.drawable.pic10);
        // Adding a contact to the db
        db.addCustomers(Kishan3);

        // Creating a contact object for the db
        Customers Kunal3 = new Customers();
        Kunal3.setId(12);
        Kunal3.setAmount("100000.0");
        Kunal3.setName("Shuresh Raina");
        Kunal3.setEmail("raina@gmail.com");
        Kunal3.setphoto(R.drawable.pic11);
        // Adding a contact to the db
        db.addCustomers(Kunal3);

        // Creating a contact object for the db
        Customers Kaushal4 = new Customers();
        Kaushal4.setId(13);
        Kaushal4.setAmount("100000.0");
        Kaushal4.setName("Shreyash Iyyar");
        Kaushal4.setEmail("Iyyar@gmail.com");
        Kaushal4.setphoto(R.drawable.pic12);
        // Adding a contact to the db
        db.addCustomers(Kaushal4);

        // Creating a contact object for the db
        Customers Kishan4 = new Customers();
        Kishan4.setId(14);
        Kishan4.setAmount("100000.0");
        Kishan4.setName("Mohammad Shami");
        Kishan4.setEmail("shami@gmail.com");
        Kishan4.setphoto(R.drawable.pic13);
        // Adding a contact to the db
        db.addCustomers(Kishan4);

        // Creating a contact object for the db
        Customers Kunal4 = new Customers();
        Kunal4.setId(15);
        Kunal4.setAmount("100000.0");
        Kunal4.setName("R Ashwin");
        Kunal4.setEmail("ashwin@gmail.com");
        Kunal4.setphoto(R.drawable.pic14);
        // Adding a contact to the db
        db.addCustomers(Kunal4);
/*
        //Update Customers Details
        db.updateCustomers(Kaushal);
        db.updateCustomers(Kishan);
        db.updateCustomers(Kunal);
        db.updateCustomers(Kaushal1);
        db.updateCustomers(Kishan1);
        db.updateCustomers(Kunal1);
        db.updateCustomers(Kaushal2);
        db.updateCustomers(Kishan2);
        db.updateCustomers(Kunal2);
        db.updateCustomers(Kaushal3);
        db.updateCustomers(Kishan3);
        db.updateCustomers(Kunal3);
        db.updateCustomers(Kaushal4);
        db.updateCustomers(Kishan4);
        db.updateCustomers(Kunal4);

   // Delete Costumers Deails
    //    db.deleteCustomersById(0);
        db.deleteCustomersById(1);
        db.deleteCustomersById(2);
        db.deleteCustomersById(3);
        db.deleteCustomersById(101);
        db.deleteCustomersById(102);
        db.deleteCustomersById(103);
 */

  //      db.deleteCustomers();

     //   Log.d("dbkaushal", "Id for Kaushal, Kishan and Kunal are successfully added to the db");

        // Get all contacts

        customersArrayList= new ArrayList<>();

        List<Customers> allCustomers = db.getAllCustomers();
        for(Customers customers: allCustomers){
     //       Log.d("dbkaushal", "\nId: " + customers.getId() + "\n" +
     //               "Name: " + customers.getName() + "\n"+
     //               "Total amount: " + customers.getAmount() + "\n" );

            customersArrayList.add(customers);
        }

 //       Toast.makeText(All_Costumers.this,"Customers Details",Toast.LENGTH_SHORT).show();
      recyclerViewAdapter = new RecyclerViewAdapter(All_Costumers.this, customersArrayList);
       recyclerView.setAdapter(recyclerViewAdapter);

    }
}