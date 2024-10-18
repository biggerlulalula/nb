package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptContorller {
    @Autowired
    private DeptService deptService;


    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部数据");
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("增加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
