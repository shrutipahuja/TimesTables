package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;


import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> multiples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        SeekBar seekBar = findViewById(R.id.seekBar);

        int maxSeekValue = 20;
        int minSeekValue = 1;
        seekBar.setMax(maxSeekValue);
        seekBar.setMin(minSeekValue);
        seekBar.setProgress(minSeekValue);
        multiples = new ArrayList<>(asList(1,2,3,4,5,6,7,8,9,10));

        final ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, multiples);
        listView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                multiples.clear();
                int maxMultiple = 10;
                for(int j =1; j <= maxMultiple; j++) {
                    multiples.add(i*j);
                    arrayAdapter.notifyDataSetChanged();
                }
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
