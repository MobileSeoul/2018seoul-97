package com.example.ljh.nooooooooooooooo;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class TrafficActivity extends AppCompatActivity {
    ListView TListView;
    String T;
    Integer t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);

        

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        TListView = (ListView)findViewById (R.id.TListView);

        final ItemActivity Item = new ItemActivity ();

        ArrayList<String> TrafficItem = new ArrayList<String>();

        for(int i=0; i<planets.length; i++)
        {
            if(planets[i].charAt (1)=='t') {
                TrafficItem.add(planets[i]);
            }
        }
        final  ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,TrafficItem);
        TListView.setAdapter (adapter);

        TListView.setBackgroundColor (Color.rgb (206,242,121));



        TListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T=adapter.getItem (position);
                Intent intent = new Intent(
                        getApplicationContext (),ItemActivity.class);
                for(int i=0; i<T.length (); i++)
                {
                    if(T.charAt(i)=='.')
                    {
                        t=i;
                        break;
                    }

                }
                intent.putExtra ("re",T.substring (0,t));
                startActivity (intent);
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
