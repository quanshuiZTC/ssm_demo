package com.ztc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "accountssh")
public class RegisterPlus {
    @TableId(value = "zpassword")
    private  Integer zpassword;
    private  String zname;

    public Integer getZpassword() {
        return zpassword;
    }

    public void setZpassword(Integer zpassword) {
        this.zpassword = zpassword;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }
}
