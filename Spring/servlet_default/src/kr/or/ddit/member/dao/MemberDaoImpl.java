package kr.or.ddit.member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;


public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memDao;
	
	private MemberDaoImpl() {
		
	}
	
	public static MemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		
		return memDao;
	}
	
	@Override
	public MemberVO selectMemberByID(SqlMapClient smc, String id) 
			throws SQLException{
		MemberVO mv = (MemberVO) smc.queryForList("member.selectMemberById", id);
		return mv;
	}



}
