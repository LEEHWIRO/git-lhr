package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;


public class MemberDAOImpl implements MemberDAO {
	

	@Override
	public MemberVO listDetailMember(SqlSession session, String memId) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.listDetailMember",memId);
		return member;
	}

	@Override
	public List<MemberVO> listMember(SqlSession session) throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper.listMember");
		return memberList;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		int obj = session.insert("Member-Mapper.insertMember", mv);
		
		if(obj == 1) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("Member-Mapper.updateMember", mv);
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		
		cnt = session.delete("Member-Mapper.deleteMember", memId);
		
		return cnt;
	}
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}

	@Override
	public List<MemberVO> listMember(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.listMember",null,rowBounds);
		return memberList;
	}

	@Override
	public List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectSearchMemberList",cri,rowBounds);
		
		
		return memberList;
	}

	@Override
	public int selectMemberListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Member-Mapper.selectSearchMemberListCount",cri);
		return count;
	}
	



}
