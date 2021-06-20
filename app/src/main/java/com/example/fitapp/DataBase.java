package com.example.fitapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private final Context fContext;
    public DataBase(Context context)
    {
        super(context, "db", null, 1);
        fContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table train (id INTEGER, name TEXT, description TEXT, time INTEGER, img TEXT, type TEXT);");
        ContentValues values = new ContentValues();
        Resources res = fContext.getResources();
        String[] names = res.getStringArray(R.array.name);
        String[] imgs = res.getStringArray(R.array.img);
        String[] desc = res.getStringArray(R.array.desc);
        int length = names.length;
        for (int i = 0; i < length; i++) {
            String type = imgs[i].substring(0, imgs[i].length() - 1);
            values.put("id", i);
            values.put("name", names[i]);
            values.put("description", desc[i]);
            values.put("time", 1);
            values.put("img", imgs[i]);
            values.put("type", type);
            db.insert("train", null, values);
        }
        db.execSQL("create table types (id INTEGER, type TEXT, name TEXT, description TEXT);");
        ContentValues values1 = new ContentValues();
        String[] types = res.getStringArray(R.array.type);
        String[] types_name = res.getStringArray(R.array.type_name);
        String[] types_desc = res.getStringArray(R.array.type_desc);
        length = types.length;
        for (int i = 0; i < length; i++) {
            values1.put("id", i);
            values1.put("type", types[i]);
            values1.put("name", types_name[i]);
            values1.put("description", types_desc[i]);
            db.insert("types", null, values1);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

