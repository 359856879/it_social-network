package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/29 10:08
 * @Description:
 */
@Table(name = "l_user")
public class User {

    @Id
    private Integer  userid;    //用户主键(id)

    private String username;   // 用户的登录名

    private String userflname;  //姓名

    private String usernickname  ;  //昵称

    private String userpassword;   //用户密码

    private Integer usertypeid;  // 用户注册的账号类型

    private String useremail;    // 用户邮箱

    private Date userregister;      //   注册的时间

    private Date userap;    //  用户最后评论他人时间

    private Date userlp;   //  用户最后修改个人信息的时间

    private String userphoto;   //用户头像

    private String userhobby;   //   用户爱好

    private String userskills;   // 用户的技能

    private String userip;    //用户当前登录ip

    private List<LUsertype> lUsertype;     //用户类型关联


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userflname='" + userflname + '\'' +
                ", usernickname='" + usernickname + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", usertypeid=" + usertypeid +
                ", useremail='" + useremail + '\'' +
                ", userregister=" + userregister +
                ", userap=" + userap +
                ", userlp=" + userlp +
                ", userphoto='" + userphoto + '\'' +
                ", userhobby='" + userhobby + '\'' +
                ", userskills='" + userskills + '\'' +
                ", userip='" + userip + '\'' +
                ", lUsertype=" + lUsertype +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserflname() {
        return userflname;
    }

    public void setUserflname(String userflname) {
        this.userflname = userflname;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(Integer usertypeid) {
        this.usertypeid = usertypeid;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Date getUserregister() {
        return userregister;
    }

    public void setUserregister(Date userregister) {
        this.userregister = userregister;
    }

    public Date getUserap() {
        return userap;
    }

    public void setUserap(Date userap) {
        this.userap = userap;
    }

    public Date getUserlp() {
        return userlp;
    }

    public void setUserlp(Date userlp) {
        this.userlp = userlp;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getUserhobby() {
        return userhobby;
    }

    public void setUserhobby(String userhobby) {
        this.userhobby = userhobby;
    }

    public String getUserskills() {
        return userskills;
    }

    public void setUserskills(String userskills) {
        this.userskills = userskills;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public List<LUsertype> getlUsertype() {
        return lUsertype;
    }

    public void setlUsertype(List<LUsertype> lUsertype) {
        this.lUsertype = lUsertype;
    }

    public User(Integer userid, String username, String userflname, String usernickname, String userpassword, Integer usertypeid, String useremail, Date userregister, Date userap, Date userlp, String userphoto, String userhobby, String userskills, String userip, List<LUsertype> lUsertype) {
        this.userid = userid;
        this.username = username;
        this.userflname = userflname;
        this.usernickname = usernickname;
        this.userpassword = userpassword;
        this.usertypeid = usertypeid;
        this.useremail = useremail;
        this.userregister = userregister;
        this.userap = userap;
        this.userlp = userlp;
        this.userphoto = userphoto;
        this.userhobby = userhobby;
        this.userskills = userskills;
        this.userip = userip;
        this.lUsertype = lUsertype;
    }

    public User() {
    }

}