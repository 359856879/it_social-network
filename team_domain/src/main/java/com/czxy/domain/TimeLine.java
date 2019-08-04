package com.czxy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 时间线表 记录登录用户的行为
 */
@Table(name = "i_timeline")
public class TimeLine {
    @Id
    private Integer timelineid; //主键
    @DateTimeFormat(pattern = "y-M-d H:m:s")
    private String timeline; //事件触发时的时间
    private String info; //事件内容
    @Column(name = "useriid")
    private Integer userIid; //当前用户id
    @Column(name = "useryid")
    private Integer userYid; //访问对应用户用到的id
    private Integer discussid; //评论id
    private Integer receiveemailid; //接收邮件id
    private Integer sendemailid; //发送邮件id

    @Override
    public String toString() {
        return "TimeLine{" +
                "timelineid=" + timelineid +
                ", timeline=" + timeline +
                ", info='" + info + '\'' +
                ", userIid=" + userIid +
                ", userYid=" + userYid +
                ", discussid=" + discussid +
                ", receiveemailid=" + receiveemailid +
                ", sendemailid=" + sendemailid +
                '}';
    }

    public TimeLine() {
    }

    public TimeLine(Integer timelineid, String timeline, String info, Integer userIid, Integer userYid, Integer discussid, Integer receiveemailid, Integer sendemailid) {
        this.timelineid = timelineid;
        this.timeline = timeline;
        this.info = info;
        this.userIid = userIid;
        this.userYid = userYid;
        this.discussid = discussid;
        this.receiveemailid = receiveemailid;
        this.sendemailid = sendemailid;
    }

    public Integer getTimelineid() {
        return timelineid;
    }

    public void setTimelineid(Integer timelineid) {
        this.timelineid = timelineid;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getUserIid() {
        return userIid;
    }

    public void setUserIid(Integer userIid) {
        this.userIid = userIid;
    }

    public Integer getUserYid() {
        return userYid;
    }

    public void setUserYid(Integer userYid) {
        this.userYid = userYid;
    }

    public Integer getDiscussid() {
        return discussid;
    }

    public void setDiscussid(Integer discussid) {
        this.discussid = discussid;
    }

    public Integer getReceiveemailid() {
        return receiveemailid;
    }

    public void setReceiveemailid(Integer receiveemailid) {
        this.receiveemailid = receiveemailid;
    }

    public Integer getSendemailid() {
        return sendemailid;
    }

    public void setSendemailid(Integer sendemailid) {
        this.sendemailid = sendemailid;
    }
}
