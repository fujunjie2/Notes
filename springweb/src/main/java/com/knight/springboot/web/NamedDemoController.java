package com.knight.springboot.web;


import com.knight.springboot.pojo.vo.NamedVo;
import com.knight.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class NamedDemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getNames")
    public NamedVo getList() {
        System.out.println("--------------start----------------");
//        NamedVo vo = new NamedVo();
//                vo.setCity(1);
        return demoService.getNameVo();
    }
}
