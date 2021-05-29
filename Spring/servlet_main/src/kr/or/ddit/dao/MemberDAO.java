package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	public MemberVO listDetailMember(SqlSession session,String memId) throws SQLException;
	
	public List<MemberVO> listMember(SqlSession session) throws SQLException;
	
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException;
	
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException;
	
	public int deleteMember(SqlSession session, String memId) throws SQLException;
	
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
}
