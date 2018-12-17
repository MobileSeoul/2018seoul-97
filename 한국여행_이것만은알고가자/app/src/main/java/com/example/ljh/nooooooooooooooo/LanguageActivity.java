package com.example.ljh.nooooooooooooooo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    ListView SListView;
    String S;
    Integer s;
    Locale ja;
    {
        ja = Locale.JAPAN;
    }
    Locale en;
    {
        en = Locale.ENGLISH;
    }
    Locale ko;
    {
        ko = Locale.KOREAN;
    }

    Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Resources res = getResources();//res에있는 리소스받아온다
        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사

        SListView = (ListView) findViewById(R.id.SListView);

        final ItemActivity Item = new ItemActivity();

        ArrayList<String> SettingItem = new ArrayList<String>();

        SettingItem.add ("한국어");
        SettingItem.add ("日本語");
        SettingItem.add ("ENGLISH");

        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,SettingItem);
        SListView.setAdapter(adapter);

        SListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                finish();
                Intent intent = new Intent(
                        getApplicationContext(),MainActivity.class);
                    switch (position) {
                        case 0:
                            config.locale = ko;
                            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                            break;

                        case 1 :
                            config.locale = ja;
                            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                            break;

                        case 2 :
                            config.locale = en;
                            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                            break;
                    }
                ((MainActivity)MainActivity.CONTEXT).onResume();
                ((SettingActivity)SettingActivity.CONTEXT).onResume();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            }
        });

        FloatingActionButton backbtn = (FloatingActionButton) findViewById (R.id.backbtn);
        backbtn.setOnClickListener (new View.OnClickListener (){
            public  void onClick(View view)
            {
                onBackPressed ();
            }
        });

    }
}