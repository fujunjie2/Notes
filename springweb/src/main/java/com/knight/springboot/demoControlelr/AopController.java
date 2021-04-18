package com.knight.springboot.demoControlelr;


import com.knight.springboot.demoControlelr.DemoServices.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class AopController {

    private final DemoService demoService;

    @GetMapping("simple")
    public void simple() {
        demoService.simpleMethod();
    }
    @GetMapping("complex")
    public void complex() {
        demoService.trancMethod();
    }

}
