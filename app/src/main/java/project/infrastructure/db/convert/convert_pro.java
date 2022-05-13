package project.infrastructure.db.convert;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import project.domain.model.entity.project;
import project.infrastructure.db.Dao.DaoTimetable;
import user.domain.model.entity.ListBean;

public class  convert_pro{
    public static List<project> getPmsg(Serializable pmsg)
    {
        List<ListBean> bean = (List<ListBean>)pmsg;
        List<project> pro = new ArrayList<>();
        for(int i=0;i<bean.size();i++)
        {
            project p = new project();
            ListBean lb = bean.get(i);
            p.setPid(lb.getPro_id());
            p.setPstate(lb.getPro_state());
            p.setPintroduce(lb.getPro_introduce());
            p.setPname(lb.getPro_name());
            p.setPcontent(lb.getPro_content());
            pro.add(p);
        }
        return  pro;
    }

    public static List<project> getPro(List<project> list,Serializable umsg,Context context)
    {
        String id = (String)umsg;
        DaoTimetable timetable = new DaoTimetable(context);
        List<String> times = timetable.getTimeTable(getProId(list));
        for(int i=0;i<list.size();i++)
            list.get(i).setWorktime(times.get(i));
        //得到对用合同的时间表 project 有time table 对象  ,contract 是vo time table
        return list;
    }

    public static List<String> getProId(List<project> list)
    {
        List<String> l = new ArrayList<>();
        for(int i=0;i<list.size();i++)
            l.add(list.get(i).getPid());
        return l;
    }
}
