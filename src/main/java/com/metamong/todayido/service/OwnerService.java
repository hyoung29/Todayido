package com.metamong.todayido.service;

import com.metamong.todayido.dao.OwnerDao;
import com.metamong.todayido.dto.OwnerDto;
import com.metamong.todayido.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Slf4j
public class OwnerService {
    @Autowired
    private OwnerDao oDao;

    private final BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();

    public String ownerJoin(OwnerDto owner, RedirectAttributes rttr) {
        log.info("OwnerJoin()");
        String view = null;
        String msg = null;

        String encPwd = pEncoder.encode(owner.getOwner_pwd());

        owner.setOwner_pwd(encPwd);
        try {
            oDao.insertOwner(owner);
            msg = "가입 성공";
            view = "redirect:ownerLogin";
        } catch (Exception e){
            e.printStackTrace();
        }
        rttr.addFlashAttribute("msg", msg);
        return view;
    }
    public String ownerloginProc(OwnerDto owner, HttpSession session, RedirectAttributes rttr){
        log.info("ownerloginProc()");
        String view = null;
        String msg = null;

        String rPwd = owner.getOwner_pwd();
        String encPwd = oDao.selectPassword(owner.getOwner_id());
        if(encPwd != null){

            if(pEncoder.matches(rPwd, encPwd)){
                owner = oDao.selectOwner(owner.getOwner_id());
                session.setAttribute("owner", owner);
                view = "redirect:pindex";
                msg = "로그인 성공";
            } else {
                view = "redirect:ownerLogin";
                msg = "비밀번호가 틀립니다";
            }
        } else {
            view = "redirect:ownerLogin";
            msg = "존재하지 않는 아이디입니다";
        }

        rttr.addFlashAttribute("msg", msg);
        return view;
    }
}
