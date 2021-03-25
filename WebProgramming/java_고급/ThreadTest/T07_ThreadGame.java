package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * @author PC-16
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용하여 구하고,
 * 사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다.
 * 
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 5초안에 입력이 없으면 게임을 진것으로 처리한다.
 * 
 * 결과예시)
 *  === 결과 ===
 * 컴퓨터 : 가위
 * 당 신   : 바위
 * 결 과  : 당신0이 이겼습니다.
 *
 */
public class T07_ThreadGame {
	public static String str;
	
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
		
		String[] arr = {"가위", "바위", "보"};
			
		String str2 = arr[(int) (Math.random()*3+1)];
		
		System.out.println("컴퓨터의 선택은 : " + str2 + "입니다.");
		
		
	}
}

class Game extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위 바위 보 중 하나를 선택하세요.");
		
		 T07_ThreadGame.inputCheck = true;
		 
		 System.out.println("사용자의 선택은 : " + str + "입니다.");
		 
		
	}
}


//class CountDown extends Thread {
//	@Override 
//	public void run() {
//		for(int i = 10; i >= 1; i--) {
//			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면
//			// run()메서드를 종료시킨다.. 즉 현재 스레드를 종료시킨다.
//			if(T07_ThreadGame.inputCheck == true) {
//				return; // run()메서드가 종료되면 쓰레드가 끝난다.
//			}
//			
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			}catch(InterruptedException ex) {
//				ex.printStackTrace();
//			}
//		}
//		
//		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
//		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
//		System.out.println(0); // 프로그램을 종료시키는 명령
//	}
//}