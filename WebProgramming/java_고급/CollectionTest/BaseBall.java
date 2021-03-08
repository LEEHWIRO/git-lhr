package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		// 1~100사이의 중복되지 않는 정수 5개 만들기
		HashSet<Integer> intRnd = new HashSet<>();

		while (intRnd.size() < 3) { // 데이터가 5개가 될때까지 반복...
			int num = (int) (Math.random() * 9 + 1);
			intRnd.add(num);
		}
		
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		
		
		/*
		// shuffle을 이용한 데이터 섞기
		
		Collections.shuffle(intRndList); // 데이터 섞기
		int i = 0; // 배열의 첨자 역할
		for(int bbNum : bbNumList) {
			num[i++] = bbNum;
		}

		*/
		
		for(int i = 0 ; i < intRndList.size(); i++) {
			System.out.print(intRndList.get(i));
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int count =0;
		while(true){
		System.out.println("3자리 숫자 > ");
		int number = Integer.parseInt(sc.nextLine());
		int n2 = number % 10;
		number /= 10;
		int n1 = number % 10;
		number /= 10;
		int n0 = number % 10;
		number /= 10;
		
		int strike = 0;
		int ball = 0;
		int out = 0;
		
		if(intRndList.get(0)==n0) strike++;
		if(intRndList.get(1)==n1) strike++;
		if(intRndList.get(2)==n2) strike++;
		
		if(intRndList.get(0)==n1||intRndList.get(0)==n2) ball++;
		if(intRndList.get(1)==n0||intRndList.get(1)==n2) ball++;
		if(intRndList.get(2)==n0||intRndList.get(2)==n1) ball++;
		
		out = 3-strike-ball;
		
		System.out.println(++count + "차 시도(" + n0 +n1 + n2 + ") :"
				+ strike +"s "+ball+"b "+out+"o");
		System.out.println("-------------------");
		if(strike==3){
			System.out.println("정답입니다.");
			break;
			}

		}

		
	
	}

}
