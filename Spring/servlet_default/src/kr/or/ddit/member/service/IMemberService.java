package kr.or.ddit.member.service;

import java.sql.SQLException;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundException;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface IMemberService {

	public MemberVO login(String memId, String memPass) 
			throws NotFoundException, InvalidPasswordException, SQLException;
}
