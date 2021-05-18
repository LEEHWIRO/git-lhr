package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	// 사용할 DAO의 객체변수를 선언한다.
	private MemberDao memDao;
	
	private static IMemberService memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		
		return memService;
	}

	@Override
	public MemberVO listDetailMember(String memId) throws Exception {
		MemberVO mv = memDao.listDetailMember(memId);
		return mv;
	}

	@Override
	public List<MemberVO> listMember() throws Exception {
		List<MemberVO> memList = memDao.listMember();
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) throws Exception {
		int cnt = 0;
		cnt = memDao.insertMember(mv);
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws Exception {
		int cnt = 0;
		cnt = memDao.updateMember(mv);
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws Exception {
		int cnt = 0;
		cnt = memDao.deleteMember(memId);
		return cnt;
	}



}
