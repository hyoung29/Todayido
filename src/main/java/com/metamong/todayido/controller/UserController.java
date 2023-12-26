package com.metamong.todayido.controller;

import com.metamong.todayido.dto.UserDto;
import com.metamong.todayido.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService uServ;

    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "index";
    }
    @GetMapping("joinForm")
    public String joinForm(){
        log.info("joinForm()");
        return "joinForm";
    }
    @PostMapping("joinProc")
    public String joinProc(UserDto user, RedirectAttributes rttr) {
        log.info("joinProc()");
        String view = uServ.userJoin(user, rttr);
        return view;
    }
    @GetMapping("findId")
    public String findId(){
        log.info("findId()");
        return "findId";
    }
    @GetMapping("findPw")
    public String findPw(){
        log.info("findPw()");
        return "findPw";
    }
    @GetMapping("loginForm")
    public String loginForm(){
        log.info("loginForm()");
        return "loginForm";
    }
    @PostMapping("loginProc")
    public String loginProc(UserDto user, HttpSession session, RedirectAttributes rttr){
        log.info("loginProc()");
        String view = uServ.loginProc(user, session, rttr);
        return view;
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        log.info("logout()");
        String view = uServ.logout(session);
        return view;
    }
    @GetMapping("detail")
    public String detail(){
        log.info("detail()");
        return "detail";
    }
    @GetMapping("myPage")
    public String myPage(){
        log.info("myPage()");
        return "myPage";
    }
}
