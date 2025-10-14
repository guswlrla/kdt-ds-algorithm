package ch03검색알고리즘;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 -> 2번 실습: 스트링 객체의 정렬과 이진 탐색 -> 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.Random;

public class 실습3_01_정수배열이진탐색 {
	private static void inputData(int [] data) {
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(30)+1;
		}
	}
	
	private static void showList(String string, int[] data) {
		System.out.println(string + Arrays.toString(data));
	}
	
	private static boolean linearSearch(int[] data, int key) {
		int i = 0;
		while(true) {
			if(i == data.length) {
				return false;
			}
			if(data[i] == key) {
				return true;
			}
			i++;
		}
	}
	
	private static boolean binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length-1;
		
		do {
			int pc = (pl + pr) / 2;
			if(data[pc] == key) {
				return true;
			}
			else if(data[pc] < key) { // 검색범위를 뒤쪽 절반으로 좁힘
				pl = pc + 1;
			}
			else { // 검색범위를 앞쪽 절반으로 줄임
				pr = pc - 1;
			}
		} while(pl <= pr); // pl > pr이 되면 종료
			
		return false;
	}
	
	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data); // 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data); // 구현 반복 숙달 훈련

		int key = 13;
		boolean resultIndex = linearSearch(data, key); // 교재 p.99-100: 실습 3-1 참조, 교재 p.102: 실습 3-2
		
		// Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		/*
		 * 교재 109~113
		 */
		key = 19;
		resultIndex = binarySearch(data, key); // 함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		key = 10;
		int result = Arrays.binarySearch(data, key); // Arrays.binarySearch() - 일치하는 요소의 index값 반환, 없으면 음수 반환
		resultIndex = result >= 0 ? true : false;
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}



	
}
