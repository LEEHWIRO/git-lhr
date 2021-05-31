package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO; // = new MemberDaoImpl();
	private SqlSessionFactory sqlSessionFactory; // = new OracleMyBatisSqlSessionFactory();
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public MemberVO listDetailMember(String memId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.listDetailMember(session, memId);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public List<MemberVO> listMember() throws SQLException {
		List<MemberVO> memberList = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberList = memberDAO.listMember(session);
			return memberList;
		}finally {
			session.close();
		}
	}
	@Override
	public List<MemberVO> listMember(Criteria cri) throws SQLException {
		List<MemberVO> memberList = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberList = memberDAO.listMember(session,cri);
			return memberList;
		}finally {
			session.close();
		}
	}

	@Override
	public int insertMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memberDAO.insertMember(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memberDAO.updateMember(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memberDAO.deleteMember(session, memId);
		session.close();
		
		return cnt;
	}
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			if (member == null) 
				throw new NotFoundIDException();
			if (!pwd.equals(member.getPwd()))
				throw new InvalidPasswordException();
		} finally {
			session.close();
		}
		
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
	}



}
