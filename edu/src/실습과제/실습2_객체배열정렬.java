package 실습과제;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */

/*
 * 객체를 보자마자 생성자부터 만들어야 함
 * Comparable 인터페이스 구현
 * */

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	private String name;
	private int height;
	private double vision;
	
	// 생성자
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData2 o) {
		return this.name.compareTo(o.name); // 이름 순 정렬
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public double getVision() {
		return vision;
	}

	@Override
	public String toString() {
		return name + ", " + height + ", " + vision;
	}
}

public class 실습2_객체배열정렬 {
	// 정렬 전
	private static void showData(String str, PhyscData2[] data) {
		// 반복문을 사용해서 출력
		System.out.println(str + " : ");
//		for(int i = 0; i < data.length; i++) {
//			System.out.print("[");
//			System.out.print(data[i]);
//			System.out.println("]");
//		}
//		System.out.println();
		
		System.out.println("-".repeat(35));
		for(PhyscData2 d : data) { // 확장문으로도 가능
			System.out.printf("%-8s\t%d\t%.6f\n", d.getName(), d.getHeight(), d.getVision());
		}
		System.out.println();
	}
	
	// 정렬 후
	private static void sortData(PhyscData2[] data) {
		// 원데이터의 양이 작으면 return, 원데이터가 너무 커서 복제가 불가능할때는 void
		// 거품, 삽입, 선택 -> O(n^2) 최악, 현실에서 O(n^2) 알고리즘은 쓰지 않음
		int n = data.length;
		// bubble sort
		for(int i = 0; i < n-1; i++) { // 선행
			for(int j = 0; j < n-1-i; j++) { // 후행
				if(data[j].compareTo(data[j+1]) > 0) {
					PhyscData2 temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}	
	}
	
	private static int binarySearch(PhyscData2[] data, String name) {
		int left = 0;
		int right = data.length-1;
		while(left <= right) { // 왼쪽과 오른쪽이 만났을 때
			int mid = (left + right) / 2;
			int cmp = data[mid].getName().compareTo(name);
			if(cmp == 0) {
				return mid;
			}
			else if(cmp < 0) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	private static PhyscData2[] insertObject(PhyscData2[] data, PhyscData2 obj) {
		int n = data.length;
		PhyscData2[] newData = new PhyscData2[n+1];
		int insertIdx = n;
		
		for(int i = 0; i < n; i++) {
			if(data[i].getName().compareTo(obj.getName()) > 0) {
				insertIdx = i;
				break;
			}
		}
		for(int i = 0; i < n; i++) {
			newData[i] = data[i];
		}
		
		newData[insertIdx] = obj;
		
		for(int i = insertIdx; i < n; i++) {
			newData[i+1] = data[i];
		}
		return newData;
	}
	
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData("정렬 전", data);
		sortData(data);
		showData("정렬 후", data);
		
		/* Comparator 
		 * 1. 클래스이면 객체
		 * 2. 객체를 생성할 수 있게 수단을 마련해야 함
		 * */
		// 람다식 - 람다식을 모르면 익명클래스로 만들어야 함
		Comparator<PhyscData2> heightComparator = (a, b) -> Integer.compare(a.getHeight(), b.getHeight());
		Arrays.sort(data, heightComparator); // comparator가 필요하다 
		showData("키 순으로 정렬 후", data);
		
		Comparator<PhyscData2> visionComparator = (a, b) -> Double.compare(a.getVision(), b.getVision());
		Arrays.sort(data, visionComparator);
		showData("시력 순으로 정렬 후", data);
		
		showData("정렬 전", data); // 시력 기준
		sortData(data); // 이름 기준

		// binarySearch의 단점 : 정렬된 데이터에서만 검색 가능
		String name = "이길동";
		int resultIndex = binarySearch(data, name); // 이름을 검색해야 하니까 이름 기준으로 정렬된 데이터를 갖고 와야 함
		if (resultIndex >= 0)
			System.out.println(name + "(이)가 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println(name + "(이)가 존재하지 않는다");
		
		PhyscData2[] newData= insertObject(data, new PhyscData2("소주다", 179, 1.5));
		// 배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입 후", newData);
	}

	

}
