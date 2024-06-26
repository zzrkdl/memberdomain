package com.zzrkdl.hello_spring.service;

import com.zzrkdl.hello_spring.domain.Member;
import com.zzrkdl.hello_spring.repository.MemberRepository;
import com.zzrkdl.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired   MemberRepository memoryMemberRepository;



    @Test
   // @Commit
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring10");
        //when
        Long saveId =  memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //        try{
//            memberService.join(member2);
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

    }


}