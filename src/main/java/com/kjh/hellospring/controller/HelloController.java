package com.kjh.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;

@Controller
public class HelloController {
    @GetMapping("hello")
    public  String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // RequestParam : 웹 url에서 입력값을 받아옴
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody  // api 방식임. 데이터 쏴주는 역할
    public String helloString(@RequestParam("name") String name){
        return "hello ㅎㅇㄶㅁㅁㄴㅇㄻㄴ" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }
    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }



}
