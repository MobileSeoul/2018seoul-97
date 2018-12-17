package com.example.ljh.nooooooooooooooo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    String ChoiceItem;
    int S;
    ImageView ItemImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        ItemImageView = (ImageView)findViewById(R.id.ItemImageView);

        ChoiceItem = getIntent().getStringExtra("re");
        S = getResources().getIdentifier(ChoiceItem,"drawable",getPackageName());//이미지를 이름으로 불러오기위한 작업

        ItemImageView.setImageResource(S);

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener (){
            public  void onClick(View view)
            {
                onBackPressed ();
            }
        });
    }
}
