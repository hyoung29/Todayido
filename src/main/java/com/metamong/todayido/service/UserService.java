package com.metamong.todayido.service;

import com.metamong.todayido.dao.UserDao;
import com.metamong.todayido.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDao uDao;

    private final BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();

    public String idCheck(String userid){
        log.info("idCheck()");
        String result = null;
        int mcnt = uDao.selectId(userid);
        if(mcnt == 0){
            result = "ok";
        } else {
            result = "fail";
        }
        return result;
    }
    public String userJoin(UserDto user, RedirectAttributes rttr){
        log.info("UserJoin()");
        String view = null;
        String msg = null;

        String encPwd = pEncoder.encode(user.getUser_password());

        user.setUser_password(encPwd);
        try {
            uDao.insertUser(user);
            msg = "가입 성공";
            view = "redirect:joinForm";
        } catch (Exception e){
            e.printStackTrace();
        }
        rttr.addFlashAttribute("msg", msg);
        return view;
    }
    public String loginProc(UserDto user, HttpSession session, RedirectAttributes rttr){
        log.info("loginProc()");
        String view = null;
        String msg = null;

        String encPwd = uDao.selectPassword(user.getUser_id());
        if(encPwd != null){

            if(pEncoder.matches(user.getUser_password(), encPwd)){
                user = uDao.selectUser(user.getUser_id());
                session.setAttribute("user", user);
                view = "redirect:boardList?pageNum=1";
                msg = "로그인 성공";
            } else {
                view = "redirect:loginForm";
                msg = "비밀번호가 틀립니다";
            }
        } else {
            view = "redirect:loginForm";
            msg = "존재하지 않는 아이디입니다";
        }

        rttr.addFlashAttribute("msg", msg);
        return view;
    }

    public String logout(HttpSession session) {
        log.info("logout()");
        session.invalidate();
        return "redirect:/";
    }
}