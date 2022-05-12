package user.domain.model.Service;

import android.content.Context;
import android.database.Cursor;

import com.example.servicesystem.infrastructure.Dao.Dao;

import java.util.ArrayList;
import java.util.List;

import project.infrastructure.db.Dao.DaoProject;
import user.domain.model.entity.ListBean;
import user.infrastructure.db.convert.ToBean;

public class ProjectService {
    private Dao dao;
    private DaoProject daoProject;

    public  ProjectService(Context context)
    {
        dao = new Dao(context);
    }

    public List<ListBean> get(String id)
    {
        List<String> pids = dao.getPid(id);
        List<ListBean> list = new ArrayList<>();
        for(int i=0;i<pids.size();i++)
        {
            Cursor cursor = daoProject.getProjects(pids.get(i));
            if(cursor.getCount()!=0)
            {
                while (cursor.moveToNext())
                {
                    String pname = cursor.getString(1);
                    String pstate = cursor.getString(2);
                    String content =cursor.getString(3);
                    list.add(ToBean.toPmsg(pname,pstate,content));
                }
            }
        }
        return list;
    }
}
