package project.infrastructure.db.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import project.infrastructure.db.Dao.MyHelper;

public class DaoProject {
    private project.infrastructure.db.Dao.MyHelper helper;
    private SQLiteDatabase db;
    public DaoProject(Context context)
    {
        helper = new MyHelper(context);
    }

    public Cursor getProjects(String pid)
    {
        db = helper.getReadableDatabase();
        Cursor cursor = db.query("Project",null,"id="+pid,null,null,null,null);
        db.close();
        return cursor;
    }
}
