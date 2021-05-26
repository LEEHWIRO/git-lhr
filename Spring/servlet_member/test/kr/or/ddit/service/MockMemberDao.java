package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dto.MemberVO;

public class MockMemberDao implements MemberDao {

	@Override
	public MemberVO listDetailMember(SqlSession session, String memId) throws SQLException {
		MemberVO member = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		if(memId.equals("lhro95")) {
			member = new MemberVO();
			member.setMemPass("1234");
		}
		
		return member;
	}

	@Override
	public List<MemberVO> listMember(SqlSession session) throws SQLException {
		List<MemberVO> memberList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		
		MemberVO member = new MemberVO();
		member.setMemPass("1234");
		
		memberList= new ArrayList<MemberVO>();
		memberList.add(member);
		
		return memberList;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		if(mv.getMemId().equals("p002123456")) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		if(mv.getMemId().equals("jiro110516")) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		if(memId.equals("lhro95")) {
			cnt = 1;
		}
		
		return cnt;
	}

}