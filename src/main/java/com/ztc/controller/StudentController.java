package com.ztc.controller;

import com.ztc.dao.student;
import com.ztc.pojo.Classx;
import com.ztc.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    public student stu;//获取动态dao接口

//查询所有学生班级
//    @RequestMapping("/qureall")
//    public  String qureall(Model model,Student student ){
//        List<Student> studen = stu.queryAll(student);
//        model.addAttribute("querall", studen);
//
//        List<Classx> prices= stu.queryclassx();
//        model.addAttribute("classrooms",prices);
//        return "xueShenBiao.jsp";
//    }

//    @RequestMapping("/queralls")
//    public String queralls(Model model) {
//        List<Student> studen = stu.queryAll();
//        model.addAttribute("querall", studen);
//        return "xueShenBiao.jsp";
//    }
//添加查询班级
    @RequestMapping("/queryclassx")
    public String queryclassx(Model model ){
        List<Classx> price= stu.queryclassx();
        model.addAttribute("classrooms",price);
       return "add.jsp";
    }
 //添加
    @RequestMapping("/add")
    public String add(Student student){
        stu.add(student);
        return "/fuzzyQuery.do";
    }
    //修改查询
    @RequestMapping("/getByid")
    public String getByid(int id, Model model){
        Student price= stu.getByid(id);
        model.addAttribute("querall",price);

        List<Classx> prices= stu.queryclassx();
        model.addAttribute("classrooms",prices);
        return "amend.jsp";
    }
    //修改数据
    @RequestMapping("/update")
    public String update(Student student){
        System.out.println("============="+student);
       stu.update(student);
        return "/fuzzyQuery.do";
    }
    //删除数据
    @RequestMapping("/delete")
    public String  delete(int id){
        stu.delete(id);
        return "fuzzyQuery.do";
    }
    //查询
    @RequestMapping("/fuzzyQuery")
    public  String fuzzyQuery(Student student, Model model){
       List<Student> price= stu.fuzzyQuery(student);
        model.addAttribute("querall", price);

        List<Classx> prices= stu.queryclassx();
        model.addAttribute("classrooms",prices);
        return "xueShenBiao.jsp";
   }

}
