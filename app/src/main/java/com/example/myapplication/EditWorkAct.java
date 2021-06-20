package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EditWorkAct extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise;

    Button  btnadd, btnremove, btnadd2, btnremove2, btnadd3, btnremove3,
            btnadd4, btnremove4, btnadd5, btnremove5;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo, fitthree, fitfour, fitfive;

    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven;
    String type;
    Context context = this;


//    int[] img = new int[]{R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5 };
//    int[] title = new int[]{R.id.fitonetitle, R.id.fittwotitle, R.id.fitthreetitle,
//            R.id.fitfourtitle, R.id.fitfivetitle};
//    int[] workvalue = new int[]{R.id.workvalue, R.id.workvalue2, R.id.workvalue3,
//            R.id.workvalue4, R.id.workvalue5};
//    int [] sumworkout = new int[] {0, 0, 0, 0, 0};
//    int [] id = new int[] {0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_work);
//
//        type = getIntent().getStringExtra("type");
//
//        bttone = AnimationUtils.loadAnimation(this, R.anim.btnone);
//        bttwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);
//        bttfour = AnimationUtils.loadAnimation(this, R.anim.btnfour);
//        bttfive = AnimationUtils.loadAnimation(this, R.anim.btnfive);
//        bttsix = AnimationUtils.loadAnimation(this, R.anim.btnsix);
//        bttseven = AnimationUtils.loadAnimation(this, R.anim.btnseven);
//
//        titlepage = findViewById(R.id.titlepage);
//        subtitlepage = findViewById(R.id.subtitlepage);
//
//        fitone = findViewById(R.id.fitone);
//        fittwo = findViewById(R.id.fittwo);
//        fitthree = findViewById(R.id.fitthree);
//        fitfour = findViewById(R.id.fitfour);
//        fitfive = findViewById(R.id.fitfive);
//
//        divpage = findViewById(R.id.divpage);
//        bgprogress = findViewById(R.id.bgprogress);
//
//        titlepage = (TextView) findViewById(R.id.titlepage);
//        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
//
//        btnexercise = (TextView) findViewById(R.id.btnexercise);
//
//        divpage = (View) findViewById(R.id.divpage);
//
//        btnadd = findViewById(R.id.btnadd);
//        btnremove = findViewById(R.id.btnremove);
//        btnadd2 = findViewById(R.id.btnadd2);
//        btnremove2 = findViewById(R.id.btnremove2);
//        btnadd3 = findViewById(R.id.btnadd3);
//        btnremove3 = findViewById(R.id.btnremove3);
//        btnadd4 = findViewById(R.id.btnadd4);
//        btnremove4 = findViewById(R.id.btnremove4);
//        btnadd5 = findViewById(R.id.btnadd5);
//        btnremove5 = findViewById(R.id.btnremove5);
//
//        btnexercise = findViewById(R.id.btnexercise);
//
//        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
//        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");
//
//        DataBase dbHelp = new DataBase(this);
//        SQLiteDatabase db = dbHelp.getWritableDatabase();
//        String where = "type" + " LIKE '%" + type + "%'";
//        String[] whereArgs = new String[]{where};
//
//        String sqlSelect = "SELECT * FROM train WHERE type='" + type + "';";
//        Cursor query = db.rawQuery(sqlSelect, null);
//        int i = 0;
//        if (query.moveToFirst()){
//            do {
//                TextView myView = (TextView) findViewById(title[i]);
//                TextView myDesc = (TextView) findViewById(workvalue[i]);
//                ImageView myImg = (ImageView) findViewById(img[i]);
//
//                String name = query.getString(query.getColumnIndex("name"));
//                String img = query.getString(query.getColumnIndex("img"));
//                String desc = Integer.toString(query.getInt(query.getColumnIndex("time")));
//
//                id[i] = query.getInt(query.getColumnIndex("id"));
//
//                sumworkout[i] = Integer.parseInt(desc);
//
//                int resID = getResources().getIdentifier(img, "drawable", getPackageName());
//
//                myView.setText(name);
//                myImg.setImageResource(resID);
//                myDesc.setText(desc);
//
//                myView.setTypeface(MLight);
//                myDesc.setTypeface(MMedium);
//                i++;
//            }
//            while (query.moveToNext());
//        }
//        db.close();
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumworkout[0]+=1;
//                TextView myView = (TextView) findViewById(workvalue[0]);
//                myView.setText(sumworkout[0]+"");
//            }
//        });
//
//        btnremove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sumworkout[0] <= 0){
//                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sumworkout[0]-=1;
//                    TextView myView = (TextView) findViewById(workvalue[0]);
//                    myView.setText(sumworkout[0]+"");
//                }
//            }
//        });
//
//        btnadd2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumworkout[1]+=1;
//                TextView myView = (TextView) findViewById(workvalue[1]);
//                myView.setText(sumworkout[1]+"");
//            }
//        });
//
//        btnremove2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sumworkout[1] <= 0){
//                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sumworkout[1]-=1;
//                    TextView myView = (TextView) findViewById(workvalue[1]);
//                    myView.setText(sumworkout[1]+"");
//                }
//            }
//        });
//        btnadd3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumworkout[2]+=1;
//                TextView myView = (TextView) findViewById(workvalue[2]);
//                myView.setText(sumworkout[2]+"");
//            }
//        });
//
//        btnremove3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sumworkout[2] <= 0){
//                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sumworkout[2]-=1;
//                    TextView myView = (TextView) findViewById(workvalue[2]);
//                    myView.setText(sumworkout[2]+"");
//                }
//            }
//        });
//        btnadd4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumworkout[3]+=1;
//                TextView myView = (TextView) findViewById(workvalue[3]);
//                myView.setText(sumworkout[3]+"");
//            }
//        });
//
//        btnremove4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sumworkout[3] <= 0){
//                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sumworkout[3]-=1;
//                    TextView myView = (TextView) findViewById(workvalue[3]);
//                    myView.setText(sumworkout[3]+"");
//                }
//            }
//        });
//        btnadd5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumworkout[4]+=1;
//                TextView myView = (TextView) findViewById(workvalue[4]);
//                myView.setText(sumworkout[4]+"");
//            }
//        });
//
//        btnremove5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sumworkout[4] <= 0){
//                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sumworkout[4]-=1;
//                    TextView myView = (TextView) findViewById(workvalue[4]);
//                    myView.setText(sumworkout[4]+"");
//                }
//            }
//        });
//        btnexercise.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DataBase dbHelp = new DataBase(context);
//                SQLiteDatabase db = dbHelp.getWritableDatabase();
//                ContentValues args = new ContentValues();
//                for (int i = 0; i < 5; i++){
//                    String strFilter = "id=" + id[i];
//
//                    args.put("time", sumworkout[i]);
//                    db.update("train", args, strFilter, null);
//                }
//                db.close();
//                Intent a = new Intent(EditWorkAct.this,WorkoutAct.class);
//                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                a.putExtra("type", type);
//                startActivity(a);
//            }
//        });
//
//        titlepage.startAnimation(bttone);
//        subtitlepage.startAnimation(bttone);
//        divpage.startAnimation(bttone);
//
//        fitone.startAnimation(bttwo);
//        fittwo.startAnimation(bttfour);
//        fitthree.startAnimation(bttfive);
//        fitfour.startAnimation(bttsix);
//        fitfive.startAnimation(bttseven);
//
//        btnexercise.startAnimation(bttfive);
//        bgprogress.startAnimation(bttfive);
    }
}

