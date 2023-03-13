package com.mybatis.test.controller;

import com.mybatis.test.dto.NewsDTO;
import com.mybatis.test.entity.NewsEntity;
import com.mybatis.test.repository.INewsDAO;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private INewsDAO newDAO;

    @GetMapping("/news")
    public @ResponseBody Map<String, Object> news() throws Exception {
        Map<String, Object> rtnObj = new HashMap<>();

        List<NewsEntity> newsList = newDAO.listNews();
        logger.info("news->" + newsList.toString());

        rtnObj.put("news_list", newsList);
        return rtnObj;
    }

    @GetMapping("/news/date")
    public @ResponseBody Map<String, Object> news2() throws Exception {
        Map<String, Object> rtnObj = new HashMap<>();

        List<NewsEntity> newsList = newDAO.withExample(LocalDateTime.now().minusDays(1));
        logger.info("news->" + newsList.toString());

        rtnObj.put("news_list", newsList);
        return rtnObj;
    }


    @GetMapping("/news/insert")
    public @ResponseBody Map<String, Object> insertData() {

        NewsEntity news = NewsEntity.builder()
                .publisher("kjh").journalist("kbs").reg_dt(LocalDateTime.now()).title(LocalDateTime.now().toString() + " now")
                .build();
        newDAO.insertNews(news);

        List<NewsEntity> newsList = newDAO.listNews();
        logger.info("news->" + newsList.toString());
        Map<String, Object> rtnObj = new HashMap<>();
        rtnObj.put("news_list", newsList);
        return rtnObj;
    }

    @GetMapping("/news/{id}")
    public @ResponseBody ResponseEntity<NewsDTO> newsfindById(@PathVariable("id") String i) {
        NewsDTO news = newDAO.findById(Integer.parseInt(i));
        return ResponseEntity.ok(news);
    }



}