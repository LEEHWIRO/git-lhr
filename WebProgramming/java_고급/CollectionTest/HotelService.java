package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class HotelService {
	
	Scanner sc = new Scanner(System.in);
	Map<String, String> checkin = new HashMap<String, String>();
	
	
	public static void main(String[] args) {
		HotelService hotelprogram = new HotelService();
		hotelprogram.hotelStart();
	}

	

	private void hotelStart() {
		System.out.println("*******************************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("*******************************************");
		while(true) {
		
		
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		int input = Integer.parseInt(sc.nextLine());
		switch(input) {
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
			System.exit(4);
			break;
			}

		}

	}



	private void roomStatus() {
		Set<String> keySet = checkin.keySet();
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			
			String key = it.next();
			System.out.println("방번호 : " + key + ", 투숙객 : " + checkin.get(key));
		}
		
	}



	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		String roomnumber = sc.nextLine();
		
		Set<Map.Entry<String, String>> mapSet = checkin.entrySet();
		Iterator<Entry<String, String>> entryIt = mapSet.iterator();
		boolean flag =false;
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			if(entry.getKey().equals(roomnumber)) {
				flag = true;
				checkin.remove(roomnumber);
				System.out.println("체크아웃 되었습니다.");
				break;
			
			}else {
				flag = false;

			}
			
		}
		
		if(flag==false) {
			System.out.println(roomnumber + "번방에는 체크인한 사람이 없습니다.");
		}else {
			
		}
			
		
		
		
		
		
		
	}



	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		String roomnumber = sc.nextLine();
		System.out.println("누구를 체크인 하시겠습니까?");
		String user = sc.nextLine();
		
		if(checkin.get(roomnumber) == null) {
			checkin.put(roomnumber, user);
			System.out.println("체크인 되었습니다.");
			
		}else if(checkin.get(roomnumber).equals(user)) {
			checkin.put(roomnumber, user);
			System.out.println("체크인 되었습니다.");
			
		}else {
			System.out.println(roomnumber + "번방에는 이미 사람이 있습니다.");
			
		}
		
		
		
		
	}



	
	

}
