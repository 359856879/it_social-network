package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 10:28
 * @Description:
 */
@Table(name = "l_borge")
public class Borge {

    @Id
    private Integer borgeid;      //博客主键

    private String borgeimg;      //博客配图

    private String borgename;     // 博客主题

    private String borgeintroduce;   // 博客简介

    private String borgecontent;   // 博客具体内容

    private Date borgedate;    // 博客发表的时间

    private Integer borgecomnum;   // 博客的评论数量

    private String borgekey;   // 博客的关键词

    private Integer borgereadnum;   //博客的阅读量

   private List<Discuss> list;   //每个博客都有一个对应的评论集合


    @Override
    public String toString() {
        return "Borge{" +
                "borgeid=" + borgeid +
                ", borgeimg='" + borgeimg + '\'' +
                ", borgename='" + borgename + '\'' +
                ", borgeintroduce='" + borgeintroduce + '\'' +
                ", borgecontent='" + borgecontent + '\'' +
                ", borgedate=" + borgedate +
                ", borgecomnum=" + borgecomnum +
                ", borgekey='" + borgekey + '\'' +
                ", borgereadnum=" + borgereadnum +
                ", list=" + list +
                '}';
    }

    public Integer getBorgeid() {
        return borgeid;
    }

    public void setBorgeid(Integer borgeid) {
        this.borgeid = borgeid;
    }

    public String getBorgeimg() {
        return borgeimg;
    }

    public void setBorgeimg(String borgeimg) {
        this.borgeimg = borgeimg;
    }

    public String getBorgename() {
        return borgename;
    }

    public void setBorgename(String borgename) {
        this.borgename = borgename;
    }

    public String getBorgeintroduce() {
        return borgeintroduce;
    }

    public void setBorgeintroduce(String borgeintroduce) {
        this.borgeintroduce = borgeintroduce;
    }

    public String getBorgecontent() {
        return borgecontent;
    }

    public void setBorgecontent(String borgecontent) {
        this.borgecontent = borgecontent;
    }

    public Date getBorgedate() {
        return borgedate;
    }

    public void setBorgedate(Date borgedate) {
        this.borgedate = borgedate;
    }

    public Integer getBorgecomnum() {
        return borgecomnum;
    }

    public void setBorgecomnum(Integer borgecomnum) {
        this.borgecomnum = borgecomnum;
    }

    public String getBorgekey() {
        return borgekey;
    }

    public void setBorgekey(String borgekey) {
        this.borgekey = borgekey;
    }

    public Integer getBorgereadnum() {
        return borgereadnum;
    }

    public void setBorgereadnum(Integer borgereadnum) {
        this.borgereadnum = borgereadnum;
    }

    public List<Discuss> getList() {
        return list;
    }

    public void setList(List<Discuss> list) {
        this.list = list;
    }

    public Borge() {
    }

    public Borge(Integer borgeid, String borgeimg, String borgename, String borgeintroduce, String borgecontent, Date borgedate, Integer borgecomnum, String borgekey, Integer borgereadnum, List<Discuss> list) {
        this.borgeid = borgeid;
        this.borgeimg = borgeimg;
        this.borgename = borgename;
        this.borgeintroduce = borgeintroduce;
        this.borgecontent = borgecontent;
        this.borgedate = borgedate;
        this.borgecomnum = borgecomnum;
        this.borgekey = borgekey;
        this.borgereadnum = borgereadnum;
        this.list = list;
    }
}