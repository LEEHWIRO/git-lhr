package kr.or.ddit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberServiceImpl;


public class TestMemberServiceImpl {

	private MemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());
	}
	
	@Test
	public void testlistMember()throws Exception {
		List<MemberVO> memberList = service.listMember();
		
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("1234", memberList.get(0).getPwd());
		
	}
	
	@Test
	public void testlistDetailMember()throws Exception {
		MemberVO member = service.listDetailMember("lhro95");
		
		Assert.assertEquals("1234", member.getPwd());
		
	}
	@Test
	public void testinsertMember()throws Exception {
		MemberVO mv = new MemberVO();
		
		mv.setId("p002123456");
		mv.setPwd("1234");
		mv.setPhone("01011112222");
		mv.setEmail("jiro110516@ncavae.com");
		
		int cnt = service.insertMember(mv);
		
		Assert.assertEquals(1, cnt);
		
	}
	@Test
	public void testupdateMember()throws Exception {
		MemberVO mv = new MemberVO();
		
		mv.setId("jiro110516");
		mv.setPwd("1234");
		mv.setPhone("01011112222");
		mv.setEmail("jiro110516@ncavae.com");
		
		int cnt = service.updateMember(mv);
		
		Assert.assertEquals(1, cnt);
		
	}
	@Test
	public void testdeleteMember()throws Exception {
		
		int cnt = service.deleteMember("lhro95");
		
		Assert.assertEquals(1, cnt);
		
	}
	
	
}
