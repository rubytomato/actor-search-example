package com.example.actor.web;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ActorForm implements Serializable {

  private static final long serialVersionUID = 1330043957072942381L;

  @NotNull
  @Size(min=1, max=30)
  private String name;
  @Min(1)
  @Max(200)
  private String height;
  @Pattern(regexp = "A|B|AB|O")
  private String blood;
  @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
  private String birthday;
  @Min(1)
  @Max(47)
  private String birthplaceId;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getHeight() {
    return height;
  }
  public void setHeight(String height) {
    this.height = height;
  }
  public String getBlood() {
    return blood;
  }
  public void setBlood(String blood) {
    this.blood = blood;
  }
  public String getBirthday() {
    return birthday;
  }
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }
  public String getBirthplaceId() {
    return birthplaceId;
  }
  public void setBirthplaceId(String birthplaceId) {
    this.birthplaceId = birthplaceId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }

}
