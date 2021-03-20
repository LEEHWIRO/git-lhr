package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class HotelService {
	
	Scanner sc = new Scanner(System.in);
	Map<String, String> checkin = new HashMap<String, String>();
	
	// 변수 선언
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream oos = null;
	
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



	@SuppressWarnings("unchecked")
	private void roomStatus() {
		
		try {
			/**
			 * 바이트 단위 스트림 : 바이트 단위로 데이터를 읽거나 쓰는 스트림
			 * FileInputStream(String name) => 파일 이름(경로 포함) name을 매개변수로 받아 입력 스트림 생성
			 */
			fis = new FileInputStream("d:/D_Other/hotel.txt");
			
			/**
			 * 보조 스트림 : 입출력 대상이 되는 파일이나 네트워크를 직접 읽거나 쓰는 기능은 없고
			 * 말 그대로 보조 기능을 추가하는 스트림
			 * BufferedInputStream => 바이트 단위로 읽는 스트림에 버퍼링 기능 제공
			 */
			bis = new BufferedInputStream(fis);
			
			/**
			 * 직렬화 : 인스턴스의 어느 순간 상태를 그대로 저장하거나 네트워크를 통해 전송하는 것
			 * 직렬화를 도와주는 자바의 보조 스트림
			 * ObjectInputStream => InputStream을 매개변수로 받아 ObjectInputStream 생성
			 */
			ois = new ObjectInputStream(bis);
			
			// Object readObject() => ObjectInputStream 클래스 일반 메소드로 객체 데이터를 스트림으로 불러올 때 사용
			checkin = (Map<String, String>) ois.readObject();
			
			Set<String> keySet = checkin.keySet();
			
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				
				String key = it.next();
				System.out.println("방번호 : " + key + ", 투숙객 : " + checkin.get(key));
			}
			
			// 작업 완료 후 스트림 닫기
			ois.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}



	@SuppressWarnings("unchecked")
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		String roomnumber = sc.nextLine();
		try {
			
			/**
			 * 바이트 단위 스트림 : 바이트 단위로 데이터를 읽거나 쓰는 스트림
			 * FileInputStream(String name) => 파일 이름(경로 포함) name을 매개변수로 받아 입력 스트림 생성
			 */
			FileInputStream fis = new FileInputStream("d:/D_Other/hotel.txt");
			
			/**
			 * 보조 스트림 : 입출력 대상이 되는 파일이나 네트워크를 직접 읽거나 쓰는 기능은 없고
			 * 말 그대로 보조 기능을 추가하는 스트림
			 * BufferedInputStream => 바이트 단위로 읽는 스트림에 버퍼링 기능 제공
			 */
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			/**
			 * 직렬화 : 인스턴스의 어느 순간 상태를 그대로 저장하거나 네트워크를 통해 전송하는 것
			 * 직렬화를 도와주는 자바의 보조 스트림
			 * ObjectInputStream => InputStream을 매개변수로 받아 ObjectInputStream 생성
			 */
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			// Object readObject() => ObjectInputStream 클래스 일반 메소드로 객체 데이터를 스트림으로 불러올 때 사용
			checkin = (Map<String, String>) ois.readObject();
			
			Set<Map.Entry<String, String>> mapSet = checkin.entrySet();
			Iterator<Entry<String, String>> entryIt = mapSet.iterator();
			boolean flag =false;
			while(entryIt.hasNext()) {
				Map.Entry<String, String> entry = entryIt.next();
				
				if(entry.getKey().equals(roomnumber)) {
					flag = true;
					checkin.remove(roomnumber);
					System.out.println("체크아웃 되었습니다.");
					
					/**
					 * 바이트 단위 스트림 : 바이트 단위로 데이터를 읽거나 쓰는 스트림
					 * FileOutputStream(String name) => 파일 이름(경로 포함) name을 매개변수로 받아 출력 스트림 생성
					 */
					FileOutputStream fos = new FileOutputStream("d:/D_Other/hotel.txt");
					
					/**
					 * 보조 스트림 : 입출력 대상이 되는 파일이나 네트워크를 직접 읽거나 쓰는 기능은 없고
					 * 말 그대로 보조 기능을 추가하는 스트림
					 * BufferedOutputStream => 바이트 단위로 출력하는 스트림에 버퍼링 기능 제공
					 */
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					
					/**
					 * 직렬화 : 인스턴스의 어느 순간 상태를 그대로 저장하거나 네트워크를 통해 전송하는 것
					 * 직렬화를 도와주는 자바의 보조 스트림
					 * ObjectOutputStream => OutputStream을 매개변수로 받아 ObjectOutputStream 생성
					 */
					ObjectOutputStream oos = new ObjectOutputStream(bos);
					
					// void writeObject(Object obj) => 클래스 일반 메소드로서 객체 데이터를 외부로 전송할 때 사용
					oos.writeObject(checkin);
					
					// 작업 완료 후 스트림 닫기
					ois.close();
					oos.close();
					break;
				
				}else {
					flag = false;

				}
				
			}
			
			if(flag==false) {
				System.out.println(roomnumber + "번방에는 체크인한 사람이 없습니다.");
			}else {
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			
		
		
		
		
		
		
	}



	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		String roomnumber = sc.nextLine();
		System.out.println("누구를 체크인 하시겠습니까?");
		String user = sc.nextLine();
		
		if(checkin.get(roomnumber) == null) {
			checkin.put(roomnumber, user);
			
			
			try {
			/**
			 * 바이트 단위 스트림 : 바이트 단위로 데이터를 읽거나 쓰는 스트림
			 * FileOutputStream(String name) => 파일 이름(경로 포함) name을 매개변수로 받아 출력 스트림 생성
			 */
			FileOutputStream fos = new FileOutputStream("d:/D_Other/hotel.txt");
			
			/**
			 * 보조 스트림 : 입출력 대상이 되는 파일이나 네트워크를 직접 읽거나 쓰는 기능은 없고
			 * 말 그대로 보조 기능을 추가하는 스트림
			 * BufferedOutputStream => 바이트 단위로 출력하는 스트림에 버퍼링 기능 제공
			 */
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			/**
			 * 직렬화 : 인스턴스의 어느 순간 상태를 그대로 저장하거나 네트워크를 통해 전송하는 것
			 * 직렬화를 도와주는 자바의 보조 스트림
			 * ObjectOutputStream => OutputStream을 매개변수로 받아 ObjectOutputStream 생성
			 */
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			// void writeObject(Object obj) => 클래스 일반 메소드로서 객체 데이터를 외부로 전송할 때 사용
			oos.writeObject(checkin);
			
			System.out.println("체크인 되었습니다.");
			
			// 작업 완료 후 스트림 닫기
			oos.close();
			
			}catch(IOException e){
				e.printStackTrace();
			}
		}else if(checkin.get(roomnumber).equals(user)) {
			checkin.put(roomnumber, user);
			
			try {
				/**
				 * 바이트 단위 스트림 : 바이트 단위로 데이터를 읽거나 쓰는 스트림
				 * FileOutputStream(String name) => 파일 이름(경로 포함) name을 매개변수로 받아 출력 스트림 생성
				 */
				FileOutputStream fos = new FileOutputStream("d:/D_Other/hotel.txt");
				
				/**
				 * 보조 스트림 : 입출력 대상이 되는 파일이나 네트워크를 직접 읽거나 쓰는 기능은 없고
				 * 말 그대로 보조 기능을 추가하는 스트림
				 * BufferedOutputStream => 바이트 단위로 출력하는 스트림에 버퍼링 기능 제공
				 */
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				
				/**
				 * 직렬화 : 인스턴스의 어느 순간 상태를 그대로 저장하거나 네트워크를 통해 전송하는 것
				 * 직렬화를 도와주는 자바의 보조 스트림
				 * ObjectOutputStream => OutputStream을 매개변수로 받아 ObjectOutputStream 생성
				 */
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				
				// void writeObject(Object obj) => 클래스 일반 메소드로서 객체 데이터를 외부로 전송할 때 사용
				oos.writeObject(checkin);
				
				System.out.println("체크인 되었습니다.");
				
				// 작업 완료 후 스트림 닫기
				oos.close();
				
				}catch(IOException e){
					e.printStackTrace();
				}
		}else {
			System.out.println(roomnumber + "번방에는 이미 사람이 있습니다.");
			
		}
		
		
		
		
	}



	
	

}
