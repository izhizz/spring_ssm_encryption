package com.demo.controller;

import com.demo.persistence.dao.TestMapper;
import com.demo.persistence.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@RequestMapping("/test")
@Controller
public class TestController {
    @Autowired
    TestMapper testMapper;
    @ResponseBody
    @RequestMapping("/test")
    public int test(){
        Test test = new Test();
        test.setId(1);
        test.setName("mingcheng");
        return testMapper.insert(test);
    }
}
