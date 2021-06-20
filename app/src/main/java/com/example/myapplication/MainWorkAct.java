package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainWorkAct extends AppCompatActivity {
    ImageView cardio, power, stretch, yoga;
    TextView titlepage, subtitlepage, intropage, subintropage, cardiotxt,
            powertxt, stretchtxt, yogatxt;
    LinearLayout layout1, layout2;
    View divpage;
    Animation bttone, bttwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work);

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        cardiotxt = (TextView) findViewById(R.id.cardiotxt);
        powertxt = (TextView) findViewById(R.id.powertxt);
        stretchtxt = (TextView) findViewById(R.id.stretchtxt);
        yogatxt = (TextView) findViewById(R.id.yogatxt);

        divpage = (View) findViewById(R.id.divpage);
        layout1 = (LinearLayout) findViewById(R.id.linearLayout);
        layout2 = (LinearLayout) findViewById(R.id.linearLayout1);

        bttone = AnimationUtils.loadAnimation(this, R.anim.btnone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);

        cardio = (ImageView) findViewById(R.id.cardio);
        power = (ImageView) findViewById(R.id.power);
        stretch = (ImageView) findViewById(R.id.stretch);
        yoga = (ImageView) findViewById(R.id.yoga);

        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttwo);
        intropage.startAnimation(bttone);
        subintropage.startAnimation(bttwo);
        divpage.startAnimation(bttone);

        cardiotxt.startAnimation(bttwo);
        powertxt.startAnimation(bttwo);
        stretchtxt.startAnimation(bttwo);
        yogatxt.startAnimation(bttwo);

        cardio.setOnClickListener(v -> {
            Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            a.putExtra("type", "cardio");
            a.putExtra("id", 0);
            startActivity(a);
        });

        power.setOnClickListener(v -> {
            Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            a.putExtra("type", "power");
            a.putExtra("id", 5);
            startActivity(a);
        });

        stretch.setOnClickListener(v -> {
            Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            a.putExtra("type", "stretch");
            a.putExtra("id", 10);
            startActivity(a);
        });

        yoga.setOnClickListener(v -> {
            Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            a.putExtra("type", "yoga");
            a.putExtra("id", 15);
            startActivity(a);
        });
    }
}
