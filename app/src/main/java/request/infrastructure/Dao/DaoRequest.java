package request.infrastructure.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.servicesystem.infrastructure.Dao.MyHelper;

import project.infrastructure.db.Dao.DaoTimetable;
import request.domain.entity.request;

public class DaoRequest {
    private Context context;
    private MyHelper helper;
    private SQLiteDatabase db;
    public DaoRequest(Context context)
    {
        this.context =context;
        helper = MyHelper.getInstance(context.getApplicationContext());
    }

    public Cursor getRequests(String pid)
    {
        CreatetableReq();
        db = helper.getReadableDatabase();
        String args[] ={pid};
        Cursor cursor = db.rawQuery("select * from project_info where pid=?",args);
        return cursor;
    }

    public void CreatetableReq()
    {
        helper.getWritableDatabase().execSQL("CREATE TABLE if not exists project_info (pid vachar(20) primary key,pname varchar(2),pstate varchar(20),pintroduce varchar(50),pcontent varchar(100))");
    }

    public void updateRequest(String pid, ContentValues cv, String time)
    {
        CreatetableReq();
        db = helper.getWritableDatabase();
        String args[] = {pid};
        db.update("project_info",cv,"pid=?",args);
        DaoTimetable daoTimetable = new DaoTimetable(context);
        daoTimetable.updateTime(pid,time);
    }

    public void insertRequest(request req)
    {
        CreatetableReq();
        String rid = null;
        do {
            rid = String.valueOf((int)Math.random()*1000000);
        }while (RidisExist(rid));

        //插入请求
        db =helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rid",rid);
        cv.put("rtype",req.getRtype());
        cv.put("rname",req.getRname());
        cv.put("rstate","work");
        cv.put("rintroduce",req.getRintroduce());
        cv.put("rcontent",req.getRcontent());
        db.insert("request","rid",cv);
    }

    public boolean RidisExist(String rid)
    {
        CreatetableReq();
        db =helper.getReadableDatabase();
        String args[] = {rid};
        Cursor cursor =db.query("request_info",null,"rid=?",args,null,null,null);
        boolean ans = false;
        if(cursor.getCount()!=0) ans = true;
        cursor.close();
        return ans;
    }

    public Cursor getAllReq() {
        CreatetableReq();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from request_info ",null);
        return cursor;
    }
}
