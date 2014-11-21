package com.example.test51;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         //StrictModeを設定 penaltyDeathを取り除く
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
         setContentView(R.layout.activity_main);

         //TextViewを取得
         ImageView test = (ImageView)findViewById(R.id.imageView1);
         //画像のURL
         String urlString="http://54.68.202.192/img/test.jpg";

         try {
             //URLクラス
            URL url = new URL(urlString);
             //入力ストリームを開く
            InputStream istream = url.openStream();

             //画像をDrawableで取得
            Drawable d = Drawable.createFromStream(istream, "webimg");

             //入力ストリームを閉じる
            istream.close();

             //TextViewの背景に表示
            test.setBackgroundDrawable(d);

         } catch (Exception e) {
             System.out.println("nuu: "+e);
         }
     }
}