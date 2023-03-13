package com.mybatis.test.dto;

import lombok.Data;

@Data
public class NewsDTO {
    private Integer id;

    private String title;
    private String journalist;
    private String publisher;

    @Override
    public String toString() {
        return "newDTO : " + " | " + this.journalist + " | " + this.publisher + " | " + this.title;

    }
}
