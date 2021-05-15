package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView foot ;

    public void generateTables(int a )
    {
        ArrayList<String> tables = new ArrayList<String>();
        for(int i =1;i<13;i++)
        {
            tables.add(String.valueOf(a*i));
        }

        ArrayAdapter<String> timetable  = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,tables);
        listView.setAdapter(timetable);
        foot.setText("Multiplication Table of "+String.valueOf(a));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstView);
        SeekBar num  = findViewById(R.id.numBar);
        foot = findViewById(R.id.txtFoot);
        Random random = new Random();
        int max =30;
        int inipos = random.nextInt(max);
        num.setMax(max);num.setProgress(inipos);
        generateTables(inipos);
        num.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int timesNum;
                int min  = 1;
                if(progress<min)
                {
                    timesNum = min;
                    num.setProgress(min);
                }else{timesNum = progress;}
                generateTables(timesNum);

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