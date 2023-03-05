package com.mybatis.test.repository;

import com.mybatis.test.entity.NewsEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface INewsDAO {
    public List<NewsEntity> listNews();

    @Insert("INSERT INTO news(title, journalist, publisher,reg_dt) VALUES (#{title},#{journalist},#{publisher},#{reg_dt})")
    void insertNews(String title, String journalist, String publisher, LocalDateTime reg_dt);
}

// INSERT INTO news(title,journalist,publisher,reg_dt)VALUES(title ,journalist ,publisher ,reg_dt );