package kr.or.ddit.basic;

public class PlanetArea {
/**
 * 문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 

예) 행성의 반지름(KM):
수성(2439), 
금성(6052), 
지구(6371), 
성(3390), 
목성(69911), 
토성(58232), 
천왕성(25362), 
해왕성(24622)
 */
	// Planet 열거형 객체 선언
	public enum Planet {
		수성, 금성, 지구, 성, 목성, 토성, 천왕성, 해왕성
	};
    
	// 데이터값을 임의로 지정한 열거형 객체 선언
	public enum KM {
		수성(2439), 금성(6052), 지구(6371), 성(3390), 
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		// 괄호속의 값이 저장될 변수 선언
		private long num;

		// 생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'이다)
		KM(long data) {
			num = data;
		}

		// 값을 반환하는 메서드 작성
		public long getlong() {
			return num;
		}

	}
	
	public static void main(String[] args) {
		KM[] enumArr = KM.values();
		for(int i = 0; i < enumArr.length; i++) {
			System.out.println(enumArr[i].name() + "의 면적 = " 
							+ enumArr[i].getlong() + "(반지름)"
							+ " * " + enumArr[i].getlong() + "(반지름)"
							+ " * PI = " + (enumArr[i].getlong()*enumArr[i].getlong()) + "PI");
		}
	}
}