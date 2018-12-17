package com.example.ljh.nooooooooooooooo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodActivity extends AppCompatActivity {
    ListView FListView;
    String F;
    Integer f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        FListView = (ListView) findViewById(R.id.FListView);

        final ItemActivity Item = new ItemActivity();

        ArrayList<String> FoodItem = new ArrayList<String>();

        for(int i=0; i<planets.length; i++)//f가 달린 음식항목만 넣는다
        {
            if(planets[i].charAt (1)=='f'){
                FoodItem.add (planets[i]);
            }

        }
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,FoodItem);
        FListView.setAdapter(adapter);
        FListView.setBackgroundColor (Color.rgb (255,224,140));

        FListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                F = adapter.getItem(position);
                Intent intent = new Intent(
                        getApplicationContext(),ItemActivity.class);
                for(int i=0; i<F.length (); i++)
                {
                    if(F.charAt(i)=='.')
                    {
                        f=i;
                        break;
                    }
                }
                intent.putExtra("re" , F.substring (0,f));
                startActivity(intent);//화면전환
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener (){
            public  void onClick(View view)
            {
                onBackPressed ();
            }
        });

    }
}
