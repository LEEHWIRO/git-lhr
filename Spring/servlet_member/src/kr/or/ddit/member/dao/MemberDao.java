package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberDao {
	
	public MemberVO listDetailMember(String memId) throws Exception;
	
	public List<MemberVO> listMember() throws Exception;
	
	public int insertMember(MemberVO mv) throws Exception;
	
	public int updateMember(MemberVO mv) throws Exception;
	
	public int deleteMember(String memId) throws Exception;
}
