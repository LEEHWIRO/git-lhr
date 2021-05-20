package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements IMemberService{

	private MemberDao memDao = new MemberDaoImpl();
	
	public void setMenuDAO(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessioFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public MemberVO listDetailMember(String memId) throws SQLException {
		MemberVO mv = null;
		SqlSession session = sqlSessionFactory.openSession();

		mv = memDao.listDetailMember(session, memId);
		session.close();
		
		return mv;
	}

	@Override
	public List<MemberVO> listMember() throws SQLException {
		List<MemberVO> memList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		memList = memDao.listMember(session);
		session.close();
		
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.insertMember(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.updateMember(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.deleteMember(session, memId);
		session.close();
		
		return cnt;
	}



}
