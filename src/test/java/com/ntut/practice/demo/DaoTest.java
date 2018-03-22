package com.ntut.practice.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntut.practice.demo.dao.member.InterestDao;
import com.ntut.practice.demo.dao.member.MemberDao;
import com.ntut.practice.demo.dao.member.ZoneDao;
import com.ntut.practice.demo.model.member.InterestBean;
import com.ntut.practice.demo.model.member.MemberBean;
import com.ntut.practice.demo.model.member.ZoneBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = NONE)
public class DaoTest {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private InterestDao interestDao;
    @Autowired
    private ZoneDao zoneDao;
    @Test
    public void insertInTo() {
        MemberBean bean = new MemberBean();
        bean.setUserEmail("az@zz");
        bean.setUserFirstName("張");
        bean.setuserLastName("敏敏");
        bean.setUserPasswd("b1b1b1b1");
        bean.setUserMobile("09123456");
        bean.setUserTel("279876543");
        bean.setUserTelExt("222");
        memberDao.insertUser(bean);

    }
    
    @Test
	public void updateConsuner() {
		MemberBean bean = new MemberBean();
		bean.setUserEmail("aa@aa");
		bean.setuserLastName("廖");
		bean.setUserFirstName("添添");
		bean.setUserMobile("09876543");
		bean.setUserTel("2345678");
		bean.setUserTelExt("111");
		bean.setUserAddress("西門町");
		int updateUser = memberDao.updateUser(bean);
		assertThat(updateUser).isEqualTo(1);
	}

	@Test
	public void getMemberByTest() {
		MemberBean member = memberDao.getMemberByEmail("aa@aa");
		assertThat(member.getUserEmail()).isEqualTo("aa@aa");
	}
	
	@Test
	public void getAllMember(){
		List<MemberBean> allMember = memberDao.getAllMember();
		assertThat(allMember).isNotEmpty();
	}
	
	
	@Test
	public void deleteMember(){
		memberDao.delete("dd@dd");
	}
	
	
	@Test
	public void getAllInterest(){
		List<InterestBean> allInterest = interestDao.getAllInterest();
		assertThat(allInterest).isNotEmpty();
	}
	@Test
	public void getZoneParent(){
		List<ZoneBean> zoneParentByZoneOid = zoneDao.getZoneParentByZoneOid("1");
	}
	

}
