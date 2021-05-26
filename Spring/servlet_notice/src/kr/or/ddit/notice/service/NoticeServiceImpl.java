package kr.or.ddit.notice.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.dto.NoticeVO;

public class NoticeServiceImpl implements INoticeService{

	private NoticeDao noticeDao; // = new MemberDaoImpl();
	
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	private SqlSessionFactory sqlSessionFactory; // = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public NoticeVO listDetailNotice(int nno) throws SQLException {
		NoticeVO mv = null;
		SqlSession session = sqlSessionFactory.openSession();

		mv = noticeDao.listDetailNotice(session, nno);
		session.close();
		
		return mv;
	}

	@Override
	public List<NoticeVO> listNotice() throws SQLException {
		List<NoticeVO> noticeList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		noticeList = noticeDao.listNotice(session);
		session.close();
		
		return noticeList;
	}

	@Override
	public int insertNotice(NoticeVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDao.insertNotice(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO mv) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDao.updateNotice(session, mv);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteNotice(int nno) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDao.deleteNotice(session, nno);
		session.close();
		
		return cnt;
	}



}
