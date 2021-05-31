package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.NoticeVO;


public class NoticeDAOImpl implements NoticeDAO {
	

	@Override
	public NoticeVO listDetailNotice(SqlSession session, int nno) throws SQLException {
		NoticeVO mv = session.selectOne("Notice-Mapper.listDetailNotice",nno);
		return mv;
	}

	@Override
	public List<NoticeVO> listNotice(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.listNotice");
		return noticeList;
	}
	@Override
	public int insertNotice(SqlSession session, NoticeVO mv) throws SQLException {
		int cnt = 0;
		
		int obj = session.insert("Notice-Mapper.insertNotice", mv);
		
		if(obj == 1) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("Notice-Mapper.updateNotice", mv);
		
		return cnt;
	}

	@Override
	public int deleteNotice(SqlSession session, int nno) throws SQLException {
		int cnt = 0;
		
		cnt = session.delete("Notice-Mapper.deleteNotice", nno);
		
		return cnt;
	}

	@Override
	public List<NoticeVO> listNotice(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.listNotice",null,rowBounds);
		return noticeList;
	}
	



}
