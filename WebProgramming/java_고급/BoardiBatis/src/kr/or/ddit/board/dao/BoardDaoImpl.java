package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;


public class BoardDaoImpl implements IBoardDao {
	
	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		
		return boardDao;
	}
	@Override
	public int insertBoard(SqlMapClient smc2, BoardVO mv) throws SQLException {

		int cnt = 0;
		
		Object obj = smc2.insert("board.insertBoard", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}
	
	
	
	@Override
	public boolean checkBoard(SqlMapClient smc2, int boardNo) throws SQLException {

		boolean chk = false;
		
		int cnt = (int) smc2.queryForObject("board.getBoard", boardNo);
		
		if(cnt > 0) {
			chk = true;
		}else {
			chk = false;
		}
		
		return chk;
	}
	@Override
	public List<BoardVO> getAllBoardList(SqlMapClient smc2) throws SQLException {
		
		List<BoardVO> boardList = smc2.queryForList("board.getBoardAll");
				
				
		return boardList;
	}
	@Override
	public int updateBoard(SqlMapClient smc2, BoardVO mv) throws SQLException {

		int cnt = 0;
		
		cnt = smc2.update("board.updateBoard", mv);
		
		return cnt;
	}
	@Override
	public int deleteBoard(SqlMapClient smc2, int boardNo) throws SQLException {

		int cnt = 0;
		
		cnt = smc2.delete("board.deleteBoard", boardNo);
		
		return cnt;
	}
	@Override
	public List<BoardVO> getSearchBoard(SqlMapClient smc2, BoardVO mv) throws SQLException {

		List<BoardVO> boardList = smc2.queryForList("board.getSearchBoard", mv);
				
		return boardList;
	}
}
