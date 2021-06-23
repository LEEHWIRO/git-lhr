package com.spring.pointcut;

public class BehaviorImpl implements Behavior {

	@Override
	public void 잠자기() {
		System.out.println("쿨쿨~~잠을 잡니다.");
		
	}

	@Override
	public void 공부하기() {
		System.out.println("열심히 공부합니다.");
		
	}

	@Override
	public void 밥먹기() {
		System.out.println("냠냠 맛잇게 먹어용");
		
	}

	@Override
	public void 데이트() {
		System.out.println("재밋는 데이트 시간");
		
	}
	
	@Override
	public void 놀기() {
		System.out.println("재밋는 놀기 시간");
		
	}

}
