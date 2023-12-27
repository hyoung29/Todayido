package com.metamong.todayido.service;

import com.metamong.todayido.dao.detailDao;
import com.metamong.todayido.dto.ReviewDto;
import com.metamong.todayido.dto.storeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Slf4j
public class detailService {
    @Autowired
    private detailDao dDao;

    public ModelAndView getReview(int store_num){
        log.info("getReview()");
        ModelAndView mv = new ModelAndView();
        List<storeDto> sList = dDao.selectStore(store_num);
        mv.addObject("sList", sList);
        List<ReviewDto> rList = dDao.selectReview(store_num);
        mv.addObject("rList", rList);

        mv.setViewName("detail");
        return mv;
    }


}
