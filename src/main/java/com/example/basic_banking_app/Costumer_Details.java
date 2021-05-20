package com.example.basic_banking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basic_banking_app.model.Customers;

public class Costumer_Details extends AppCompatActivity {
    public Context context;

    EditText editmoney, enteramount;
    String name;
    String money;
    String email;
    String mo, mon;
    String position;
    String imag;
    Double mo1;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costumer__details);

        Intent intent = getIntent();
        name = intent.getStringExtra("Rname");
        money = intent.getStringExtra("Rmoney");
        email = intent.getStringExtra("email");
        position = intent.getStringExtra("position");
        imag = intent.getStringExtra("image");


        TextView nameTextView = findViewById(R.id.displayname);
        nameTextView.setText(name);

        TextView moneyTextView = findViewById(R.id.displaymoney);
        moneyTextView.setText(money);

        TextView emailTextView = findViewById(R.id.displaymail);
        emailTextView.setText(email);

        ImageView image = findViewById(R.id.img);
        Drawable drawable = this.getResources().getDrawable(Integer.parseInt(imag));
        image.setImageDrawable(drawable);
    }

    public void transmoney(View view) {
        editmoney = findViewById(R.id.transfer_amount);
        mo = editmoney.getText().toString();
        check= true;
       if ( ! mo.isEmpty()) {
          try {
              mo1 = Double.parseDouble(mo);
          }
          catch (Exception e){
              check= false;
              Log.d("dbkaushal", "transmoney: Please enter valid amount to transfer");
              Toast.makeText(this, "Please enter valid amount to transfer..", Toast.LENGTH_LONG).show();
          }
       if(check) {
           if (mo1 >= 0 && mo1 <= Double.parseDouble(money)) {

               money = Double.toString(Double.parseDouble(money) - mo1);
               Toast.makeText(this, "Select any customer to transfer money", Toast.LENGTH_LONG).show();

               Log.d("dbkaushal", "transmoney: money is = " + mo);

               Customers customers = new Customers();
               customers.setNewmoney(mo1);

               Intent intent = new Intent(this, customermony.class);
               intent.putExtra("mony", money);
               intent.putExtra("position", position);
               this.startActivity(intent);
           } else {
               Log.d("dbkaushal", "transmoney: Please enter valid amount to transfer");
               Toast.makeText(this, "Please enter valid amount to transfer..", Toast.LENGTH_LONG).show();
           }
       }
       } else {
           Log.d("dbkaushal", "transmoney: First Enter Amount to transfer");
            Toast.makeText(this, "First Enter Amount to transfer..", Toast.LENGTH_LONG).show();
        }

    }
}