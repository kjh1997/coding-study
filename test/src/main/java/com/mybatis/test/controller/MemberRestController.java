package com.mybatis.test.controller;


import com.mybatis.test.dto.NewsDTO;
import com.mybatis.test.entity.NewsEntity;
import com.mybatis.test.repository.INewsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class MemberRestController {

    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private INewsDAO newDAO;

    @GetMapping("/news")
    public Map<String, Object> news() throws Exception {
        Map<String, Object> rtnObj = new HashMap<>();

        List<NewsEntity> newsList = newDAO.listNews();
        logger.info("news->" + newsList.toString());

        rtnObj.put("news_list", newsList);
        return rtnObj;
    }

    @PostMapping("/insert")
    public String insert(@RequestBody NewsDTO newsDTO) {
        NewsEntity news = NewsEntity.builder().journalist(newsDTO.getJournalist()).publisher(newsDTO.getPublisher()).reg_dt(LocalDateTime.now()).title(newsDTO.getTitle()).build();
        System.out.println(newsDTO.toString());
        newDAO.insertNews(newsDTO.getTitle(), newsDTO.getJournalist(), newsDTO.getPublisher(), LocalDateTime.now());
        return "success";
    }

}