package project.infrastructure.db.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import user.domain.model.entity.ListBean;

public class DaoTimetable {
    private TimeHelper helper;
    private SQLiteDatabase db;
    public DaoTimetable(Context context)
    {
        helper = new TimeHelper(context);
    }

    public List<String> getTimeTable(List<String> l)
    {
        List<String> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        String columns[] = {"tid"};
        Cursor cursor;
        for(int i=0;i<l.size();i++)
        {
            cursor = db.query("timetable",columns,"pid="+l.get(i),null,null,null,null);
            if(cursor.getCount()!=0)
                while (cursor.moveToNext())
                    list.add(cursor.getString(1));
        }
        db.close();
        return list;
    }


    class TimeHelper extends SQLiteOpenHelper{

        private Context context;
        public TimeHelper(Context context)
        {
            super(context,"SystemDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE timetable (tid vachar(20) primary key,time varchar(20),pid varchar(20)," +
                    "foreign key(pid) references  project_info(pid))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
