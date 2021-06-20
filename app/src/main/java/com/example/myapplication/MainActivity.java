package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    Animation animimgpage, btnone, btntwo, btnthree, ltr;
    View bgprogres, bgprogresstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase dbHelp = new DataBase(this);
        SQLiteDatabase db = dbHelp.getWritableDatabase();
        dbHelp.close();
        db.close();
        //Загружаем анимацию
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage);
        btnone = AnimationUtils.loadAnimation(this, R.anim.btnone);
        btntwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);
        btnthree = AnimationUtils.loadAnimation(this, R.anim.btnthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);

        //Импортируем шрифты
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        //Импортируем элементы
        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        imgpage = (ImageView) findViewById(R.id.imgpage);
        bgprogres = (View) findViewById(R.id.bgprogress);
        bgprogresstop = (View)findViewById(R.id.bgprogresstop);

        //Применяем к titlepage шрифт
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        //Экспорт анимации
        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(btnone);
        subtitlepage.startAnimation(btnone);

        btnexercise.startAnimation(btnthree);
        bgprogres.startAnimation(btntwo);
        bgprogresstop.startAnimation(ltr);

        btnexercise.setOnClickListener(v -> {
            Intent a = new Intent(MainActivity.this, MainWorkAct.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(a);
        });
    }
}
