package com.example.fitapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StartWorkoutAct extends AppCompatActivity {
    TextView startpage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise, starttext;
    View bgprogress;
    ImageView img, img1;
    RotateAnimation rotate;

    private static final long START_TIME_IN_MILLIS = 4000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    String type;
    int id, cnt, minute;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        type = getIntent().getStringExtra("type");
        id = getIntent().getIntExtra("id", 0);
        cnt = getIntent().getIntExtra("cnt", 0);
        // Импортируем шрифты
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

//        startpage = (TextView) findViewById(R.id.startpage);
//        starttext = (TextView) findViewById(R.id.starttext);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        timerValue = (TextView) findViewById(R.id.timerValue);
//        btnexercise = (TextView) findViewById(R.id.btnexercise);

        img = (ImageView) findViewById(R.id.imgtimer);
        bgprogress = (View) findViewById(R.id.bgprogress);

//        startpage.setTypeface(Vidaloka);
//        btnexercise.setTypeface(MMedium);
        timerValue.setTypeface(MMedium);
//        fitonetitle.setTypeface(MMedium);
        DataBase dbHelp = new DataBase(this);
        SQLiteDatabase db = dbHelp.getWritableDatabase();
        String where = "type" + " LIKE '%" + type + "%'";
        String[] whereArgs = new String[]{where};

        String sqlSelect = "SELECT * FROM train WHERE id=" + id + ";";
        Cursor query = db.rawQuery(sqlSelect, null);
        int i = 0;
        if (query.moveToFirst()){
            do {
                String name = query.getString(query.getColumnIndex("name"));
                String img_n = query.getString(query.getColumnIndex("img"));
                int time = query.getInt(query.getColumnIndex("time"));

                utilFunc func = new utilFunc();
                String desc = func.choosePluralMerge(time, "минута", "минуты", "минут");
                String description = query.getString(query.getColumnIndex("description"));

                ImageView myImg = (ImageView) findViewById(R.id.img);

                int resID = getResources().getIdentifier(img_n, "drawable", getPackageName());

                minute = time;

                fitonetitle.setText(name);
                myImg.setImageResource(resID);
                subintropage.setText(description);
                fitonedesc.setText(desc);
                fitonetitle.setTypeface(MLight);
                fitonedesc.setTypeface(MMedium);
                i++;
            }
            while (query.moveToNext());
        }
        db.close();
        //fitonetitle.setText(Integer.toString(id));

        rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(5000);
        rotate.setRepeatCount((int)(TimeUnit.MINUTES.toMillis(minute)/5000));
        rotate.setInterpolator(new LinearInterpolator());

        bgprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag)
                {
                    startTimer();
                    img.startAnimation(rotate);
                    btnexercise.setText("СЛЕДУЮЩЕЕ УПРАЖНЕНИЕ");
                    bgprogress.setBackgroundColor(Color.parseColor("#25293E"));
                    flag = true;
                } else
                {
                    id++;
                    cnt++;
                    if (cnt == 5)
                    {
                        Intent a = new Intent(StartWorkoutAct.this, EndWorkout.class);
                        countDownTimer.cancel();
                        finish();
                        startActivity(a);
                    }
                    else
                    {
                        Intent a = new Intent(StartWorkoutAct.this,StartWorkoutAct.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        a.putExtra("type", type);
                        a.putExtra("cnt", cnt);
                        a.putExtra("id", id);
                        countDownTimer.cancel();
                        finish();
                        startActivity(a);
                    }

                }

            }
        });
    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", 0, 0);
                timerValue.setText(timeLeft);
                //Toast.makeText(getApplicationContext(), "СТАРТ", Toast.LENGTH_SHORT).show();
                mTimeLeftInMillis = TimeUnit.MINUTES.toMillis(minute) + 1000;
                continueTimer();
            }
        }.start();
        mTimerRunning = true;
    }
    private void continueTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", 0, 0);
                timerValue.setText(timeLeft);
                Toast.makeText(getApplicationContext(), "ПОЗДРАВЛЯЕМ!", Toast.LENGTH_SHORT).show();
                bgprogress.setBackgroundColor(Color.parseColor("#FF8892"));
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    }
}
