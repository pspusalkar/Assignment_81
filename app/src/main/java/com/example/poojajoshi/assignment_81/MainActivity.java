package com.example.poojajoshi.assignment_81;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> arrList;
    ArrayAdapter<String> arrayAdapt;
    String[] monthsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] mList = {"January", "February", "March", "April", "May", "June",
                                "July", "August", "Septmber", "October", "November", "December"};
        monthsList = mList;

        list = findViewById(R.id.listView);
        arrList = new ArrayList<>(Arrays.asList(monthsList));
        final ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monthsList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.GRAY);

                // Generate ListView Item using TextView
                return view;

            }
        };
        list.setAdapter(arrayAdapt);
        arrayAdapt.notifyDataSetChanged();

        // Get Assending button handle.
        Button assendingButton = findViewById(R.id.button);
        assendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the Assending Comparator to adapter.
                arrayAdapt.sort(new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return s.compareTo(t1);
                    }
                });
                list.setAdapter(arrayAdapt);
                arrayAdapt.notifyDataSetChanged();
            }
        });

        // Get Descending button handle.
        Button dessendingButton = findViewById(R.id.button2);
        dessendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the Descending Comparator to adapter.
                arrayAdapt.sort(new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return t1.compareTo(s);
                    }
                });
                list.setAdapter(arrayAdapt);
                arrayAdapt.notifyDataSetChanged();
            }
        });
    }
}
