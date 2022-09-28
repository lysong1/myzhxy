package com.atguigu.myzhxy.controller;

import com.atguigu.myzhxy.pojo.Grade;
import com.atguigu.myzhxy.service.GradeService;
import com.atguigu.myzhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyusong
 * @create 2022-06-06 20:47
 */
@Api(tags = "年级控制器")
@RestController
@RequestMapping("sms/gradeController")
public class GradeController {

    @Autowired
    GradeService gradeService;

    //    GET /sms/gradeController/getGrades
    @ApiOperation("获取全部年级")
    @GetMapping("/getGrades")
    public Result getGrades() {
        List<Grade> list = gradeService.getGrades();

        return Result.ok(list);
    }


    @ApiOperation("获取全部年级")
    @DeleteMapping("/deleteGrade")
    public Result deleteGrade(
            @ApiParam("要删除的所有的grade的id的JSON集合") @RequestBody List<Integer> ids) {

        gradeService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("新增或修改grade,有id属性")
    @PostMapping("saveOrUpdateGrade")
    public Result saveOrUpdateGrade(
            @ApiParam("JSON的Grade对象") @RequestBody Grade grade) {
        gradeService.saveOrUpdate(grade);

        return Result.ok();
    }


    //    sms/gradeController/getGrades/1/3?gradeName=%E4%B8%89
    @ApiOperation("根据年级名称模糊查询,带分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGrades(
            @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询模糊匹配的名称") @RequestParam(value = "gradeName", required = false) String gradeName) {
        Page<Grade> page = new Page<>(pageNo, pageSize);

        IPage<Grade> iPage = gradeService.getGradeByOpr(page, gradeName);

        return Result.ok(iPage);
    }


}
