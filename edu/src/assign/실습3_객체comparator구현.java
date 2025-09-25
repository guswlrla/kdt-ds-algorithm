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
		System.out.println();
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
		
		Comparator<Student> comparator = (a, b) -> a.getSid().compareTo(b.getSid()); // 객체형을 비교하려면 compareTo()를 사용
		Arrays.sort(students, comparator);
		
		Student[] targets = {
			    new Student("S002", "철수", "Physics"),
			    new Student("S006", "홍길동", "Law"),
			    new Student("S004", "준호", "Chemistry")
			};
		
		System.out.println("=== 이진 탐색 결과 ===");
		for(Student key : targets) {
			int index = Arrays.binarySearch(students, key, comparator);
			
			if(index > 0) {
				System.out.println("찾은 학생 : " + students[index]);
			}
			else {
				System.out.println("학번 " + key.getSid() + "인 학생은 존재하지 않습니다.");
			}
		}
	}
}
