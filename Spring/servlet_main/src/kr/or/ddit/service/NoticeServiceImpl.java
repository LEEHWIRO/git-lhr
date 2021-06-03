package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.MemberVO;
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
	public NoticeVO getNotice(int nno) throws SQLException {
		NoticeVO notice = null;
		SqlSession session = sqlSessionFactory.openSession();

		notice = noticeDAO.selectNoticeByNno(session, nno);
		session.close();
		
		return notice;
	}

	@Override
	public List<NoticeVO> getNoticeList() throws SQLException {
		List<NoticeVO> noticeList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		noticeList = noticeDAO.selectNoticeList(session);
		session.close();
		
		return noticeList;
	}
	
	@Override
	public List<NoticeVO> getNoticeList(Criteria cri) throws SQLException {
		List<NoticeVO> noticeList = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		noticeList = noticeDAO.selectNoticeList(session,cri);
		session.close();
		
		return noticeList;
	}

	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeDAO.selectNoticeListCount(session, cri));
			
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session, cri);
			
			dataMap.put("noticeList", noticeList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}
	

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			noticeDAO.insertNotice(session, notice);
		} finally {
			session.close();
		}
	}

	@Override
	public int modify(NoticeVO notice) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDAO.updateNotice(session, notice);
		session.close();
		
		return cnt;
	}

	@Override
	public int remove(int nno) throws SQLException {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = noticeDAO.deleteNotice(session, nno);
		session.close();
		
		return cnt;
	}

	



}
