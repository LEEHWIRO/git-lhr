package kr.or.ddit.basic;

// 함수적 인터페이스 => 추상메서드가 1개가 선언된 인터페이스

@FunctionalInterface
public interface LamdaTestInterface1 {
	// 반환값이 없고 매개변수도 없는 추상메서드
	public void test();
}

@FunctionalInterface
interface LamdaTestInterface2 {
	// 반환값이 없고 매개변수도 있는 추상메서드
	public void test(int a);
}

@FunctionalInterface
interface LamdaTestInterface3 {
	// 반환값이  있고 매개변수는 있는 추상메서드
	public int test(int a, int b);
}
