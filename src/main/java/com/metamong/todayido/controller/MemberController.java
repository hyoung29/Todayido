package com.metamong.todayido.controller;

import com.aidata.springboard02.dto.MemberDto;
import com.aidata.springboard02.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberService mServ;

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
    @PostMapping("joinProc")
    public String joinProc(MemberDto member, RedirectAttributes rttr) {
        log.info("joinProc()");
        String view = mServ.memberJoin(member, rttr);
        return view;
    }
    @GetMapping("loginForm")
    public String loginForm(){
        log.info("loginForm()");
        return "loginForm";
    }
    @PostMapping("loginProc")
    public String loginProc(MemberDto member, HttpSession session, RedirectAttributes rttr){
        log.info("loginProc()");
        String view = mServ.loginProc(member, session, rttr);
        return view;
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        log.info("logout()");
        String view = mServ.logout(session);
        return view;
    }
}
