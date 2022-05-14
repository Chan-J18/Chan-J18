package user.infrastructure.db.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.servicesystem.infrastructure.Dao.MyHelper;

public class DaoUser {
    private MyHelper helper;
    private SQLiteDatabase db;
    private Context context;
    public DaoUser(Context context)
    {
        this.context =context;
        helper = MyHelper.getInstance(context.getApplicationContext());
    }

    public void CreatetableUser()
    {
        helper.getWritableDatabase().execSQL("CREATE TABLE if not exists user_info (id vachar(10) primary key,pw varchar(20),state varchar(20))");
    }

    public void insertUserInfo(String user_id,String user_pw,String state)
    {
        CreatetableUser();
        db = helper.getReadableDatabase();
        String args[] = {user_id};
        Cursor cursor=db.query("user_info",null,"id=?",args,null,null,null);
        if(cursor.getCount()!=0)
        {
            Toast.makeText(context,"已存在账号",Toast.LENGTH_SHORT).show();
        }else{
            db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id",user_id);
            values.put("pw",user_pw);
            values.put("state",state);
            long id = db.insert("user_info",null,values);
        }
        cursor.close();
     }

}
