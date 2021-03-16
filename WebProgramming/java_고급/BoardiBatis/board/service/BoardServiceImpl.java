package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao boardDao;
	private SqlMapClient smc2;
	
	private static IBoardService boardService;
	
	public BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc2 = SqlMapClientUtil.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}

	@Override
	public int insertBoard(BoardVO mv) {

		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(smc2, mv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public boolean checkBoard(int boardNo) {

		boolean chk = false;
		
		try {
			chk = boardDao.checkBoard(smc2, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = boardDao.getAllBoardList(smc2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO mv) {

		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc2, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {

		int cnt = 0;
		
		try {
			cnt = boardDao.deleteBoard(smc2, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO mv) {

		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getSearchBoard(smc2, mv);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return boardList;
	}
}
