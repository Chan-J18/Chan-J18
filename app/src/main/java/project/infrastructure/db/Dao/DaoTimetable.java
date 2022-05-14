package project.infrastructure.db.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.servicesystem.infrastructure.Dao.MyHelper;


public class DaoTimetable {
    private MyHelper helper;
    private SQLiteDatabase db;
    public DaoTimetable(Context context)
    {
        helper = MyHelper.getInstance(context.getApplicationContext());
    }

    public void CreatetableTime()
    {
        helper.getWritableDatabase().execSQL("CREATE TABLE if not exists timetable (tid vachar(20) primary key,time varchar(20),pid varchar(20),foreign key(pid) references  project_info(pid))");
    }
    public String getTimeTable(String pid)
    {
        CreatetableTime();
        db = helper.getReadableDatabase();
        String args[] = {pid};
        String columns[] = {"time"};
        Cursor cursor = db.query("timetable",columns,"pid=?",args,null,null,null);

        String ans = null;
        if(cursor.getCount()!=0)
            while (cursor.moveToNext())
                ans = cursor.getString(0);
        cursor.close();
        return ans;
    }

    public void updateTime(String pid, String time)
    {
        CreatetableTime();
        db = helper.getWritableDatabase();
        String args[] = {pid};
        ContentValues values = new ContentValues();
        values.put("time",time);
        db.update("timetable",values,"pid=?",args);
    }

    public void insertTime(String pid,String time)
    {
        CreatetableTime();
        db =helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String tid = null;
        do {
            tid = String.valueOf((int)(Math.random()*1000000));
        }while (TidisExist(tid));
        cv.put("tid",tid);
        cv.put("pid",pid);
        cv.put("time",time);
        db.insert("timetable","tid",cv);
    }

    private boolean TidisExist(String tid) {
        CreatetableTime();
        boolean ans =false;
        db =helper.getReadableDatabase();
        String args[] = {tid};
        Cursor cursor =db.query("timetable",null,"tid=?",args,null,null,null);
        if(cursor.getCount()!=0) ans = true;
        cursor.close();
        return ans;
    }

}
