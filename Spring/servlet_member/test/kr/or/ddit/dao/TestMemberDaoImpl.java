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
	
//	@Test
//	public void testlistDetailMember(String memId) throws SQLException {
//		MemberVO mv = memDao.listDetailMember(session, "veckto");
//		Assert.assertEquals(1, mv);
//	}

	@Test
	public void testlistMember() throws SQLException {
		List<MemberVO> memList = memDao.listMember(session);
		Assert.assertEquals(3, memList.size());
	}

//	@Test
//	public void insertMember(MemberVO mv) throws SQLException {
//		int cnt = 0;
//		
//		int x = memDao.insertMember(session, mv);
//		
//		int obj = session.insert("member.insertMember", mv);
//		
//		if(obj == 1) {
//			cnt = 1;
//		}
//		
//	}
//
//	@Test
//	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
//		int cnt = 0;
//		
//		cnt = session.update("member.updateMember", mv);
//		
//		return cnt;
//	}
//
//	@Test
//	public int deleteMember(SqlSession session, String memId) throws SQLException {
//		int cnt = 0;
//		
//		cnt = session.delete("member.deleteMember", memId);
//		
//		return cnt;
//	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
