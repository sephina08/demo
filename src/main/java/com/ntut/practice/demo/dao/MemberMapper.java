package com.ntut.practice.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ntut.practice.demo.entity.City;
import com.ntut.practice.demo.entity.Interests;
import com.ntut.practice.demo.entity.Member;
import com.ntut.practice.demo.entity.Zone;

public interface MemberMapper {
    List<Member> selectAll();
    
    Member selectById(@Param("sid") Integer sid);
    
    //用條件查詢資料
    List<Member> selectDataByCondition(Member member);
    
    //新增會員
    Integer insertMember(Member member);
    
    //查全部縣市下拉式選單
    List<City> selectCity();
    
    //查全部區域下拉式選單 
    List<Zone> selectZone();
    
    //依使用者選城市找區域
    List<Zone> selectZoneByCityId(@Param("cityOid") Integer cityOid);
    
    //找全部興趣的checkbox
    List<Interests> selectAllInterests();
    
    //刪除一筆或多筆資料
    Integer deleteMember(@Param("sids") List<String> sids);
    
    //修改會員 
    Integer editMemeber(Member member);
}
