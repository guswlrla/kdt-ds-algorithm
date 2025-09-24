package ch02기본자료구조;

import java.util.Arrays;
import java.util.Random;

/*
 * 2장 - 정수 배열 정렬
 * 교재 67 - 실습 2-5
 * 2번 실습
 */

public class 실습2_02_정수배열정렬 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data); // 난수를 10 ~ 60 사이에 생성
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬 후", data);
		*/
		reverse(data); // 역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		reverseSort(data); // 역순으로 재배치 - 정렬
		showData("역순 정렬 후", data);
		
		sortData(data);
		
		int realData[] = {5, 15, 99};
		for (int newData: realData) {
			int []result = insertData(data, newData); // 입력 실수보다 큰 숫자를 우측으로 이동
			System.out.print("\n\n" + newData + " : ");
			showData("실수 삽입 후", result);
		}
	}
	
	private static int[] sortData(int[] data) {
		Arrays.sort(data);
		return data;
	}

	private static int[] reverseSort(int[] data) {
		Arrays.sort(data);
		return data;
	}

	private static int[] reverse(int[] data) {
		int len = data.length;
		for(int i = 0; i < len/2; i++) {
			int tmp = data[i];
			data[i] = data[len-i-1];
			data[len-i-1] = tmp;
		}
		return data;
	}

	private static void showData(String str, int[] data) {
		System.out.println(str + " : " + Arrays.toString(data));
	}

	private static int[] inputData(int[] data) {
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(50) + 10; // random.nextInt(범위 크기) + 최소값
		}
		return data;
	}

	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 * O(n) 알고리즘으로 구현 
	 */
	static int[] insertData(int []data, int value) { // insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1];
		
		return newData;
	}
}
