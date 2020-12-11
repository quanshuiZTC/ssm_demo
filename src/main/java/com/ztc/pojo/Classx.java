package com.ztc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;


public class Classx {
    private int id;
    private  String bname;
    private List<Student> list;
//    private List<Classx> classxes;
//
//    public List<Classx> getClassxes() {
//        return classxes;
//    }
//
//    public void setClassxes(List<Classx> classxes) {
//        this.classxes = classxes;
//    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


}
