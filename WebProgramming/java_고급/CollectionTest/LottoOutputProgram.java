package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoOutputProgram {
	
	Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			LottoOutputProgram Lottoprogram =new LottoOutputProgram();
			Lottoprogram.LottoStart();
		}
		
		
		
		public void getRndNum(int money) {
			
			
			int count = money / 1000;
			int c = money - 1000 * count;
			System.out.println("받은 금액은"+ money + "이고 거스름돈은"+ c +"원입니다.");
			
			Set<Integer> LottoNum = new HashSet<Integer>();
			for(int i = 0; i < count; i++) {
								
				while(LottoNum.size() < 6) {
					LottoNum.add((int)(Math.random()*99+1));
				}
				
				List<Integer> LottoNumList = new ArrayList<Integer>(LottoNum);
				
				Collections.shuffle(LottoNumList);
				
				int j=i+1;
				
				System.out.println("로또번호"+j+" : "+LottoNumList);
				
				LottoNumList.clear();

			}
			
			

		}
		
		public void LottoStart() {
			
			while(true) {
			System.out.println("=================================");
			System.out.println("          Lotto 프로그램");
			System.out.println("---------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("=================================");
			System.out.print("메뉴선택 > ");
			int menunum = Integer.parseInt(sc.nextLine());
			switch(menunum) {
			case 1:
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력 > ");
				int money = Integer.parseInt(sc.nextLine());
				getRndNum(money);
				break;
			case 2:
				System.out.println("감사합니다.");
				System.exit(2);
				break;
			}
			
			
			
		}
	}

}
