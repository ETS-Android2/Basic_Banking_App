package com.example.basic_banking_application.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic_banking_application.Costumer_Details;
import com.example.basic_banking_application.R;
import com.example.basic_banking_application.model.Customers;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public Context context;
    public List<Customers> customersList;

    public RecyclerViewAdapter(Context context, List<Customers> customersList) {
        this.context = context;
        this.customersList = customersList;
    }

    // Where to get the single card as viewholder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    // What will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Customers customers = customersList.get(position);

        holder.customerName.setText(customers.getName());
        holder.amount.setText(customers.getAmount());
        Drawable drawable = context.getResources().getDrawable(customers.getphoto());
        holder.photo.setImageDrawable(drawable);
    }

    // How many items?
    @Override
    public int getItemCount() {
        return customersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView customerName;
        public TextView amount;
        public ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            customerName = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            photo = itemView.findViewById(R.id.photo);
            photo.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //      Log.d("dbkaushal", "Clicked");

            int position = this.getAdapterPosition();
            Customers customers = customersList.get(position);
            String name = customers.getName();
            String money = customers.getAmount();
            String email = customers.getEmail();
            String image = String.valueOf(customers.getphoto());
            String itemno = String.valueOf(position);

            //for history
            Customers customers12 = new Customers();
            customers12.setSender(name);

            Toast.makeText(context," Name: " + name + ", money:" + money, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context,Costumer_Details.class);
            intent.putExtra("Rname", name);
            intent.putExtra("Rmoney", money);
            intent.putExtra("position",itemno);
            intent.putExtra("email",email);
            intent.putExtra("image",image);
            context.startActivity(intent);

        }
    }
}