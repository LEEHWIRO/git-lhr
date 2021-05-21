package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dto.MemberVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface IMemberService {

	public MemberVO listDetailMember(String memId) throws SQLException;
	
	public List<MemberVO> listMember() throws SQLException;
	
	public int insertMember(MemberVO mv) throws SQLException;
	
	public int updateMember(MemberVO mv) throws SQLException;
	
	public int deleteMember(String memId) throws SQLException;
}