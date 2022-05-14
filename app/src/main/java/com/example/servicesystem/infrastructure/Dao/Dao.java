package com.example.servicesystem.infrastructure.Dao;

import android.content.ContentValues;
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
        helper = MyHelper.getInstance(context.getApplicationContext());
    }

    public void Createtable()
    {
        helper.getWritableDatabase().execSQL("CREATE TABLE if not exists user_info (id vachar(10) primary key,pw varchar(20),state varchar(20))");
    }

    public  boolean isUser(String id,String pw)
    {
        boolean ans = false;
        db = helper.getReadableDatabase();
        String[] args={id};
        Cursor cursor = db.query("user_info",null,"id=?",args,null,null,null);
        if (cursor.getCount()!=0)
            ans = true;
        cursor.close();
        return  ans;
    }

    public List<String> getPid(String id)
    {
        db = helper.getReadableDatabase();
        String[] args={id};
        Cursor cursor = db.query("user_pro",null,"id=?",args,null,null,null);
        List<String> list = new ArrayList<>();
        if (cursor.getCount()!=0)
        {
            while(cursor.moveToNext())
                list.add(cursor.getString(0));
        }
        cursor.close();
        return list;
    }

    public List<String> getRid(String id)
    {
        db = helper.getReadableDatabase();
        String[] args={id};
        Cursor cursor = db.query("request_info",null,"id=?",args,null,null,null);
        List<String> list = new ArrayList<>();
        if (cursor.getCount()!=0)
        {
            while(cursor.moveToNext())
                list.add(cursor.getString(0));
        }
        cursor.close();
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
        cursor.close();
        return list;
    }

    public void insertPro(String pid,String uid)
    {
        CreateUser_Pro();
        //插入项目
        db =helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("pid",pid);
        cv.put("id",uid);
        db.insert("user_pro","pid",cv);
    }

    public void CreateUser_Pro()
    {
        helper.getWritableDatabase().execSQL("create table if not exists user_pro(pid varchar(20),id varchar(20),primary key(pid,id))");
    }
}
