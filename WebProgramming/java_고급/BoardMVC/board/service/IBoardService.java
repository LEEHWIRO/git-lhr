package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;


public interface IBoardService {
	
		/**
		 * BoardVO 객체에 담겨진 자료를 DB에 insert하는 메서드
		 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환된다.
		 */
		public int insertBoard(BoardVO mv);
		
		
		/**
		 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
		 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
		 */
		public boolean checkBoard(int boardNo);
		
		
		/**
		 * DB의 myBoard테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
		 * @return 회원정보를 담고있는 List객체
		 */
		public List<BoardVO> getAllBoardList();
		
		
		/**
		 * 하나의 회원정보를 이용하여 DB를 update하는 메서드
		 * @return 작성성공: 1, 작업실패: 0
		 */
		public int updateBoard(BoardVO mv);
		
		
		/**
		 * 회원 ID를 매개변수로 받아서 그 회원정보를 삭제하는 메서드
		 * @return 작업성공: 1, 작업실패: 0
		 */
		public int deleteBoard(int boardNo);
		
		
		/**
		 * BoardVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
		 * @return 검색된 결과를 담은 List
		 */
		public List<BoardVO> getSearchBoard(BoardVO mv);
}
