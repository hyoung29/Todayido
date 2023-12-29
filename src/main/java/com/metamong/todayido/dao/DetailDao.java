package com.metamong.todayido.dao;

import com.metamong.todayido.dto.ReviewDto;
import com.metamong.todayido.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailDao {
    //스토어 가져오는 메소드
    List<StoreDto> selectStore(int storeNum);

    List<ReviewDto> selectReview(int storeNum);
}
