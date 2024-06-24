package com.zzrkdl.hello_spring.controller;

import com.zzrkdl.hello_spring.domain.Member;
import com.zzrkdl.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class  MemberController {
    
    
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    public String createForm(){
        return"members/createMemberForm";
    }

    @PostMapping("members/new")
    public String createMember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println(member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("members/list")
    public String memberList(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
