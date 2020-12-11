package com.ztc.controller;

import com.ztc.dao.accountPlus;
import com.ztc.pojo.RegisterPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountControllerPlus {
    @Autowired
    accountPlus acc;

    //添加
    @PostMapping("/addt")
    public String add(RegisterPlus registerPlus){
        acc.insert(registerPlus);
        return "account.jsp";
    }

}
