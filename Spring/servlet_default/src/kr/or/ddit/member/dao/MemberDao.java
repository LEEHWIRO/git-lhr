package kr.or.ddit.member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberDao {

	
	MemberVO selectMemberByID(SqlMapClient smc, String id) throws SQLException;
}
