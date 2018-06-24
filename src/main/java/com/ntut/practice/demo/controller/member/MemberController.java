package com.ntut.practice.demo.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntut.practice.demo.dao.MemberMapper;
import com.ntut.practice.demo.entity.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;
	
	@GetMapping("/select")
	@ResponseBody
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
	@ResponseBody
	public Member select(@PathVariable("sid") Integer sid) {
		return memberMapper.selectById(sid);
	}

	@GetMapping("/selectAll")
	@ResponseBody
	public List<Member> selectAll() {
		return memberMapper.selectAll();
	}

	@GetMapping("/selectById")
	@ResponseBody
	public Member selectById(@RequestParam("id") Integer id) {
		return memberMapper.selectById(id);
	}

	// 用條件查詢資料
	@PostMapping("/selectDataByCondition")
	@ResponseBody
	public List<Member> selectDataByCondition(@RequestBody Member member) {
		return memberMapper.selectDataByCondition(member);

	}
}
