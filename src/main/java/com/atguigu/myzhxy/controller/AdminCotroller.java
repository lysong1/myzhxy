package com.atguigu.myzhxy.controller;

import com.atguigu.myzhxy.pojo.Admin;
import com.atguigu.myzhxy.service.AdminService;
import com.atguigu.myzhxy.util.MD5;
import com.atguigu.myzhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyusong
 * @create 2022-06-06 20:46
 */
@RestController
@RequestMapping("sms/adminController")
public class AdminCotroller {

    @Autowired
    AdminService adminService;

    //    DELETE /sms/adminController/deleteAdmin [158]
    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(@RequestBody List<Integer> ids) {

        adminService.removeByIds(ids);

        return Result.ok();
    }


    //    POST /sms/adminController/saveOrUpdateAdmin
    @PostMapping("/saveOrUpdateAdmin")
    public Result saveOrUpdateAdmin(@RequestBody Admin admin) {
        Integer id = admin.getId();

        if (id == null || id == 0) {
            admin.setPassword(MD5.encrypt(admin.getPassword()));
        }

        adminService.saveOrUpdate(admin);

        return Result.ok();
    }


    //    GET /sms/adminController/getAllAdmin/1/3?adminName=admin
    @GetMapping("getAllAdmin/{pageNo}/{pageSize}")
    public Result getAllAdmin(@PathVariable("pageNo") Integer pageNo,
                              @PathVariable("pageSize") Integer pageSize,
                              @RequestParam(value = "adminName", required = false) String adminName) {
        Page<Admin> page = new Page<>(pageNo, pageSize);
        IPage<Admin> iPage = adminService.getAdminByOpr(page, adminName);
        return Result.ok(iPage);
    }

}
