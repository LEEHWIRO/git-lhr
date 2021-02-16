package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;

import e_oop.ScanUtil;

public class JDBCBoard {
	// 1. DB접속
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "pc16";
	static String password = "java";

	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요. 테이블 : TB_JDBC_BOARD 컬럼 :
		 * BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE 1. 게시판 List 2. 게시판 등록 3.
		 * 게시판 상세보기 4. 게시판 수정 5. 게시판 삭제
		 * 
		 * JDBC순서 1. url, user, password -> DB에 접근할 모든 곳에 공통 => 어떻게 빼놓으면 좋을까요?
		 * 2. DB접속 => Connection객체 - url => ip, port, sid 3. Query생성 4. 질의 =>
		 * PreparedStatement 5. 결과 저장 => ResultSet 6. 자원 반납 close()
		 */
		while (true) {
			List();
			System.out.println("1. 게시판 조회\t2. 게시판 등록\t3. 게시판 상세보기");
			System.out.println("4. 게시판 수정\t5. 게시판 삭제\t0. 게시판 종료");
			System.out
					.println("----------------------------------------------------------------");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				select();
 			    break;
			case 2:
				Insert();
				break;
			case 3:
				Content();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 0:
				System.out.println("게시판을 종료합니다.");
				System.exit(0);
				break;
			}

		}

	}

	private static void select() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			String sql = " select BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE from TB_JDBC_BOARD"
					+ " where BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			System.out.println("조회할 게시물 번호>");
			int input = ScanUtil.nextInt();
			ps.setObject(1, input);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("번호\t:" + rs.getObject("BOARD_NO"));
				System.out.println("제목\t:" + rs.getObject("TITLE"));
				System.out.println("내용\t:" + rs.getObject("CONTENT"));
				System.out.println("아이디\t:" + rs.getObject("USER_ID"));
				System.out.println("날짜\t:" + rs.getObject("REG_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		
	}

	private static void delete() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);

			String sql = " delete from TB_JOBC_BOARD" + " where board_no = ?";

			ps = con.prepareStatement(sql);

			System.out.println("삭제할 번호를 골라주세요.");
			System.out
					.println("----------------------------------------------------------------");

			ps.setInt(1, ScanUtil.nextInt());

			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}

		}

	}

	private static void update() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);

			String sql = " update TB_JDBC_BOARD"
					+ " set title = ?, content = ?, reg_date = sysdate"
					+ " where board_no = ?";

			ps = con.prepareStatement(sql);

			System.out.println("업데이트할 제목을 입력해주세요>");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(1, ScanUtil.nextLine());

			System.out.println("업데이트할 내용을 입력해주세요>");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(2, ScanUtil.nextLine());

			System.out.println("업데이트할 번호을 입력해주세요>");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(3, ScanUtil.nextLine());

			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 업데이트되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

	private static void Content() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);

			String sql = " select * " + " from TB_JDBC_BOARD";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			System.out.println("TITLE\t" + "CONTENT");
			System.out
					.println("----------------------------------------------------------------");
			while (rs.next()) {

				System.out.println(rs.getString(2) + "\t" + rs.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	private static void List() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select BOARD_NO, TITLE, USER_ID, REG_DATE from TB_JDBC_BOARD";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			System.out
					.println("----------------------------------------------------------------");
			System.out.println("번호\t제목\t아이디\t작성일");
			System.out
					.println("----------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getObject("board_no") + "\t"
						+ rs.getObject("title") + "\t"
						+ rs.getObject("user_id") + "\t"
						+ rs.getObject("reg_date"));
			}
			System.out
					.println("----------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	private static void Insert() {
		// 2. Query
		Connection con = null;
		// 3. 질의
		PreparedStatement ps = null;
		// 4. 결과
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(url, user, password);

			String sql = " insert into TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,USER_ID,REG_DATE) "
					+ " values (("
					+ "select nvl(max(board_no),0) + 1 from tb_jdbc_board"
					+ "),?,?,?,sysdate)";

			ps = con.prepareStatement(sql);

			System.out.println("제목를 입력해주세요.");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(1, ScanUtil.nextLine());

			System.out.println("내용를 입력해주세요.");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(2, ScanUtil.nextLine());

			System.out.println("아이디를 입력해주세요.");
			System.out
					.println("----------------------------------------------------------------");
			ps.setString(3, ScanUtil.nextLine());

			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}
}
