package com.metamong.todayido.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class storeDto {
    private int store_num;
    private String store_name;
    private String telephone;
    private String store_adress;
    private int store_category_id;
    private int average_rating;
    private String store_description;
    private String open_time;
    private String closed_day;
    private String owner_name;
    private String business_num;
    private Timestamp create_at;
    private Timestamp update_at;
}