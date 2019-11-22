package com.kharismarizqii.holiyeay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DestinationAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataRating;
    private ArrayList<Destination> destinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adapter = new DestinationAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();



    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataRating = getResources().getStringArray(R.array.data_rating);

    }

    private void addItem(){
        destinations = new ArrayList<>();

        for(int i=0; i< dataName.length; i++){
            Destination destination = new Destination();
            destination.setDescription(dataDescription[i]);
            destination.setName(dataName[i]);
            destination.setRating(dataRating[i]);
            destinations.add(destination);
        }

        adapter.setDestinations(destinations);
    }

}
