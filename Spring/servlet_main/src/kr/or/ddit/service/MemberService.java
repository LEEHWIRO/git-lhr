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

	public MemberVO listDetailMember(String memId) throws SQLException;
	
	public List<MemberVO> listMember() throws SQLException;
	public List<MemberVO> listMember(Criteria cri) throws SQLException;
	Map<String,Object> getMemberList(SearchCriteria cri) throws SQLException;
	
	public int insertMember(MemberVO mv) throws SQLException;
	
	public int updateMember(MemberVO mv) throws SQLException;
	
	public int deleteMember(String memId) throws SQLException;
	
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
		
	public MemberVO getMember(String id) throws SQLException;
}