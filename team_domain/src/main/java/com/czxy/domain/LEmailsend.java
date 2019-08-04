package com.czxy.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "l_emailsend")
public class LEmailsend {

  @Id
  private Integer sendemailid;    //发送邮件主键
  private String sendusermail;    //发送用户邮箱
  private String sendmailsubject;     //邮件的主题
  private String sendemailcontent;      //邮件内容
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sendemaildate;       //各种执行时的时间
  private Integer sendemailstatus;      //邮件当时的显示状态:  0 收件箱   1 草稿 , 2 已发送 , 3 垃圾
  private Integer senduserid;        //发送邮件的用户的id

  @Override
  public String toString() {
    return "LEmailsend{" +
            "sendemailid=" + sendemailid +
            ", sendusermail='" + sendusermail + '\'' +
            ", sendmailsubject='" + sendmailsubject + '\'' +
            ", sendemailcontent='" + sendemailcontent + '\'' +
            ", sendemaildate=" + sendemaildate +
            ", sendemailstatus=" + sendemailstatus +
            ", senduserid=" + senduserid +
            '}';
  }

  public Integer getSendemailid() {
    return sendemailid;
  }

  public void setSendemailid(Integer sendemailid) {
    this.sendemailid = sendemailid;
  }

  public String getSendusermail() {
    return sendusermail;
  }

  public void setSendusermail(String sendusermail) {
    this.sendusermail = sendusermail;
  }

  public String getSendmailsubject() {
    return sendmailsubject;
  }

  public void setSendmailsubject(String sendmailsubject) {
    this.sendmailsubject = sendmailsubject;
  }

  public String getSendemailcontent() {
    return sendemailcontent;
  }

  public void setSendemailcontent(String sendemailcontent) {
    this.sendemailcontent = sendemailcontent;
  }

  public Date getSendemaildate() {
    return sendemaildate;
  }

  public void setSendemaildate(Date sendemaildate) {
    this.sendemaildate = sendemaildate;
  }

  public Integer getSendemailstatus() {
    return sendemailstatus;
  }

  public void setSendemailstatus(Integer sendemailstatus) {
    this.sendemailstatus = sendemailstatus;
  }

  public Integer getSenduserid() {
    return senduserid;
  }

  public void setSenduserid(Integer senduserid) {
    this.senduserid = senduserid;
  }

  public LEmailsend(Integer sendemailid, String sendusermail, String sendmailsubject, String sendemailcontent, Date sendemaildate, Integer sendemailstatus, Integer senduserid) {
    this.sendemailid = sendemailid;
    this.sendusermail = sendusermail;
    this.sendmailsubject = sendmailsubject;
    this.sendemailcontent = sendemailcontent;
    this.sendemaildate = sendemaildate;
    this.sendemailstatus = sendemailstatus;
    this.senduserid = senduserid;
  }

  public LEmailsend() {
  }
}
