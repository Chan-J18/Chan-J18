package com.example.servicesystem.infrastructure.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    private static MyHelper helper;
    public MyHelper(Context context)
    {
        super(context,"SystemDB",null,1);
    }

    public static synchronized MyHelper getInstance(Context context){
        if(helper == null){
            helper = new MyHelper(context);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists user_pro(pid varchar(20),id varchar(20),primary key(pid,id))");
        sqLiteDatabase.execSQL("CREATE TABLE if not exists project_info (pid vachar(20) primary key,pname varchar(2),pstate varchar(20),pintroduce varchar(50)," +
                "pcontent varchar(100),ptype varchar(20))");
        sqLiteDatabase.execSQL("CREATE TABLE if not exists user_info (id vachar(10) primary key,pw varchar(20),state varchar(20))");
        sqLiteDatabase.execSQL("CREATE TABLE if not exists timetable (tid vachar(20) primary key,time varchar(20),pid varchar(20)," +
                "foreign key(pid) references  project_info(pid))");
        sqLiteDatabase.execSQL("create table if not exists request_info(rid vachar(20) primary key,rname varchar(2),rstate varchar(20),rintroduce varchar(50),rcontent varchar(100),rtype varchar(20),id varchar(20)," +
                "foreign key(id) references user_info(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_pro");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS project_info");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_info");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS timetable");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS request_info");
        onCreate(sqLiteDatabase);
    }
}
