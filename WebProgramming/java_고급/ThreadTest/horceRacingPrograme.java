package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class horceRacingPrograme {
//	10마리의 말들이 경주하는 경마 프로그램 작성하기
//
//	말은 Horse라는 이름의 클래스로 구성하고,
//	이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
//	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
//	기능이 있다.( Comparable 인터페이스 구현)
//
//	경기 구간은 1~50구간으로 되어 있다.
//
//	경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
//	예)
//	1번말 --->-/-----/-----/-----/-----/-----/-----/-----/
//	2번말 ----->----------------------------------
//	...
//
//	경기가 끝나면 등수를 기준으로 정렬하여 출력한다.
	static String strRank = " ";
	
	public static void main(String[] args) {

		List<Horse2> list = new ArrayList<Horse2>();
		
		list.add(new Horse2());
	
		for(Horse2 horse : list) {
			horse.start();
		}
		
		
		
	}


}

class PrintHorse extends Thread {
	
}




class Horse2 extends Thread implements Comparable<Horse2> {
	 	private String name;
	    private int rank = 0;
	    private int location = 0;
	    public volatile boolean goal = false; // 결승지점 통과 여부
		
	   public void run() {
		   int cnt = 0;
		   while(true) {
			   location += cnt;
			   try {
				   Thread.sleep(1000*(int)(Math.random()*4));
			   }catch(InterruptedException e) {
				   e.printStackTrace();
			   }
			   
			   if(location == 50) {
				   break;
			   }
			   
			   cnt++;
		   }
	   }
	    
	    
	    public String getHName() {
			return name;
		}




//		public void setHName(String name) {
//			this.name = name;
//		}




		public int getRank() {
			return rank;
		}




		public void setRank(int rank) {
			this.rank = rank;
		}




		public int getLocation() {
			return location;
		}




		public void setLocation(int location) {
			this.location = location;
		}




		public boolean isGoal() {
			return goal;
		}




		public void setGoal(boolean goal) {
			this.goal = goal;
		}




		@Override
		public int compareTo(Horse2 o) {
			// TODO Auto-generated method stub
			return 0;
		}




		




	
}
	
	
	

