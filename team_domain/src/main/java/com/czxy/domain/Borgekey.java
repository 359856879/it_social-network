package com.czxy.domain;

import javax.persistence.Table;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 14:10
 * @Description:
 * 关键字
 */
@Table(name = "l_borgekey")
public class Borgekey {

    private Integer keyid;

    private String keyname;

    private Integer keynum;

    private String keystyle;


    @Override
    public String toString() {
        return "Borgekey{" +
                "keyid=" + keyid +
                ", keyname='" + keyname + '\'' +
                ", keynum=" + keynum +
                ", keystyle='" + keystyle + '\'' +
                '}';
    }


    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public Integer getKeynum() {
        return keynum;
    }

    public void setKeynum(Integer keynum) {
        this.keynum = keynum;
    }

    public String getKeystyle() {
        return keystyle;
    }

    public void setKeystyle(String keystyle) {
        this.keystyle = keystyle;
    }

    public Borgekey() {
    }

    public Borgekey(Integer keyid, String keyname, Integer keynum, String keystyle) {
        this.keyid = keyid;
        this.keyname = keyname;
        this.keynum = keynum;
        this.keystyle = keystyle;
    }
}