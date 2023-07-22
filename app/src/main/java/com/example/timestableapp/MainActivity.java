package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        int max = 20;
        seekBar.setMax(max);

        int min = 1;
        generateList(min);

        seekBar.setProgress(min);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    seekBar.setProgress(min);

                } else {
                    timesTableNumber = progress;
                }

                Log.i("message", String.valueOf(timesTableNumber));

                generateList(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

        public void generateList(int timesTableNumber){

            ArrayList<String> arrayList = new ArrayList<>();

            for(int i =1; i<=10; i++){

                arrayList.add(String.valueOf(i * timesTableNumber));

            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

            listView.setAdapter(arrayAdapter);

        }
}