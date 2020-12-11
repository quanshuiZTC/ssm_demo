package com.ztc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.dao.classxPlus;
import com.ztc.dao.studentPlus;
import com.ztc.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.font.MultipleMaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
public class StudentControllerPlus {
    @Autowired
    public studentPlus stu;
    @Autowired
    public classxPlus cka;

    //查询，
    @ResponseBody
    @RequestMapping("/fuzzyQueryp")
    public String fuzzyQueryp(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,StudentPlus studentPlus, Model model){
        Page<StudentPlus> page=new Page<>(pageNum,3);
        IPage<StudentPlus>  iPage=stu.fuzzyQuery(page,studentPlus);
//获取集合值
        List<StudentPlus> price = iPage.getRecords();

//        //返回集合
        model.addAttribute("querall",price);
//        //当前页
     model.addAttribute("page",iPage.getCurrent());
//        //一页几条
       model.addAttribute("pages",iPage.getPages());

      List<ClassPlus>  prices= cka.selectList(null);
        model.addAttribute("classrooms",prices);

        return "/fuzzyQueryp.do";
    }
 //==============================================================
    //查询 layui框架异步
    @ResponseBody
    @RequestMapping("/fuzzyQueryLagui")
    public LayUiData fuzzyQueryLagui(@RequestParam("page") Integer pageNum,Integer limit,StudentPlus studentPlus ){

        System.out.println("]]]]"+studentPlus.getName());
        IPage<StudentPlus> page=new Page<>(pageNum,limit);
        IPage<StudentPlus> studen= stu.fuzzyQuery(page,studentPlus);
//        System.out.println("=====++"+studen.getPages());
//        int a= (int) studen.getPages();
          int a=(int) page.getTotal();
        System.out.println("一共几"+page.getTotal());
        LayUiData layUiData=  new LayUiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(a);//条数
        layUiData.setData(studen.getRecords());

        return layUiData;
    }

//    ====================================================

    //添加查询 班级
    @RequestMapping("/queryclassxp")
    public String queryclassxp(Model model ){
        List<ClassPlus>  price= cka.selectList(null);
        model.addAttribute("classrooms",price);
        return "add.jsp";
    }
    //查询班级 layui框架异步
    @RequestMapping("/classrooms")
    @ResponseBody
    public List classrooms() {
         List<ClassPlus>  price= cka.selectList(null);
        return price;
    }



    //添加
    @PostMapping("/addp")
    public String addp(@RequestParam("filename") MultipartFile pictureFile, StudentPlus studentPlus, HttpServletRequest req)throws IOException {
        //设置图片名称，不能重复，可以使用UUID
        String picName= UUID.randomUUID().toString();
        //获取文件名
        String oriName=pictureFile.getOriginalFilename();
        //获取图片后缀
        String extName=oriName.substring(oriName.lastIndexOf("."));
        //获取项目根路径
        String path=req.getServletContext().getRealPath("/");

      //把图片上传到tomcat+自己创建的文件夹+图片名称和后缀
        pictureFile.transferTo(new File(path+"/file/"+picName+extName));

        //把图片路径存到数据库
//        studentPlus.setPicture(picName + extName);

        stu.insert(studentPlus);
        return "/fuzzyQueryp.do";
    }
    //添加 layui框架异步
    @RequestMapping("/addlayui")
    @ResponseBody
    public void  addlayui( @RequestBody StudentPlus studentPlus){
        System.out.println("+++++++"+studentPlus.getName()+"============="+studentPlus.getAge());
        stu.insert(studentPlus);
    }

    //修改查询 （layui框架thymeleaf）
    @RequestMapping("/getByidp")
    public String getByidp(Model model, int id){
      StudentPlus price=  stu.selectById(id);
        model.addAttribute("querall",price);

        List<ClassPlus>  prices= cka.selectList(null);
        model.addAttribute("classrooms",prices);


       // return "amend.jsp";
        return  "add";
    }
    //修改  （layui框架thymeleaf）
    @RequestMapping("/updatep")
    public  String update(StudentPlus studentPlus){
        System.out.println("+++++"+studentPlus.getName());
      stu.updateById(studentPlus);
        //return "/fuzzyQueryp.do";
        return "add";
    }
    //删除
    @RequestMapping("/deletep")
    @ResponseBody
    public boolean  deletep (String id){
        try {
            stu.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //批量删除
    @RequestMapping("/deleteByIds")
    @ResponseBody
    public  String deleteByIds(Integer[] id){
        stu.deleteBatchIds(Arrays.asList(id));
        return "fuzzyQueryp.do";
    }



}
