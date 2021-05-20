package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.dto.MemberVO;

public interface MemberDao {
	
	public MemberVO listDetailMember(SqlSession session,String memId) throws SQLException;
	
	public List<MemberVO> listMember(SqlSession session) throws SQLException;
	
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException;
	
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException;
	
	public int deleteMember(SqlSession session, String memId) throws SQLException;
}
