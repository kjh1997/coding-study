package com.kjh.hellospring.controller;

import com.kjh.hellospring.domain.Member;
import com.kjh.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 스프링이 뜰때 이 컨트롤러가 생성됨. 자원공유의 개념이라 생각하면 쉬울듯
@Controller
public class MemberController {
   private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}


//    private MemberService memberService;
//
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }
