package com.example.ljh.nooooooooooooooo;

import android.content.Intent;
import android.content.res.Configuration;
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
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {
    ListView LListView;
    String L;
    Integer l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        Resources res = getResources ();
        String[] planets = res.getStringArray (R.array.item);

        LListView = (ListView)findViewById (R.id.LListView);

        final  ItemActivity Item = new ItemActivity ();

        ArrayList<String> LocationITem = new ArrayList<String> ();

        for(int i=0; i<planets.length; i++)
        {
            if(planets[i].charAt (1)=='l'){
                LocationITem.add(planets[i]);
            }
        }


        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,LocationITem);
        LListView.setAdapter (adapter);

        LListView.setBackgroundColor (Color.rgb (178,235,244));

        LListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                L=adapter.getItem (position);
                Intent intent = new Intent(
                        getApplicationContext (),ItemActivity.class);
                for(int i=0; i<L.length (); i++)
                {
                    if(L.charAt(i)=='.')
                    {
                        l=i;
                        break;
                    }
                }

                intent.putExtra ("re",L.substring (0,l));
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
