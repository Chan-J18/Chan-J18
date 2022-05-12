package user.infrastructure.db.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DaoUser {
    private MyHelper helper;
    private SQLiteDatabase db;
    public DaoUser(Context context)
    {
        helper = new MyHelper(context);
    }

    public void insertUserInfo(String user_id,String user_pw)
    {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",user_id);
        values.put("pw",user_pw);
        long id = db.insert("userinfo",null,values);
        db.close();
    }

}
