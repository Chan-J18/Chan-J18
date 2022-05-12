package user.infrastructure.db.convert;

import java.util.List;

import user.domain.model.entity.ListBean;

public class ToBean {
    public static ListBean toPmsg(String pname,String pstate,String content)
    {
        ListBean bean = new ListBean();
        bean.setPro_name(pname);
        bean.setPro_introduce(content);
        bean.setPro_state(pstate);
        return  bean;
    }
}
