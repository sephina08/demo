package com.ntut.practice.demo.controller.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntut.practice.demo.dao.MemberMapper;
import com.ntut.practice.demo.entity.City;
import com.ntut.practice.demo.entity.Interests;
import com.ntut.practice.demo.entity.Member;
import com.ntut.practice.demo.entity.Zone;

@RestController
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;
	
	@GetMapping("/select")
	public List<Member> select() {
		return memberMapper.selectAll();
	}

	/**
	 * localhost:8090/select/1 {id}佔位符
	 * 
	 * @param id
	 * 
	 */
	@GetMapping("/select/{sid}")
	public Member select(@PathVariable("sid") Integer sid) {
		return memberMapper.selectById(sid);
	}

	@GetMapping("/selectAll")
	public List<Member> selectAll() {
		return memberMapper.selectAll();
	}

	@GetMapping("/selectById")
	public Member selectById(@RequestParam("sid") Integer sid) {
		return memberMapper.selectById(sid);
	}

	// 用條件查詢資料
	@PostMapping("/selectDataByCondition")
	public List<Member> selectDataByCondition(@RequestBody Member member) {
		List<Member> selectDataByCondition = memberMapper.selectDataByCondition(member);
		System.out.println(selectDataByCondition);
		return selectDataByCondition;
	}
	 //新增會員
	@PostMapping("/insertMember")
	public Member insertMember(@RequestBody Member member){
		memberMapper.insertMember(member);
		return member;
	}
	//查全部縣市下拉式選單
	@GetMapping("/selectCity")
	public List<City> selectCity(){
		List<City> selectCity = memberMapper.selectCity();
		System.out.println(selectCity);
		return selectCity;		
	}
	 //查全部區域下拉式選單 
	@GetMapping("/selectZone")
	public List<Zone> selectZone(){
		return memberMapper.selectZone();
		
	}
	
	//依使用者選城市找區域
	@GetMapping("/selectZoneByCityId")
	public List<Zone> selectZoneByCityId(@RequestParam("cityOid") Integer cityOid){
		return memberMapper.selectZoneByCityId(cityOid);	
	}
	//找全部興趣的checkbox
	@GetMapping("/selectAllInterests")
	public List<Interests> selectAllInterests(){
		return memberMapper.selectAllInterests();	
	}
	
	//刪除一筆或多筆資料
	@PostMapping("/deleteMember")
	public Integer deleteMember(@RequestBody List<String> sids){
//		System.out.println(map.get("sids").getClass().getSimpleName());  //看型態是什麼
		return memberMapper.deleteMember(sids);		
	}
	
	//修改會員 
	@PostMapping("/editMemeber")
	public Integer editMemeber(@RequestBody Member member){
		return memberMapper.editMemeber(member);
	}
	
}
