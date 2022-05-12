package user.domain.model.entity;

import java.util.List;

public class ListBean {
    private String pro_name;
    private String pro_introduce;
    private String pro_state;
    public void setPro_name(String name){pro_name =name;}
    public void setPro_introduce(String introduce){pro_introduce=introduce;}
    public void setPro_state(String state){pro_state=state;}
    public String getPro_name(){return pro_name;}
    public String getPro_introduce(){return pro_introduce;}
    public String getPro_state(){return pro_state;}
}
