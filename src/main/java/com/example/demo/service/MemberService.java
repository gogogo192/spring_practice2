package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        //같은 이름이 있는 중복 회원x
        Optional<Member> result  = memberRepository.findByName(member.getName());
        memberRepository.save(member);
        return member.getId();
    }

}
