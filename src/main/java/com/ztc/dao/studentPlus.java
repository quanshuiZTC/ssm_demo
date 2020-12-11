package com.ztc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.Provider.selecteProvider;
import com.ztc.pojo.Student;
import com.ztc.pojo.StudentPlus;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studentPlus extends BaseMapper<StudentPlus> {
    //查询所有
    @Results({
            @Result(column ="bname",property ="classx.bname")
    })

    @SelectProvider(type= selecteProvider.class,method = "select")
    public IPage<StudentPlus> fuzzyQuery(IPage<StudentPlus> page,@Param("studentPlus")StudentPlus studentPlus);


}
