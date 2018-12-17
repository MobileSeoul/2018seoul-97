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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CultureActivity extends AppCompatActivity {
ListView CListView;
String C;
Integer c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture);


        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        CListView = (ListView)findViewById (R.id.CListView);

        final  ItemActivity Item = new ItemActivity ();

        ArrayList<String> CultureItem = new ArrayList<String> ();

        for(int i=0; i<planets.length; i++)
        {
            if(planets[i].charAt (1)=='c') {
                CultureItem.add(planets[i]);
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,CultureItem);
        CListView.setAdapter (adapter);

        CListView.setBackgroundColor (Color.rgb (189,189,189));

        CListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               C=adapter.getItem (position);
               Intent intent = new Intent(
                       getApplicationContext (),ItemActivity.class);
                for(int i=0; i<C.length (); i++)
                {
                    if(C.charAt(i)=='.')
                    {
                        c=i;
                        break;
                    }
                }
               intent.putExtra ("re",C.substring (0,c));
               intent.putExtra ("re2",C);
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
