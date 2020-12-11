package com.ztc.Provider;

import com.ztc.dao.student;
import com.ztc.dao.studentPlus;
import com.ztc.pojo.Student;
import com.ztc.pojo.StudentPlus;
import org.apache.ibatis.annotations.Param;

public class selecteProvider {
    public  String select(@Param("studentPlus")StudentPlus studentPlus){
       StringBuffer sql=  new StringBuffer("select x.id ,x.name,x.sex,x.age,b.bname,x.picture from banjissh b, xueshengbiaossh x where b.id=x.bid");
        if(studentPlus.getName() != null && studentPlus.getName() != ""){
            sql.append(" and x.name=#{studentPlus.name}");
        }
        if(studentPlus.getAge()!=null){
            sql.append(" and x.age=#{studentPlus.age}");
        }
        if(studentPlus.getBid()!= null ){
            sql.append(" and x.bid=#{studentPlus.bid}");
        }

        return sql.toString();
    }

}

