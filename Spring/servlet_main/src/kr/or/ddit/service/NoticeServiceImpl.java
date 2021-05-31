package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService{

	private NoticeDAO noticeDAO; // = new MemberDaoImpl();
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory; // = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public NoticeVO listDetailNotice(int nno) throws SQLException {
		NoticeVO mv = null;
		SqlSession session = sqlSessionFactory.openSession();

		mv = noticeDAO.listDetailNotice(session, nno);
		session.close();
		
		return mv;
	}

	@Override
	public List<NoticeVO> listNotice() throws SQLException {
		List<NoticeVO> noticeList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		noticeList = noticeDAO.listNotice(session);
		session.close();
		
		return noticeList;
	}

	@Override
	public int insertNotice(NoticeVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDAO.insertNotice(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDAO.updateNotice(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteNotice(int nno) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDAO.deleteNotice(session, nno);
		session.close();
		
		return cnt;
	}

	@Override
	public List<NoticeVO> listNotice(Criteria cri) throws SQLException {
		List<NoticeVO> noticeList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		noticeList = noticeDAO.listNotice(session,cri);
		session.close();
		
		return noticeList;
	}



}
