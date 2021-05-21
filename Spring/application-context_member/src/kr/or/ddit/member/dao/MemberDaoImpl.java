package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.dto.MemberVO;


public class MemberDaoImpl implements MemberDao {
	

	@Override
	public MemberVO listDetailMember(SqlSession session, String memId) throws SQLException {
		MemberVO mv = session.selectOne("member.listDetailMember",memId);
		return mv;
	}

	@Override
	public List<MemberVO> listMember(SqlSession session) throws SQLException {
		List<MemberVO> memList = session.selectList("member.listMember");
		return memList;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		int obj = session.insert("member.insertMember", mv);
		
		if(obj == 1) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("member.updateMember", mv);
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		
		cnt = session.delete("member.deleteMember", memId);
		
		return cnt;
	}
	



}
