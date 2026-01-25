package com.staredu.grammar.service;

import com.staredu.grammar.repository.JdbcMemberRepository;
import com.staredu.grammar.repository.JpaMemberRepository;
import com.staredu.grammar.repository.MemberRepository;
import com.staredu.grammar.repository.MemoryMemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//    private final EntityManager em;

//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}