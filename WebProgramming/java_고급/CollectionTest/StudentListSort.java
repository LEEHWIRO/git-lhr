package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentListSort {
	
	public static void main(String[] args) {
//		학번(String), 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
//		  Student클래스를 만든다.
//		  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
//		  
//		  이 Student객체들은 List에 저장하여 관리한다.
//		  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
//		  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
//		  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
//		  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고, implement comparable
//		   총점 정렬기준은 외부클래스에서 제공하도록 한다.)
		List<Student> stList = new ArrayList<Student>();
		
		stList.add(new Student("1341001", "박상영", 72, 83, 92));
		stList.add(new Student("1341011", "이휘로", 51, 84, 83));
		stList.add(new Student("1341021", "장현수", 75, 65, 54));
		stList.add(new Student("1341019", "안율규", 12, 75, 41));
		stList.add(new Student("1341006", "이동석", 65, 56, 55));
		stList.add(new Student("1341031", "천인애", 56, 55, 65));
		
		//석차 매기기
        for(int i =0; i < stList.size(); i++) {
        	int cnt = 1;
        	for(int j = 0; j < stList.size(); j++) {
        		if(stList.get(i).getSum() < stList.get(j).getSum()) {
        			stList.get(i).setRank(cnt++);
        		}else {
        			stList.get(i).setRank(cnt);
        		}
        	}
        }
		
		System.out.println("정렬전 : ");
		for(Student st : stList) {
			System.out.println(st);
		}
		System.out.println("=====================================");
		
		Collections.sort(stList);
		
		System.out.println("학번의 오름찬순으로 정렬 후 ");
		for(Student st: stList) {
			System.out.println(st);
		}
		System.out.println("=======================================");
		
		Collections.sort(stList,new SumDesc());
		System.out.println("총점의 내림차순으로 정렬 후 ");
		for(Student st: stList) {
			System.out.println(st);
		}
		System.out.println("=======================================");
		
	}
	

}

//총점순으로 내림차순 정렬(단, 총점이 같을시 학번순 오름차순 정렬)
class SumDesc implements Comparator<Student>{

	@Override
	public int compare(Student st1, Student st2) {
		if (st1.getSum() > st2.getSum()) {
			return -1;
		} else if (st1.getSum() == st2.getSum()) {
			return st1.getId().compareTo(st2.getId()) * 1;
		} else {
			return 1;
		}
	}

}

class Student implements Comparable<Student>{
	
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank =1;


	
	public Student(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int kor, int eng, int math) {
		this.sum = math + eng + math;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}
	
	//학번순으로 오름차순 정렬
	@Override
	public int compareTo(Student st) {
		return this.getId().compareTo(st.getId());
	}
	
}
