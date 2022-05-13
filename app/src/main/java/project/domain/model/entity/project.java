package project.domain.model.entity;

public class project {
    private String pid;
    private String pname;
    private String pintroduce;
    private String pcontent;
    private String pstate;
    private String worktime;

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public void setPintroduce(String pintroduce) {
        this.pintroduce = pintroduce;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getPcontent() {
        return pcontent;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getPstate() {
        return pstate;
    }

    public String getWorktime() {
        return worktime;
    }

    public String getPintroduce() {
        return pintroduce;
    }
}
