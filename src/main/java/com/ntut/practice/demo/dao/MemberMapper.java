package com.ntut.practice.demo.dao;

import com.ntut.practice.demo.entity.Member;

import java.util.List;

public interface MemberMapper {
    List<Member> selectAll();
}
