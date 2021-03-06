package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;

public class T09_MapTest {
	public static void main(String[] args) {
		/**
		 * Map => key값가 value값을 한 쌍으로 관리하는 객체
		 *     => key값은 중복을 허용하지 않고 순서가 없다.(Set의 특징)
		 *     => value값은 중복을 허용한다.
		 */
		Map<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 => put(key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		// 자료 수정 => 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		//        => put(수정할 key값, 새로운 value값)
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 자료 삭제 => remove(삭제할 key값)
		map.remove("name");
		System.out.println("map => " + map);
		
		// 자료 뽑기 => get(key값);
		System.out.println("addr = " + map.get("addr"));
		System.out.println("=================================");
	}

}
