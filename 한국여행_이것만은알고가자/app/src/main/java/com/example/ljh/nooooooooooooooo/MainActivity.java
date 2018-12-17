package com.example.ljh.nooooooooooooooo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ImageButton Culture, Food, Etiquette, Location, Traffic ,Setting;
    Integer Random,m;
    String M;
    Integer List = 4;

    public static Context CONTEXT;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ClickableViewAccessibility")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CONTEXT = this;

        mListView = (ListView) findViewById(R.id.listview1);
        Culture = (ImageButton) findViewById(R.id.Culture);
        Food = (ImageButton) findViewById(R.id.Food);
        Etiquette = (ImageButton) findViewById(R.id.Etiquette);
        Location = (ImageButton) findViewById(R.id.Location);
        Traffic = (ImageButton) findViewById(R.id.Traffic);
        Setting = (ImageButton) findViewById(R.id.Setting);

        Resources res = getResources();//res에있는 리소스받아온다

        final ArrayList<String> ItemList = new ArrayList<>();//랜덤 Item ArrayList1
        final ArrayList<String> CopiedItemList = new ArrayList<>();//모든 Item ArrayList
        final ArrayList<String> CopiedItemList2 = new ArrayList<>();//모든 Item ArrayList3

        String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사
        String[] planets2 = res.getStringArray(R.array.mainButton);

        for(int i = 0; i<6; i++)    {
            int resID = getResources().getIdentifier("text" + i,
                    "id", "com.example.ljh.nooooooooooooooo");
            ((TextView) findViewById(resID)).setText(planets2[i]);
        }

        for(int i=0; i<planets.length; i++) {
            CopiedItemList.add(planets[i]);//아이템어레이리스트에 배열스트링복사
            CopiedItemList2.add(planets[i]);//아이템어레이리스트에 배열스트링복사
        }

        Collections.shuffle(CopiedItemList);//배열을 랜덤으로 섞는다
        Collections.shuffle(CopiedItemList2);

        for(Random=0; Random<List; Random++) ItemList.add(CopiedItemList2.get(Random));//랜덤초기

        final ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ItemList);
        mListView.setAdapter(adapter);
        mListView.setBackgroundColor (Color.rgb (212   ,244,250));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random = 0;
                for(int j=0; j<List; j++) {
                    adapter.remove(adapter.getItem(j));
                    adapter.add(CopiedItemList2.get(Random));
                    Random++;
                        /*for(int i=0; i<List; i++) {
                            if (adapter.getItem(i) == CopiedItemList2.get(Random)) {
                                adapter.remove(adapter.getItem(i));
                                Random++;
                                adapter.add(CopiedItemList2.get(Random));
                        }
                    }*/
                    Collections.shuffle(CopiedItemList2);//배열을 랜덤으로 섞는다
                }
            }
        });

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(mListView,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {

                            @Override
                            public boolean canDismiss(int position) { return true; }


                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {

                                for (int position : reverseSortedPositions) {

                                    if(Random==CopiedItemList2.size ())
                                    {
                                        Collections.shuffle(CopiedItemList2);//배열을 랜덤으로 섞는다
                                        Random = 0;
                                        adapter.add (CopiedItemList2.get(Random));
                                        Random++;
                                    }
                                    else
                                    {
                                        adapter.add (CopiedItemList2.get(Random));
                                        Random++;
                                    }
                                    adapter.remove(adapter.getItem(position));
                                }

                                adapter.notifyDataSetChanged();
                            }
                        });

        mListView.setOnTouchListener(touchListener);
        mListView.setOnScrollListener(touchListener.makeScrollListener());

            //아이템클릭시 화면전환
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String GetPosition = adapter.getItem(position);//선택한 아이템의 String을 찾아온다
                    M = adapter.getItem(position);

                    Intent intent = new Intent(//화면전환
                            getApplicationContext(), TipActivity.class);
                    for(int i=0; i<M.length (); i++)
                    {
                        if(M.charAt (i)=='.')
                        {
                            m=i;
                            break;
                        }
                    }
                    intent.putExtra ("re",M.substring (0,m));//ItemResult에 있는 값을 다른 Activity
                    startActivity(intent);
                }
            });

            Culture.setOnClickListener(new View.OnClickListener() {//문화버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), CultureActivity.class);
                    startActivity(intent);//화면전환

                }
            });

            Location.setOnClickListener(new View.OnClickListener() {//지역버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), LocationActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Food.setOnClickListener(new View.OnClickListener() {//음식버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), FoodActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Etiquette.setOnClickListener(new View.OnClickListener() {//에티켓 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), EtiquetteActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Traffic.setOnClickListener(new View.OnClickListener() {//교통 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), TrafficActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Setting.setOnClickListener(new View.OnClickListener() {//설정
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), SettingActivity.class);
                    startActivity(intent);//화면전환
                }
            });
        }

        //언어설정 변경시 적용되는 새로운 메소드
        @Override
        public void onResume() {
            super.onResume();

            Resources res = getResources();//res에있는 리소스받아온다

            final ArrayList<String> ItemList = new ArrayList<>();//랜덤 Item ArrayList1
            final ArrayList<String> CopiedItemList = new ArrayList<>();//모든 Item ArrayList
            final ArrayList<String> CopiedItemList2 = new ArrayList<>();//모든 Item ArrayList3

            String[] planets = res.getStringArray(R.array.item);//배열에다가 스트링리소스파일복사
            String[] planets2 = res.getStringArray(R.array.mainButton);

            for(int i = 0; i<6; i++)    {
                int resID = getResources().getIdentifier("text" + i,
                        "id", "com.example.ljh.nooooooooooooooo");
                ((TextView) findViewById(resID)).setText(planets2[i]);
            }

            for(int i=0; i<planets.length; i++) {
                CopiedItemList.add(planets[i]);//아이템어레이리스트에 배열스트링복사
                CopiedItemList2.add(planets[i]);//아이템어레이리스트에 배열스트링복사
            }

            Collections.shuffle(CopiedItemList);//배열을 랜덤으로 섞는다
            Collections.shuffle(CopiedItemList2);

            for(Random=0; Random<List; Random++) ItemList.add(CopiedItemList2.get(Random));//랜덤초기

            final ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ItemList);
            mListView.setAdapter(adapter);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Random = 0;
                    for(int j=0; j<List; j++) {
                        adapter.remove(adapter.getItem(j));
                        adapter.add(CopiedItemList2.get(Random));
                        Random++;
                        /*for(int i=0; i<List; i++) {
                            if (adapter.getItem(i) == CopiedItemList2.get(Random)) {
                                adapter.remove(adapter.getItem(i));
                                Random++;
                                adapter.add(CopiedItemList2.get(Random));
                        }
                    }*/
                        Collections.shuffle(CopiedItemList2);//배열을 랜덤으로 섞는다
                    }
                }
            });

            SwipeDismissListViewTouchListener touchListener =
                    new SwipeDismissListViewTouchListener(mListView,
                            new SwipeDismissListViewTouchListener.DismissCallbacks() {

                                @Override
                                public boolean canDismiss(int position) { return true; }


                                @Override
                                public void onDismiss(ListView listView, int[] reverseSortedPositions) {

                                    for (int position : reverseSortedPositions) {

                                        if(Random==CopiedItemList2.size ())
                                        {
                                            Collections.shuffle(CopiedItemList2);//배열을 랜덤으로 섞는다
                                            Random = 0;
                                            adapter.add (CopiedItemList2.get(Random));
                                            Random++;
                                        }
                                        else
                                        {
                                            adapter.add (CopiedItemList2.get(Random));
                                            Random++;
                                        }
                                        adapter.remove(adapter.getItem(position));
                                    }

                                    adapter.notifyDataSetChanged();
                                }
                            });

            mListView.setOnTouchListener(touchListener);
            mListView.setOnScrollListener(touchListener.makeScrollListener());

            //아이템클릭시 화면전환
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String GetPosition = adapter.getItem(position);//선택한 아이템의 String을 찾아온다
                    M = adapter.getItem(position);

                    Intent intent = new Intent(//화면전환
                            getApplicationContext(), TipActivity.class);
                    for(int i=0; i<M.length (); i++)
                    {
                        if(M.charAt (i)=='.')
                        {
                            m=i;
                            break;
                        }
                    }
                    intent.putExtra ("re",M.substring (0,m));//ItemResult에 있는 값을 다른 Activity
                    startActivity(intent);
                }
            });

            Culture.setOnClickListener(new View.OnClickListener() {//문화버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), CultureActivity.class);
                    startActivity(intent);//화면전환

                }
            });

            Location.setOnClickListener(new View.OnClickListener() {//지역버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), LocationActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Food.setOnClickListener(new View.OnClickListener() {//음식버튼 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), FoodActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Etiquette.setOnClickListener(new View.OnClickListener() {//에티켓 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), EtiquetteActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Traffic.setOnClickListener(new View.OnClickListener() {//교통 클릭시
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), TrafficActivity.class);
                    startActivity(intent);//화면전환
                }
            });

            Setting.setOnClickListener(new View.OnClickListener() {//설정
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), SettingActivity.class);
                    startActivity(intent);//화면전환
                }
            });
        }
    }