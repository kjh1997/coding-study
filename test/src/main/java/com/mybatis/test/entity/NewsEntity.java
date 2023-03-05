package com.mybatis.test.entity;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewsEntity {
    private String title;
    private String journalist;
    private String publisher;
    private LocalDateTime reg_dt;
}