package com.czxy.domain;

import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 18:20
 * @Description:
 */
@Table(name = "l_discuss")
public class Discuss {

    private Integer discussid;   //评论id

    private String discussmsg;    // 评论内容

    private Date discusstime;   // 评论历史时间

    private Integer discussgood;   // 可能会用到的点赞功能

    private String discussimpor;  //  可能会用到的重要账号样式文本信息保存

    private Integer discusslevel;   //   用户评论时的评论位置等级  默认发帖人为0.第一个人为1

    private Integer upuserid;   // 上一级评论用户的id

    private Integer userid;     //   当前评论用户的id

    private  Integer todiscussid;   //  总评论博客id

    private User user;      //   评论对象


    @Override
    public String toString() {
        return "Discuss{" +
                "discussid=" + discussid +
                ", discussmsg='" + discussmsg + '\'' +
                ", discusstime=" + discusstime +
                ", discussgood=" + discussgood +
                ", discussimpor='" + discussimpor + '\'' +
                ", discusslevel=" + discusslevel +
                ", upuserid=" + upuserid +
                ", userid=" + userid +
                ", todiscussid=" + todiscussid +
                ", user=" + user +
                '}';
    }

    public Integer getDiscussid() {
        return discussid;
    }

    public void setDiscussid(Integer discussid) {
        this.discussid = discussid;
    }

    public String getDiscussmsg() {
        return discussmsg;
    }

    public void setDiscussmsg(String discussmsg) {
        this.discussmsg = discussmsg;
    }

    public Date getDiscusstime() {
        return discusstime;
    }

    public void setDiscusstime(Date discusstime) {
        this.discusstime = discusstime;
    }

    public Integer getDiscussgood() {
        return discussgood;
    }

    public void setDiscussgood(Integer discussgood) {
        this.discussgood = discussgood;
    }

    public String getDiscussimpor() {
        return discussimpor;
    }

    public void setDiscussimpor(String discussimpor) {
        this.discussimpor = discussimpor;
    }

    public Integer getDiscusslevel() {
        return discusslevel;
    }

    public void setDiscusslevel(Integer discusslevel) {
        this.discusslevel = discusslevel;
    }

    public Integer getUpuserid() {
        return upuserid;
    }

    public void setUpuserid(Integer upuserid) {
        this.upuserid = upuserid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTodiscussid() {
        return todiscussid;
    }

    public void setTodiscussid(Integer todiscussid) {
        this.todiscussid = todiscussid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Discuss() {
    }

    public Discuss(Integer discussid, String discussmsg, Date discusstime, Integer discussgood, String discussimpor, Integer discusslevel, Integer upuserid, Integer userid, Integer todiscussid, User user) {
        this.discussid = discussid;
        this.discussmsg = discussmsg;
        this.discusstime = discusstime;
        this.discussgood = discussgood;
        this.discussimpor = discussimpor;
        this.discusslevel = discusslevel;
        this.upuserid = upuserid;
        this.userid = userid;
        this.todiscussid = todiscussid;
        this.user = user;
    }
}