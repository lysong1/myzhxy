package com.atguigu.myzhxy.service;

import com.atguigu.myzhxy.pojo.Clazz;
import com.atguigu.myzhxy.pojo.Grade;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author liuyusong
 * @create 2022-06-06 19:46
 */
public interface ClazzService extends IService<Clazz> {

    IPage<Clazz> getClazzByOpr(Page<Clazz> page, Clazz clazz);

    List<Clazz> getClazzs();
}
