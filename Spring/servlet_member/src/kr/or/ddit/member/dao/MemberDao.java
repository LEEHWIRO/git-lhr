package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberDao {
	
	public MemberVO listDetailMember(SqlMapClient smc, String memId) throws SQLException;
	
	public List<MemberVO> listMember(SqlMapClient smc) throws SQLException;
	
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException;
}
