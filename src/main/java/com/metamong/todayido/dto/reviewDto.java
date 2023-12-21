package com.metamong.todayido.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class reviewDto {
    private int review_num;
    private String user_id;
    private int rating;
    private String review_text;
    private String ower_review_comment;
    private Timestamp crated_at;
    private Timestamp update_at;
    private String rv_oriname;
    private String rv_sysname;
}
