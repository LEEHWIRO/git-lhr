package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface MemberService {

	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	public MemberVO getMember(String id) throws SQLException;
	
	public List<MemberVO> getMemberList() throws SQLException;
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException;
	public Map<String,Object> getMemberList(SearchCriteria cri) throws SQLException;
	
	
		
	
	public void regist(MemberVO member) throws SQLException;
	
	public int modify(MemberVO member) throws SQLException;
	
	public int remove(String id) throws SQLException;
}