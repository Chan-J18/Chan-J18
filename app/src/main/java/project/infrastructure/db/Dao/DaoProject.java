package project.infrastructure.db.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.servicesystem.infrastructure.Dao.Dao;
import com.example.servicesystem.infrastructure.Dao.MyHelper;

import java.util.List;

import project.domain.model.entity.project;

public class DaoProject {
    private Context context;
    private MyHelper helper;
    private SQLiteDatabase db;
    public DaoProject(Context context)
    {
        this.context =context;
        helper = MyHelper.getInstance(context.getApplicationContext());
    }

    public Cursor getAllPros()
    {
        CreatetablePro();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from project_info ",null);
        return cursor;
    }

    public Cursor getProjects(String pid)
    {
        CreatetablePro();
        db = helper.getReadableDatabase();
        String args[] ={pid};
        Cursor cursor = db.rawQuery("select * from project_info where pid=?",args);
        return cursor;
    }

    public void CreatetablePro()
    {
        helper.getWritableDatabase().execSQL("CREATE TABLE if not exists project_info (pid vachar(20) primary key,pname varchar(2),pstate varchar(20),pintroduce varchar(50),pcontent varchar(100))");
    }

    public void updateProject(String pid, ContentValues cv, String time)
    {
        CreatetablePro();
        db = helper.getWritableDatabase();
        String args[] = {pid};
        db.update("project_info",cv,"pid=?",args);
        DaoTimetable daoTimetable = new DaoTimetable(context);
        daoTimetable.updateTime(pid,time);
    }

    public void insertProject(project pro,String id)
    {
        CreatetablePro();
        String pid = null;
        do {
            pid = String.valueOf((int)(Math.random()*1000000));
        }while (PidisExist(pid));

        //插入项目
        db =helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("pid",pid);
        cv.put("ptype",pro.getPtype());
        cv.put("pname",pro.getPname());
        cv.put("pstate","work");
        cv.put("pintroduce",pro.getPintroduce());
        cv.put("pcontent",pro.getPcontent());
        db.insert("project_info","pid",cv);
        //插入时间表
        new DaoTimetable(context).insertTime(pid,pro.getWorktime());
        new Dao(context).insertPro(pid,id);
    }

    public boolean PidisExist(String pid)
    {
        CreatetablePro();
        db =helper.getReadableDatabase();
        String args[] = {pid};
        Cursor cursor =db.query("project_info",null,"pid=?",args,null,null,null);
        boolean ans = false;
        if(cursor.getCount()!=0) ans = true;
        cursor.close();
        return ans;
    }
}
