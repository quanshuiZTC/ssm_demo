package com.ztc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "xueshengbiaossh")
public class StudentPlus {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private  String name;

    private String sex;

    private Integer age;

    private Integer bid;

//    private String picture;
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }

    @TableField(exist = false)
    private Classx classx;

    public Classx getClassx() {
        return classx;
    }

    public void setClassx(Classx classx) {
        this.classx = classx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }


}
