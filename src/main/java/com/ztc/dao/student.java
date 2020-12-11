package com.ztc.dao;

import com.ztc.Provider.selecteProvider;
import com.ztc.pojo.Classx;
import com.ztc.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface student {
    //学生表单个查询
    @Select("select * from xueshengbiaossh ")
     public List<Student> queryAll( Student student);
    //查询所有学生班级
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column ="name",property ="name"),
            @Result(column = "sex",property ="sex"),
            @Result(column = "age",property = "age"),
            @Result(column ="bname",property ="classx.bname")
    })
    @Select("select x.id ,x.name,x.sex,x.age,b.bname from banjissh b, xueshengbiaossh x where b.id=x.bid")
    public List<Student> query();


    //添加查询班级
   @Select("select * from banjissh ")
    public List<Classx> queryclassx();

   //添加
   @SelectKey(statement="select LAST_INSERT_ID()", before=true,resultType=int.class,keyProperty="id")
   @Insert("insert into xueshengbiaossh (id,name,sex,age,bid) values (null,#{name},#{sex},#{age},#{bid})")
   public void add(Student student);

   //修改查询
    @Select("select * from xueshengbiaossh where id=#{id}")
    public Student getByid(int id);
// 修改数据
    @Update("update xueshengbiaossh set name=#{name}, sex=#{sex}, age=#{age}, bid=#{bid} where id=#{id}")
    public void update(Student student);
    //模糊查询+查询
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column ="name",property ="name"),
            @Result(column = "sex",property ="sex"),
            @Result(column = "age",property = "age"),
            @Result(column ="bname",property ="classx.bname")
    })
    @SelectProvider(type= selecteProvider.class,method = "select")
    public List<Student> fuzzyQuery(Student student);
    //删除
    @Delete("delete from xueshengbiaossh where id=#{id}")
    public void delete(int id);
}
