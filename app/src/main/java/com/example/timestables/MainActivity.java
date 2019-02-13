package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;


    public void generatedTimesTable(int timesTablesNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for(int i = 1; i<=10; i++){
            //adds to the number we've picked
            timesTableContent.add(Integer.toString(i*timesTablesNumber));

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);

        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.timesTablesSeekBar);
        listView = findViewById(R.id.listView);

        int max = 20;
        int prog = 10;
        seekBar.setMax(max);
        //the setProgress is our STARTING POINT
        seekBar.setProgress(prog);

        generatedTimesTable(prog);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTablesNumber;

                if (progress < min) {
                    timesTablesNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesTablesNumber = progress;
                }
                Log.i("Seekbar value", Integer.toString(progress));

                generatedTimesTable(timesTablesNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
