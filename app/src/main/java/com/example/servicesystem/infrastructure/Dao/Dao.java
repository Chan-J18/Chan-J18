package com.example.servicesystem.infrastructure.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private MyHelper helper;
    private SQLiteDatabase db;
    public Dao(Context context)
    {
        helper = new MyHelper(context.getApplicationContext());
    }

    public List<String> getPid(String id)
    {
        db = helper.getReadableDatabase();
        Cursor cursor = db.query("user_pro",null,"id="+id,null,null,null,null);
        List<String> list = new ArrayList<>();
        if (cursor.getCount()!=0)
        {
            while(cursor.moveToNext())
                list.add(cursor.getString(0));
        }
        db.close();
        return list;
    }

    public List<String> getId(String pid)
    {
        db = helper.getReadableDatabase();
        Cursor cursor = db.query("user_pro",null,"id="+pid,null,null,null,null);
        List<String> list = new ArrayList<>();
        if (cursor.getCount()!=0)
        {
            while(cursor.moveToNext())
                list.add(cursor.getString(1));
        }
        db.close();
        return list;
    }
}
