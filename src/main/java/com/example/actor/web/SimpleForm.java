package com.example.actor.web;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

public class SimpleForm implements Serializable {

  private static final long serialVersionUID = -157143280035400042L;

  @NotNull
  @Size(min = 1, max = 120)
  private String ftext;

  @Pattern(regexp = "((19|[2-9][0-9])[0-9]{2})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])")
  private String ftdate;

  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate fdate;

  @Digits(integer = 3, fraction = 0)
  private String ftnum;

  @Min(1)
  @Max(999)
  private Integer fnum;

  @Size(min = 1, max = 600)
  private String farea;

  @Email
  private String femail;

  @NotNull
  @Size(min = 6, max = 12)
  private String fpass;

  @Pattern(regexp = "A|B|C|D|E")
  private String fselect;

  private String[] fmselect;

  @Pattern(regexp = "on|off")
  private String fcheck;

  private String[] fchecks;

  @NotNull
  @Pattern(regexp = "A|B|C|D|E")
  private String fradio;


  public String getFtext() {
    return ftext;
  }

  public void setFtext(String ftext) {
    this.ftext = ftext;
  }

  public String getFtdate() {
    return ftdate;
  }

  public void setFtdate(String ftdate) {
    this.ftdate = ftdate;
  }

  public String getFtnum() {
    return ftnum;
  }

  public void setFtnum(String ftnum) {
    this.ftnum = ftnum;
  }

  public LocalDate getFdate() {
    return fdate;
  }

  public void setFdate(LocalDate fdate) {
    this.fdate = fdate;
  }

  public Integer getFnum() {
    return fnum;
  }

  public void setFnum(Integer fnum) {
    this.fnum = fnum;
  }

  public String getFarea() {
    return farea;
  }

  public void setFarea(String farea) {
    this.farea = farea;
  }

  public String getFemail() {
    return femail;
  }

  public void setFemail(String femail) {
    this.femail = femail;
  }

  public String getFpass() {
    return fpass;
  }

  public void setFpass(String fpass) {
    this.fpass = fpass;
  }

  public String getFselect() {
    return fselect;
  }

  public void setFselect(String fselect) {
    this.fselect = fselect;
  }

  public String[] getFmselect() {
    return fmselect;
  }

  public void setFmselect(String[] fmselect) {
    this.fmselect = fmselect;
  }

  public String getFcheck() {
    return fcheck;
  }

  public void setFcheck(String fcheck) {
    this.fcheck = fcheck;
  }

  public String[] getFchecks() {
    return fchecks;
  }

  public void setFchecks(String[] fchecks) {
    this.fchecks = fchecks;
  }

  public String getFradio() {
    return fradio;
  }

  public void setFradio(String fradio) {
    this.fradio = fradio;
  }

  public String getFareaNl2br() {
    if (StringUtils.isNotEmpty(this.farea)) {
      return this.farea.replaceAll("\n", "<br/>");
    }
    return "";
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }

}
