package kr.or.ddit.member.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundException;

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
	public MemberVO login(String id, String pwd) 
										throws NotFoundException, 
										InvalidPasswordException, 
										SQLException {
		
		MemberVO member = null;
		try {
			member = memDao.selectMemberByID(smc, id);
		}catch(Exception e) {
			//Exception 에 대한 처리 구문
			throw e;
		}
		
		return member;
//		if(member != null) {
//			if(pwd.equals(member.getMemPass())) {//로그인성공
//				return member;
//			}else {// 패스워드 불일치
//				throw new InvalidPasswordException();
//			}
//		}else {// 아이디 불일치
//			throw new NotFoundException();
//		}
	}


}
