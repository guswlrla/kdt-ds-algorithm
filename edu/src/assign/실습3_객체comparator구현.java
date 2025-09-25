package assign;

import java.util.Arrays;
import java.util.Comparator;

class Student {
	private String sid;
	private String sname;
	private String dept;
	
	// 생성자
	public Student(String sid, String sname, String dept) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getDept() {
		return dept;
	}
	
	@Override
	public String toString() {
		return sid + ", " + sname + ", " + dept;
	}
}

public class 실습3_객체comparator구현 {
	
	private static void show(Student[] arr) {
		System.out.println("=== 정렬 전 학생 목록 ===");
		for(Student d : arr) {
			System.out.println(d.toString());
		}
	}

	
	
	public static void main(String[] args) {
		Student[] students = {
			    new Student("S001", "영희", "Math"),
			    new Student("S003", "민수", "Computer"),
			    new Student("S002", "철수", "Physics"),
			    new Student("S005", "지영", "Biology"),
			    new Student("S004", "준호", "Chemistry")
			};

		show(students);
		
//		Comparator<Student> sidComparator = (a, b) -> compare(a.getSid(), b.getSid());
//		Arrays.sort(students, sidComparator);
	}
/*
 * Comparator를 사용한 학생 정보 배열 정렬 및 이진 탐색 구현
 * 
 * 고정된 학생 배열을 Comparator를 사용해 학번(sid) 기준으로 정렬한 뒤,
 * 탐색 대상 학생 객체 배열에 대해 Arrays.binarySearch()를 사용하여 
 * 해당 학번을 가진 학생이 존재하는지 판단하는 프로그램을 작성하시오.
 * 
 * 구현 조건


다음 탐색 대상 배열을 정의하고, 확장형 for문으로 각 항목에 대해 Arrays.binarySearch(배열, key, comparator)로 탐색한다.

Student[] targets = {
    new Student("S002", "철수", "Physics"),
    new Student("S006", "홍길동", "Law"),
    new Student("S004", "준호", "Chemistry")
};

탐색 결과는 다음과 같이 출력한다:

"찾은 학생: S002, 철수, Physics"

"학번 S006인 학생은 존재하지 않습니다."

=== 이진 탐색 결과 ===
찾은 학생: S002, 철수, Physics
학번 S006인 학생은 존재하지 않습니다.
찾은 학생: S004, 준호, Chemistry

 * 
 */


}
