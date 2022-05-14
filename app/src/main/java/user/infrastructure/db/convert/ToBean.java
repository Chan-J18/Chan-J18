package user.infrastructure.db.convert;

import java.util.List;

import user.domain.model.entity.ListBean;

public class ToBean {
    public static ListBean toPmsg(String pid,String pname,String pstate,String pintroduce,String pcontent,String ptype)
    {
        ListBean bean = new ListBean();
        bean.setPro_name(pname);
        bean.setPro_introduce(pintroduce);
        bean.setPro_state(pstate);
        bean.setPro_id(pid);
        bean.setPro_content(pcontent);
        bean.setPro_type(ptype);
        return  bean;
    }
}
