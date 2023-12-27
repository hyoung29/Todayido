package com.metamong.todayido.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CategoryController {
    @GetMapping("ownerlogin")
    public String ownerlogin(){
        log.info("ownerlogin()");
        return "ownerlogin";
    }
}
