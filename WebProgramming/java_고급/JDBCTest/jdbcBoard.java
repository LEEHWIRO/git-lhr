package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

public class jdbcBoard {
//	기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in);
	
	// 메뉴 출력 메서드
	public void displayMenu() {
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글 작성");
		System.out.println("  3.  글 수정");
		System.out.println("  4.  글 삭제");
		System.out.println("  5.  글 검색");
		System.out.println("  6. 게시판 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	//프로그램 시작 메서드
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = scan.nextInt();
			switch(choice) {
			case 1: 
				listboard();
				break;
			case 2:
				insertBoard();
				break;
			case 3:
				updateBoard();
				break;
			case 4:
				deleteBoard();
				break;
			case 5:
				selectBoard();
				break;
			case 6:
				System.out.println("작업을 마칩니다.");
				break;
			}
		}while(choice!=6);
	}

	/**
	 * 게시글을 검색하는 메서드
	 */
	private void selectBoard() {
		
		boolean chk = false;
		String boardNo = null;
		
		do {
			System.out.println();
			System.out.println("검색할 게시판 번호를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			boardNo = scan.next();
			
			chk = chkboard(boardNo);
			
			if(chk == false) {
				System.out.println("게시판번호가 " + boardNo + "인 게시판이 없습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(chk == false);
				
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * " 
						+ "from   jdbc_board " 
						+ "where  board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
				
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
	 * 게시글을 삭제하는 메서드
	 */
	private void deleteBoard() {
		boolean chk = false;
		String boardNo = null;
		
		do {
			listboard();
			System.out.println();
			System.out.println("삭제할 게시판 번호를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			boardNo = scan.next();
			
			chk = chkboard(boardNo);
			
			if(chk == false) {
				System.out.println("게시판번호가 " + boardNo + "인 게시판이 없습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(chk == false);
		
		try {

			conn = JDBCUtil3.getConnection();
			
			String sql = "delete  " 
					+ "from   jdbc_board " 
					+ "where  board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(boardNo + "번 게시글 삭제 완료");
			}else {
				System.out.println(boardNo + "번 게시글 삭제 실패");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 게시글을 수정하는 메서드
	 */
	private void updateBoard() {
		boolean chk = false;
		String boardNo = null;
		
		do {
			listboard();
			System.out.println();
			System.out.println("수정할 게시판 번호를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			boardNo = scan.next();
			
			chk = chkboard(boardNo);
			
			if(chk == false) {
				System.out.println("게시판번호가 " + boardNo + "인 게시판이 없습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(chk == false);
		
		System.out.println("작성할 제목을 입력하세요.");
		System.out.print("제목 >> ");
		String title = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		System.out.println("작성할 내용을 입력하세요.");
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		try {

			conn = JDBCUtil3.getConnection();
			
			String sql = "update jdbc_board " 
					+ "set    board_title = ?, board_content = ? " 
					+ "where  board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(boardNo + "번 게시글 수정 완료");
			}else {
				System.out.println(boardNo + "번 게시글 수정 실패");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
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
	private void listboard() {
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
		jdbcBoard board = new jdbcBoard();
		board.start();
	}

	
}

