package com.example.ljh.nooooooooooooooo;

import android.content.Context;
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

import javax.xml.transform.Source;

public class SettingActivity extends AppCompatActivity {
    ListView SListView;
    String S;
    Integer s;


    public static Context CONTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        CONTEXT = this;

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        SListView = (ListView) findViewById(R.id.SListView);

        final ItemActivity Item = new ItemActivity();;

        Resources Sres = getResources();
        String[] Splanets = Sres.getStringArray(R.array.settingButton);


        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Splanets);
        SListView.setAdapter(adapter);

        SListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 0 :
                            Intent intent = new Intent(
                                    getApplicationContext(), LanguageActivity.class);
                            startActivity(intent);
                            break;
                    }

            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        SListView = (ListView) findViewById(R.id.SListView);

        final ItemActivity Item = new ItemActivity();


        Resources Sres = getResources();
        String[] Splanets = Sres.getStringArray(R.array.settingButton);


        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Splanets);
        SListView.setAdapter(adapter);

        SListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0 :
                        Intent intent = new Intent(
                                getApplicationContext(), LanguageActivity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(
                                getApplicationContext(), MakerActivity.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(
                                getApplicationContext(), SourceActivity.class);
                        startActivity(intent2);
                        break;

                }

            }
        });

        SListView.setBackgroundColor (Color.rgb (255,167,167));
        FloatingActionButton backbtn = (FloatingActionButton) findViewById (R.id.backbtn);
        backbtn.setOnClickListener (new View.OnClickListener (){
            public  void onClick(View view)
            {
                onBackPressed ();
            }
        });
    }
}
