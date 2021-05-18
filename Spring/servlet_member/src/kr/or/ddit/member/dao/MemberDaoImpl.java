package kr.or.ddit.member.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;


public class MemberDaoImpl implements MemberDao {
	
	private SqlSessionFactory sqlSessionFactory;
	{
		String config = "kr/or/ddit/mybatis/SqlMapConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			System.out.println("sqlSessionFactory 성공했습니다.");
		} catch(Exception e) {
			System.out.println("sqlSessionFactory 실패했습니다.");
			e.printStackTrace();
		}
	}
	
	private static MemberDao memDao;
	
	private MemberDaoImpl() {
		
	}
	
	public static MemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		
		return memDao;
	}

	@Override
	public MemberVO listDetailMember(String memId) throws SQLException {
		MemberVO mv = (MemberVO) sqlSessionFactory.openSession().selectOne("member.listDetailMember",memId);
		return mv;
	}

	@Override
	public List<MemberVO> listMember() throws SQLException {
		List<MemberVO> memList = sqlSessionFactory.openSession().selectList("member.listMember");
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int obj = sqlSession.insert("member.insertMember", mv);
		
		if(obj == 1) {
			cnt = 1;
		}
		
		sqlSession.commit();
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		cnt = sqlSession.update("member.updateMember", mv);
		
		sqlSession.commit();
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		int cnt = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		cnt = sqlSession.delete("member.deleteMember", memId);
		
		sqlSession.commit();
		return cnt;
	}
	



}
