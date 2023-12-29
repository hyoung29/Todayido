package com.metamong.todayido.dao;

import com.metamong.todayido.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDao {
    List<StoreDto> storeInfo(int storeNum);
    StoreDto select(String position_x);

}
