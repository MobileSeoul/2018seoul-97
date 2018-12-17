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

public class EtiquetteActivity extends AppCompatActivity {
    ListView EListView;
    String E;
    Integer e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etiquette);

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        EListView = (ListView)findViewById (R.id.EListView);

        final ItemActivity Item = new ItemActivity ();


        Resources Sres = getResources();
        String[] Url = Sres.getStringArray(R.array.Url);
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Url);
        EListView.setAdapter (adapter);


        EListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String W = adapter.getItem (position);
                Intent intent = new Intent (
                        getApplicationContext ( ), Url.class);
                intent.putExtra ("url", W);
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
