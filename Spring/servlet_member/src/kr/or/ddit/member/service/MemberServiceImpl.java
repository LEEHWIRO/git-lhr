package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class MemberServiceImpl implements IMemberService{

	// 사용할 DAO의 객체변수를 선언한다.
	private MemberDao memDao;
	private SqlMapClient smc;
	
	private static IMemberService memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		
		return memService;
	}

	@Override
	public MemberVO listDetailMember(String memId) throws SQLException {
		MemberVO mv = memDao.listDetailMember(smc, memId);
		return mv;
	}

	@Override
	public List<MemberVO> listMember() throws SQLException {
		List<MemberVO> memList = memDao.listMember(smc);
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		cnt = memDao.insertMember(smc, mv);
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		cnt = memDao.updateMember(smc, mv);
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		int cnt = 0;
		cnt = memDao.deleteMember(smc, memId);
		return cnt;
	}



}
