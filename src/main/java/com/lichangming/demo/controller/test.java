package com.lichangming.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: lichangming
 * @Date: 2018/11/13 11:31
 */
@RestController
@Api("测试用例")
public class test {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping(value = "/")
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/redistest")
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    public String redistest() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","lichangming");
        map.put("age",18);
        map.put("slogan","帅");
        redisTemplate.opsForValue().set("user",map);
        return "添加成功";
    }
}
