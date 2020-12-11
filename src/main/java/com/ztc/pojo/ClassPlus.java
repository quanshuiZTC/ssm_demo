package com.ztc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName(value = "banjissh")
public class ClassPlus {
    @TableId(value = "id" ,type = IdType.UUID)
    private int id;
    private  String bname;
//    private List<Student> list;

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

//    public List<Student> getList() {
//        return list;
//    }
//
//    public void setList(List<Student> list) {
//        this.list = list;
//    }
}
