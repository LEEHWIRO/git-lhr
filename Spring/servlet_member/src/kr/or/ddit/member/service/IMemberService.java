package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface IMemberService {

	public MemberVO listDetailMember(String memId) throws Exception;
	
	public List<MemberVO> listMember() throws Exception;
	
	public int insertMember(MemberVO mv) throws Exception;
	
	public int updateMember(MemberVO mv) throws Exception;
	
	public int deleteMember(String memId) throws Exception;
}