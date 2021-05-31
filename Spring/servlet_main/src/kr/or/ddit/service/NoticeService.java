package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.NoticeVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface NoticeService {

	public NoticeVO listDetailNotice(int nno) throws SQLException;
	
	public List<NoticeVO> listNotice() throws SQLException;
	
	public int insertNotice(NoticeVO mv) throws SQLException;
	
	public int updateNotice(NoticeVO mv) throws SQLException;
	
	public int deleteNotice(int nno) throws SQLException;
}