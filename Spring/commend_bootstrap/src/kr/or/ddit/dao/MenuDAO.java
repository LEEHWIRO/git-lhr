package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MenuVO;

public interface MenuDAO {
	
	// 메인메뉴
	List <MenuVO> selectMainMenu(SqlSession session) throws SQLException;
	
	// 서브메뉴
	List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException;
	
	// 메뉴정보
	MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException;
}