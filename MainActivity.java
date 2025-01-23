package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<item>();

        itemList.add(new item("Technical Issues", "The app crashes when I try to submit a complaint."));
        itemList.add(new item("Billing Problem", "I was charged twice for the same service."));
        itemList.add(new item("Account Issue", "I cannot log in to my account, even after resetting the password."));
        itemList.add(new item("Customer Support", "It takes too long to get a response from customer support."));
        itemList.add(new item("Payment Failure", "The payment gateway failed during checkout."));
        itemList.add(new item("Feature Request", "I'd like to suggest adding a dark mode feature to the app."));

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

    }
}
