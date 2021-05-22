package kr.or.ddit.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.member.dto.MemberVO;

public class TestOracleMyBatisSqlSessionFactory {
	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void init() {
		factory = new OracleMyBatisSqlSessionFactory();
	}
	
	@Before
	public void openSession() {
		session = factory.openSession();
	}
	
	@Test
	public void testSqlSession() throws Exception{
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSQL() {
		MemberVO menu = session.selectOne("member.listDetailMember", "p0021234");
		Assert.assertEquals("1234", menu.getMemPass());
	}
	@Test
	public void testSQLList() {
		List<MemberVO> memList = session.selectList("member.listMember");
		Assert.assertEquals(3, memList.size());
	}
//	@Test
//	public void testSQLInsert() {
//		MemberVO mv = new MemberVO();
//		
//		mv.setMemId("veckto");
//		mv.setMemPass("1234");
//		mv.setMemPhone("01011112222");
//		mv.setMemEmail("jiro110516@ncavae.com");
//		
//		int cnt = session.insert("member.insertMember", mv);
//		
//		Assert.assertEquals(1, cnt);
//	}

//	@Test
//	public void testSQLUpdate() {
//		MemberVO mv = new MemberVO();
//		
//		mv.setMemId("p0021234");
//		mv.setMemPass("1234");
//		mv.setMemPhone("01011112222");
//		mv.setMemEmail("jiro110516@ncavae.com");
//		
//		int cnt = session.update("member.updateMember", mv);
//		
//		Assert.assertEquals(1, cnt);
//	}

//	@Test
//	public void deleteMember() throws SQLException {
//		
//		int cnt = session.delete("member.deleteMember", "jiro110516123425");
//		
//		Assert.assertEquals(1, cnt);
//		
//	}
	
	@After
	public void closeSession() {
		session.rollback();
		session.close();
	}
}
