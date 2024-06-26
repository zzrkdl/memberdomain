package com.zzrkdl.hello_spring;

import com.zzrkdl.hello_spring.aop.TimeTraceAop;
import com.zzrkdl.hello_spring.repository.JpaMemberRepository;
import com.zzrkdl.hello_spring.repository.MemberRepository;
import com.zzrkdl.hello_spring.repository.JdbcMemberRepository;
import com.zzrkdl.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
       // return new JpaMemberRepository(em);

   // }


}
