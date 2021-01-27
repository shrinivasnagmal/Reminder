package com.komal.recycleviewdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.komal.recycleviewdemo.Adapters.MyAdapter;
import com.komal.recycleviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

//    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listItems=new ArrayList<>();
//
//        for(int i=0;i<=10;i++)
//        {
//            ListItem listItem=new ListItem("Heading"+(i+1),"12-Jan-2021");
//            listItems.add(listItem);
//        }
//
//        adapter=new MyAdapter(listItems,this);

        recyclerView.setAdapter(adapter);

    }
}