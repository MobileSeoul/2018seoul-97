package com.example.ljh.nooooooooooooooo;

import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MakerActivity extends AppCompatActivity {
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_maker);

        List = (ListView)findViewById (R.id.List);

        Resources res = getResources();//res에있는 리소스받아온다

        String[] planets = res.getStringArray(R.array.maker);

        final ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, planets);
        List.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener (){
            public  void onClick(View view)
            {
                onBackPressed ();
            }
        });


    }
}
