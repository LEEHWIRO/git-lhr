package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.notice.dto.NoticeVO;


public class NoticeDaoImpl implements NoticeDao {
	

	@Override
	public NoticeVO listDetailNotice(SqlSession session, int nno) throws SQLException {
		NoticeVO mv = session.selectOne("notice.listDetailNotice",nno);
		return mv;
	}

	@Override
	public List<NoticeVO> listNotice(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("notice.listNotice");
		return noticeList;
	}

	@Override
	public int insertNotice(SqlSession session, NoticeVO mv) throws SQLException {
		int cnt = 0;
		
		int obj = session.insert("notice.insertNotice", mv);
		
		if(obj == 1) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("notice.updateNotice", mv);
		
		return cnt;
	}

	@Override
	public int deleteNotice(SqlSession session, int nno) throws SQLException {
		int cnt = 0;
		
		cnt = session.delete("notice.deleteNotice", nno);
		
		return cnt;
	}
	



}
