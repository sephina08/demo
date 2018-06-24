package com.ntut.practice.demo.dao;

import com.ntut.practice.demo.entity.Member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    List<Member> selectAll();
    
    Member selectById(@Param("sid") Integer sid);
    
    //用條件查詢資料
    List<Member> selectDataByCondition(Member member);
    
}
