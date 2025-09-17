package com.example.listycitylab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<City> dataList;
    private ListView cityList;
    private ArrayAdapter<City> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cities = {
                "Edmonton", "Vancouver", "Toronto"
        };

        String[] provinces = {"AB", "BC", "ON"};

        dataList = new ArrayList<City>();
        for(int i = 0; i < cities.length; i++){
            dataList.add(new City(cities[i],provinces[i]));
        }
        //dataList.addAll(Arrays.asList(cities));

        cityList = findViewById(R.id.city_list);
        cityAdapter = new CityArrayAdapter(this,dataList);
        cityList.setAdapter(cityAdapter);
    }
}