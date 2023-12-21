package com.metamong.todayido.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReviewDto {
    private int review_num;
    private String user_id;
    private int store_num;
    private int rating;
    private String review_text;
    private String ower_review_comment;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String rv_oriname;
    private String rv_sysname;
}
