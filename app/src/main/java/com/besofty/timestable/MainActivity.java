package com.besofty.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTable){

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i=1; i<=10; i++){

            String num = Integer.toString(i);

            String times = num+" * "+timesTable+" = ";

            String content = Integer.toString(i * timesTable );

            timesTableContent.add(times+content);

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTableListView = (ListView) findViewById(R.id.timesTableListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTable;
                if(i<min){
                    timesTable=min;
                    timesTableSeekBar.setProgress(min);
                }else {
                    timesTable=i;
                }

                generateTimesTable(timesTable);

                TextView number = (TextView) findViewById(R.id.number);

                number.setText(Integer.toString(timesTable));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);

    }


    public void timesTableSeekBar(View view){

    }
}
