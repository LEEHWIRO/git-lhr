package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	public NoticeVO listDetailNotice(SqlSession session,int nno) throws SQLException;
	
	public List<NoticeVO> listNotice(SqlSession session) throws SQLException;
	public List<NoticeVO> listNotice(SqlSession session,Criteria cri) throws SQLException;
	
	public int insertNotice(SqlSession session, NoticeVO mv) throws SQLException;
	
	public int updateNotice(SqlSession session, NoticeVO mv) throws SQLException;
	
	public int deleteNotice(SqlSession session, int nno) throws SQLException;
}
