package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
   /* @Select("select count(*) from mybatis.emp")
    public Long count();
    @Select("select * from mybatis.emp LIMIT #{start},#{pagesize}")
    public List<Emp> page(Integer start,Integer pagesize);*/
    /*@Select("select * from mybatis.emp")*/
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    /*批量删除的方法*/
    void delete(List<Integer> ids);
    @Insert("insert into mybatis.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);
}
