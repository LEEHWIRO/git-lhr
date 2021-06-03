package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	public NoticeVO selectNoticeByNno(SqlSession session,int nno) throws SQLException;
	
	public List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException;
	public List<NoticeVO> selectNoticeList(SqlSession session,Criteria cri) throws SQLException;
	public List<NoticeVO> selectNoticeList(SqlSession session,SearchCriteria cri) throws SQLException;
	
	public int selectNoticeListCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	public void insertNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	public int updateNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	public int deleteNotice(SqlSession session, int nno) throws SQLException;
}
