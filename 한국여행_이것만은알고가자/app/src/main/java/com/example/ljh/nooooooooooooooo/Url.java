package com.example.ljh.nooooooooooooooo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Switch;

public class Url extends AppCompatActivity {
    WebView Web;
    String We;
    String value;
    Button btnBack,btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_url);
        We = getIntent().getStringExtra("url");

        Web = (WebView)findViewById (R.id.Web);
        btnBack = (Button) findViewById (R.id.btnBack);
        btnBack2 = (Button)findViewById (R.id.btnBack2);
        WebSettings webSettings = Web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Web.setWebViewClient(new WebViewClient ());


        switch(We)
        {
            case "롯데월드":{value = "http://adventure.lotteworld.com/kor/main/index.do";Web.loadUrl (value);break; }
            case "서울여행":{value ="http://korean.visitseoul.net/index" ;Web.loadUrl (value);break; }
            case "한국사진갤러리":{value ="http://korean.visitkorea.or.kr/kor/tt/pr_gallery/new_photo_gallery/main/main.jsp";Web.loadUrl (value);break;  }
            case "대한민국 구석구석":{value = "http://korean.visitkorea.or.kr/kor/bz15/addOn/main/publish/index.jsp";Web.loadUrl (value);break; }
            case "경복궁":{value = "http://www.royalpalace.go.kr/";Web.loadUrl (value);break; }
            case "인천국제공항":{value = "https://www.airport.kr/ap/ko/index.do";Web.loadUrl (value);break; }
            case "김포공항":{value = "http://www.airport.co.kr/gimpo/main.do";Web.loadUrl (value);break; }

            case "Lotte World":{value = "http://adventure.lotteworld.com/kor/main/index.do";Web.loadUrl (value);break; }
            case "Visit Seoul":{value ="http://korean.visitseoul.net/index";Web.loadUrl (value); break; }
            case "Korea Photo Gallery":{value = "http://korean.visitkorea.or.kr/kor/tt/pr_gallery/new_photo_gallery/main/main.jsp";Web.loadUrl (value);break; }
            case "Every corner of Korea":{value = "http://korean.visitkorea.or.kr/kor/bz15/addOn/main/publish/index.jsp";Web.loadUrl (value);break; }
            case "Gyeongbokgung Palace":{value = "http://www.royalpalace.go.kr/";Web.loadUrl (value);break; }
            case "Incheon International Airport":{value = "https://www.airport.kr/ap/ko/index.do";Web.loadUrl (value);break; }
            case "Gimpo International Airport":{value ="http://www.airport.co.kr/gimpo/main.do";Web.loadUrl (value);break;  }

            case "ロッテワールド":{value = "http://adventure.lotteworld.com/kor/main/index.do";Web.loadUrl (value); }
            case "ソウル旅行":{value ="http://korean.visitseoul.net/index";Web.loadUrl (value); }
            case "韓国の写真ギャラリー":{value = "http://korean.visitkorea.or.kr/kor/tt/pr_gallery/new_photo_gallery/main/main.jsp";Web.loadUrl (value);}
            case "大韓民国の隅々":{value ="http://korean.visitkorea.or.kr/kor/bz15/addOn/main/publish/index.jsp";Web.loadUrl (value); }
            case "景福宮":{value = "http://www.royalpalace.go.kr/";Web.loadUrl (value);}
            case "仁川国際空港":{value ="https://www.airport.kr/ap/ko/index.do" ;Web.loadUrl (value);}
            case "金浦空港":{value ="http://www.airport.co.kr/gimpo/main.do";Web.loadUrl (value); }
        }



        btnBack.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Web.goBack ();
            }
        });

        btnBack2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Web.clearView ();
                Web.clearHistory ();
                Web.clearCache (true);
                onBackPressed ();

            }
        });


    }
}
