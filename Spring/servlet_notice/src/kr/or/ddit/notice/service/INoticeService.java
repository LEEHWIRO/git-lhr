package kr.or.ddit.notice.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.notice.dto.NoticeVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface INoticeService {

	public NoticeVO listDetailNotice(int nno) throws SQLException;
	
	public List<NoticeVO> listNotice() throws SQLException;
	
	public int insertNotice(NoticeVO mv) throws SQLException;
	
	public int updateNotice(NoticeVO mv) throws SQLException;
	
	public int deleteNotice(int nno) throws SQLException;
}