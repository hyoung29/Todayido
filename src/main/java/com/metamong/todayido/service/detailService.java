package com.metamong.todayido.service;

import com.metamong.todayido.dao.DetailDao;
import com.metamong.todayido.dto.ReviewDto;
import com.metamong.todayido.dto.StoreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Slf4j
public class DetailService {
    @Autowired
    private DetailDao dDao;

    public ModelAndView getReview(int store_num){
        log.info("getReview()");
        ModelAndView mv = new ModelAndView();
        StoreDto store = dDao.selectStore(store_num);
        mv.addObject("store", store);

        List<ReviewDto> rList = dDao.selectReview(store_num);
        mv.addObject("rList", rList);

        mv.setViewName("detail");
        return mv;
    }

    public ReviewDto ReviewInsert(ReviewDto review) {
        log.info("ReviewInsert");

        try {
            dDao.insertReview(review);
            review = dDao.selectLastReview(review.getReview_num());
        } catch (Exception e){
            e.printStackTrace();
            review = null;
        }
        return review;
    }
}