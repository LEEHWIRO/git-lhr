package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

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
	public MemberVO listDetailMember(SqlMapClient smc, String memId) throws SQLException {
		MemberVO mv = (MemberVO) smc.queryForObject("member.listDetailMember",memId);
		return mv;
	}

	@Override
	public List<MemberVO> listMember(SqlMapClient smc) throws SQLException {
		List<MemberVO> memList = smc.queryForList("member.listMember");
		return memList;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("member.insertMember", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cnt = 0;
		cnt = smc.update("member.updateMember", mv);
		return cnt;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt = 0;
		cnt = smc.delete("member.deleteMember", memId);
		return cnt;
	}
	



}
