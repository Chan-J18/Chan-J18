package user.domain.model.entity;

import java.io.Serializable;
import java.util.List;

public class ListBean implements Serializable {
    private String pro_name;
    private String pro_introduce;
    private String pro_state;
    private String pro_id;
    private String pro_content;

    public void setPro_name(String name){pro_name =name;}
    public void setPro_introduce(String introduce){pro_introduce=introduce;}
    public void setPro_state(String state){pro_state=state;}
    public void setPro_id(String id){pro_id = id;}
    public void setPro_content(String pro_content) { this.pro_content = pro_content; }

    public String getPro_name(){return pro_name;}
    public String getPro_introduce(){return pro_introduce;}
    public String getPro_state(){return pro_state;}
    public String getPro_id(){return  pro_id;}
    public String getPro_content(){return  pro_content;}
}
