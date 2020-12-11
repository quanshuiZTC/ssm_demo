package com.ztc.controller;

import com.ztc.dao.student;
import com.ztc.dao.studentPlus;
import com.ztc.pojo.Student;
import com.ztc.pojo.StudentPlus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
        studentPlus s=app.getBean(studentPlus.class);
        StudentPlus sy=new StudentPlus();
        sy.setName("zhang");
        s.insert(sy);


//                List<Student> list= s.queryAll();
//
//                 for (Student stu: list){
//                     System.out.println(stu.getName()+stu.getSex());
//                 }
//
//        ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
//        studentPlus st= app.getBean(studentPlus.class);
//
//        List<StudentPlus> list= st.selectList(null);
//        for (StudentPlus stu: list){
//                     System.out.println(stu.getName()+stu.getSex());
//                 }
//
//

//      for (int a=1;a<10;a++){
//         for (int b=1;b<=a;b++){
//             System.out.print(b+"X"+a+"="+b*a+" ");
//         }
//          System.out.println("");
//      }


   }

}
