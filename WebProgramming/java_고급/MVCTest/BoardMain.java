package kr.or.ddit.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.service.BoardServiceImpl;
import kr.or.ddit.member.service.IBoardService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.BoardVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

public class BoardMain {
//	기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
	
	// 서비스객체 멤버변수 선언
		private IBoardService boardService;
		
		public BoardMain() {
			boardService = new BoardServiceImpl();
		}
		
		private Scanner scan = new Scanner(System.in); 
		
		/**
		 * 메뉴를 출력하는 메서드
		 */
		public void displayMenu(){
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  === 작 업 선 택 ===");
			System.out.println("  1. 자료 입력");
			System.out.println("  2. 자료 삭제");
			System.out.println("  3. 자료 수정");
			System.out.println("  4. 전체 자료 출력");
			System.out.println("  5. 자료 검색");
			System.out.println("  6. 작업 끝.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
		}
	
		/**
		 * 프로그램 시작메서드
		 */
		public void start(){
			int choice;
			do{
				displayMenu(); //메뉴 출력
				choice = scan.nextInt(); // 메뉴번호 입력받기
				switch(choice){
					case 1 :  // 자료 입력
						insertBoard();
						break;
					case 2 :  // 자료 삭제
						deleteBoard();
						break;
					case 3 :  // 자료 수정
						updateBoard();
						break;
					case 4 :  // 전체 자료 출력
						displayAll();
						break;
					case 5 :  // 자료 검색
						searchBoard();
						break;
					case 6 :  // 작업 끝
						System.out.println("작업을 마칩니다.");
						break;
					default :
						System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
				}
			}while(choice!=6);
		}

	/**
	 * 게시글을 검색하는 메서드
	 */
	private void searchBoard() {
		
		// 검색할 회원ID, 회원이름, 전화번호, 주소등을 입력하면
		// 입력한 정보만 사용하여 검색하는 기능을 구현하시오.
		// 주소는 입력한 값이 포함만 되어도 검색되도록 한다.
		// 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
		scan.nextLine(); // 입력버퍼 지우기
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("게시판 번호 >> ");
		int boardNo = scan.nextInt();
		
		System.out.print("게시판 제목 >> ");
		String boardTitle = scan.nextLine().trim();
		
		System.out.print("게시판 작성자 >> ");
		String boardWriter = scan.nextLine().trim();
		
		System.out.print("게시판 내용 >> ");
		String boardContent = scan.nextLine().trim();
				
		BoardVO mv = new BoardVO();
		mv.setBoardNo(boardNo);;
		mv.setBoardTitle(boardTitle);;
		mv.setBoardWriter(boardWriter);;
		mv.setBoardContent(boardContent);;
		
		// 입력한 정보로 검색한 내용을 출력하는 부분
		List<BoardVO> boardList = boardService.getSearchBoard(mv));
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println(" NO\t제 목\t작 성 자\t내 용\t작성날짜");
		System.out.println("---------------------------------------");
		
		for(BoardVO mv2 : boardList) {
			System.out.println(mv2.getBoardNo()
					+"\t" + mv2.getBoardTitle()
					+"\t" + mv2.getBoardWriter()
					+"\t" + mv2.getBoardContent()
					+"\t" + mv2.getBoardDate());
		}
		
		System.out.println("---------------------------------------");
		System.out.println("출력 작업 끝...");
		
	}

	/**
	 * 게시글을 삭제하는 메서드
	 */
	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시판 번호를 입력하세요.");
		System.out.print("게시판번호 >> ");
		int boardNo = scan.nextInt();
		
		int cnt = boardService.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println(boardNo + "게시판정보 삭제 작업 성공");
		}else {
			System.out.println(boardNo + "게시판정보 삭제 작업 실패!!!");
		}
	}

	/**
	 * 게시글을 수정하는 메서드
	 */
	private void updateBoard() {
		
		boolean chk = false;
		String memId = null;
		
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			chk =  memService.checkMember(memId);
			
			if(chk == false) {
				System.out.println("회원ID가 " + memId + "인 회원이 없습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(chk == false);
		
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		int cnt = memService.updateMember(mv);
		
		if(cnt > 0) {
			System.out.println(memId + "회원정보 수정 작업 성공");
		}else {
			System.out.println(memId + "회원정보 수정 작업 실패!!!");
		}
	}

	/**
	 * 게시판 번호를 이용하여 게시판이 있는지 알려주는 메서드
	 * @param boardNo
	 * @return 존재하면 true, 없으면 false
	 */
	private boolean chkboard(String boardNo) {
		boolean chk = false;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);

			rs = pstmt.executeQuery();

			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				chk = true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return chk;
	}
	

	/**
	 * 게시판 목록을 출력해주는 메서드
	 */
	private void displayAll() {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(" 게시판번호\t제  목\t작 성 자\t날  짜\t\t\t내  용");
		System.out.println("----------------------------");
		
		try {
			conn = JDBCUtil3.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select *"
								+ "from jdbc_board");
			
			while(rs.next()) {
				String boardNo = rs.getString("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				String boardContent = rs.getString("board_content");
				
				System.out.println(boardNo + "\t" + boardTitle + "\t" + boardWriter + "\t" + boardDate + "\t" + boardContent);
			}
			System.out.println("----------------------------");
			System.out.println("출력 작업 끝");
		}catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	/**
	 * 게시판에 새글을 작성하는 메서드
	 */
	private void insertBoard() {
				
		System.out.println("작성할 제목을 입력하세요.");
		System.out.print("제목 >> ");
		String title = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		System.out.println("작성할 내용을 입력하세요.");
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		System.out.println("이름을 입력하세요.");
		System.out.print("이름 >> ");
		String writer = scan.next();
			
		try {
			
			conn = JDBCUtil3.getConnection();
			
			String sql = "insert into jdbc_board (board_no,board_title,board_writer,board_date,board_content) " 
						+ "values (board_seq.nextval,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(writer + "작성자의 게시글 추가 완료");
			}else {
				System.out.println(writer + "작성자의 게시글 추가  실패");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		BoardMain board = new BoardMain();
		board.start();
	}

	
}

