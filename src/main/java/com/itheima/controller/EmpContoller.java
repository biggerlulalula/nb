package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpContoller {
    @Autowired
    private EmpService empService;
    @GetMapping("emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询，参数：{},{}",pageSize,pageSize);
        PageBean pageBean= empService.page(page,pageSize,name, gender,begin,end);
        return Result.success(pageBean);
    }
    @DeleteMapping("emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping("emps")
        public Result save (@RequestBody Emp emp){
        log.info("新增员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
        }

    }
