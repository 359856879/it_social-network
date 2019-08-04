package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "l_usertype")
public class LUsertype {

  @Id
  private Integer utypeid;
  private String utypename;
  private String utypestyle;
  private String usertypeid;



  @Override
  public String toString() {
    return "LUsertype{" +
            "utypeid=" + utypeid +
            ", utypename='" + utypename + '\'' +
            ", utypestyle='" + utypestyle + '\'' +
            ", usertypeid='" + usertypeid + '\'' +
            '}';
  }

  public Integer getUtypeid() {
    return utypeid;
  }

  public void setUtypeid(Integer utypeid) {
    this.utypeid = utypeid;
  }

  public String getUtypename() {
    return utypename;
  }

  public void setUtypename(String utypename) {
    this.utypename = utypename;
  }

  public String getUtypestyle() {
    return utypestyle;
  }

  public void setUtypestyle(String utypestyle) {
    this.utypestyle = utypestyle;
  }

  public String getUsertypeid() {
    return usertypeid;
  }

  public void setUsertypeid(String usertypeid) {
    this.usertypeid = usertypeid;
  }

  public LUsertype(Integer utypeid, String utypename, String utypestyle, String usertypeid) {
    this.utypeid = utypeid;
    this.utypename = utypename;
    this.utypestyle = utypestyle;
    this.usertypeid = usertypeid;
  }

  public LUsertype() {
  }
}
