package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	public List<MemberVO> selectMemberList(SqlSession session,Criteria cri) throws SQLException;
	public List<MemberVO> selectMemberList(SqlSession session,SearchCriteria cri) throws SQLException;
	
	public int selectMemberListCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	public int updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	public int deleteMember(SqlSession session, String id) throws SQLException;
	
}
