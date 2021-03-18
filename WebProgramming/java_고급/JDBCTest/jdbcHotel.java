package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

import java.util.Map.Entry;

public class jdbcHotel {

	public static void main(String[] args) {
		jdbcHotel hotel = new jdbcHotel();
		hotel.start();
	}
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in);
	
	// 메뉴 출력 메서드
		public void displayMenu() {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("  1. 체크인");
			System.out.println("  2. 체크아웃");
			System.out.println("  3. 객실상태");
			System.out.println("  4. 업무종료");
			System.out.println("*******************************************");
			System.out.print("원하는 작업 선택 >> ");
		}
		
		//프로그램 시작 메서드
		public void start() {
			int choice;
			System.out.println("*******************************************");
			System.out.println("호텔 문을 열었습니다.");
			System.out.println("*******************************************");
			hotel :while(true) {
				displayMenu();
				choice = scan.nextInt();
				switch(choice) {
				case 1: 
					checkIn();
					break;
				case 2:
					checkOut();
					break;
				case 3:
					roomStatus();
					break;
				case 4:
					System.out.println("*******************************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("*******************************************");
					break hotel;
				}
			}
		}

		private void roomStatus() {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(" 방 번 호\t투숙객 이름");
			System.out.println("----------------------------");
			
			try {
				conn = JDBCUtil3.getConnection();
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery("select * " 
									+ " from hotel_mng ");
				
				while(rs.next()) {
					int roomNum = rs.getInt("room_num");
					String guestName = rs.getString("guest_name");
										
					System.out.println(roomNum + "\t" + guestName);
				}
				System.out.println("----------------------------");
				System.out.println("출력 작업 끝");
			}catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
			}
			
		}



		private void checkOut() {
			boolean chk = false;
			int roomNum = 0;
			do {
				System.out.println();
				System.out.println("삭제할 방 번호를 입력하세요.");
				System.out.print(" 번호 >> ");
				roomNum = scan.nextInt();
				
				chk = chkboard(roomNum);
				
				if(chk == false) {
					System.out.println("예약된 방 번호중에 " + roomNum + "번인 방이 없습니다.");
					System.out.println("다시 입력해 주세요.");
				}
			
			}while(chk == false);
			
			try {

				conn = JDBCUtil3.getConnection();
				
				String sql = "delete "+ 
						" from hotel_mng " + 
						" where room_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNum);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0) {
					System.out.println(roomNum + "번 방 체크아웃 완료");
				}else {
					System.out.println(roomNum + "번 방 체크아웃 실패");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
			}
			
		}



		private void checkIn() {
			System.out.println("체크인할 방 번호를 입력하세요.");
			System.out.print("방 번호 >> ");
			int roomNum = scan.nextInt();
			
			System.out.println("체크인할 고객 이름을 입력하세요.");
			System.out.print("이름 >> ");
			String guestName = scan.next();
			
			try {
				
				conn = JDBCUtil3.getConnection();
				
				String sql = "insert into hotel_mng (room_num,guest_name) " + 
						"values (?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNum);
				pstmt.setString(2, guestName);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0) {
					System.out.println(guestName + "고객의 체크 인 완료");
				}else {
					System.out.println(guestName + "고객의 체크 인 실패");
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			} finally {
				JDBCUtil3.disConnect(conn, stmt, pstmt, rs);
			}
			
			
			
			
			
}
		
		private boolean chkboard(int roomNum) {
			boolean chk = false;

			try {
				conn = JDBCUtil3.getConnection();

				String sql = "select count(*) as cnt from hotel_mng where room_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNum);

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
}
