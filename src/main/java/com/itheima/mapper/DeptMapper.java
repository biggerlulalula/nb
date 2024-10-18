package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*查询全部部门*/
    @Select("select * from mybatis.dept")
    List<Dept> list();
/*根据id删除*/
    @Delete("delete from mybatis.dept where id=#{id}")
    void deleteById(Integer id);
/*新增*/
    @Insert("insert into mybatis.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    @Update("update mybatis.dept set name=#{name},create_time=#{createTime},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
