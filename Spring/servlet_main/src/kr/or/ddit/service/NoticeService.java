package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author PC-16
 * 
 */
public interface NoticeService {

	public NoticeVO getNotice(int nno) throws SQLException;
	
	public List<NoticeVO> getNoticeList() throws SQLException;
	public List<NoticeVO> getNoticeList(Criteria cri) throws SQLException;
	public Map<String,Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	public void regist(NoticeVO notice) throws SQLException;
	
	public int modify(NoticeVO notice) throws SQLException;
	
	public int remove(int nno) throws SQLException;
}