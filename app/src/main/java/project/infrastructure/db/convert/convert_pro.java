package project.infrastructure.db.convert;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import project.domain.model.entity.project;
import project.infrastructure.db.Dao.DaoTimetable;
import user.domain.model.entity.ListBean;

public class  convert_pro{
    public static project getPmsg(Serializable pmsg)
    {
        ListBean bean = (ListBean)pmsg;
        project pro  = new project();
        pro.setPid(bean.getPro_id());
        pro.setPstate(bean.getPro_state());
        pro.setPintroduce(bean.getPro_introduce());
        pro.setPname(bean.getPro_name());
        pro.setPcontent(bean.getPro_content());
        pro.setPtype(bean.getPro_type());
        return  pro;
    }

    public static project getPro(project pro,Serializable umsg,Context context)
    {
        String id = (String)umsg;
        DaoTimetable timetable = new DaoTimetable(context);
        String times = timetable.getTimeTable(pro.getPid());
        //得到对用合同的时间表 project 有time table 对象  ,contract 是vo time table
        pro.setWorktime(times);
        return pro;
    }

    public static List<String> getProId(List<project> list)
    {
        List<String> l = new ArrayList<>();
        for(int i=0;i<list.size();i++)
            l.add(list.get(i).getPid());
        return l;
    }
}
