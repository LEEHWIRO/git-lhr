package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberDaoImpl {
	
	private SqlSession session;
	private MemberDao memDao;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memDao = new MemberDaoImpl();
	}
	
	@Test
	public void testlistDetailMember() throws SQLException {
		MemberVO mv = memDao.listDetailMember(session, "lhro95");
		Assert.assertEquals("1234", mv.getMemPass());
	}

	@Test
	public void testlistMember() throws SQLException {
		List<MemberVO> memList = memDao.listMember(session);
		Assert.assertEquals(3, memList.size());
	}

	@Test
	public void insertMember() throws SQLException {
		MemberVO mv = new MemberVO();
		
		mv.setMemId("p00212345");
		mv.setMemPass("1234");
		mv.setMemPhone("01011112222");
		mv.setMemEmail("jiro110516@ncavae.com");
		
		int cnt = memDao.insertMember(session, mv);
		
		Assert.assertEquals(1, cnt);
	}

	@Test
	public void updateMember() throws SQLException {
		MemberVO mv = new MemberVO();
		
		mv.setMemId("jiro110516");
		mv.setMemPass("1234");
		mv.setMemPhone("01011112222");
		mv.setMemEmail("jiro110516@ncavae.com");
		
		int cnt = memDao.updateMember(session, mv);
		
		Assert.assertEquals(1, cnt);
	}

	@Test
	public void deleteMember() throws SQLException {
		int cnt = 0;
		
		cnt = memDao.deleteMember(session, "lhro95");
		
		Assert.assertEquals(1, cnt);
		
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
