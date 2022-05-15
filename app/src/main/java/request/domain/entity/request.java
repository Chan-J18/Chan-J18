package request.domain.entity;

import java.io.Serializable;

public class request implements Serializable {
    private String rid;
    private String rname;
    private String rtype;
    private String rstate;
    private String rintroduce;
    private String rcontent;


    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setRintroduce(String rintroduce) {
        this.rintroduce = rintroduce;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setRstate(String rstate) {
        this.rstate = rstate;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRcontent() {
        return rcontent;
    }

    public String getRid() {
        return rid;
    }

    public String getRintroduce() {
        return rintroduce;
    }

    public String getRname() {
        return rname;
    }

    public String getRstate() {
        return rstate;
    }

    public String getRtype() {
        return rtype;
    }

}
