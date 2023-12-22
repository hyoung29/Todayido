package com.metamong.todayido.dao;

import com.metamong.todayido.dto.ReviewDto;
import com.metamong.todayido.dto.storeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface detailDao {
    //스토어 가져오는 메소드
    List<storeDto> seleteStore(int storeNum);

    List<ReviewDto> seletereview(int storeNum);
}
