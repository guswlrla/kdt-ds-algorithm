package ch02기본자료구조;

import java.util.Arrays;
import java.util.Random;

/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

public class 실습2_01_메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("소스데이터", data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data); // 역순으로 출력 
		showData("역순 데이터", data);
	}
	
	static void showData(String str, int[] data) {
		// top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		System.out.println(str + " : " + Arrays.toString(data));
		System.out.println("top 개수 : " + top);
	}
	static int[] inputData(int[] data) { // 교재 63 - 난수의 생성
		// top이 배열에 저장된 갯수를 저장
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(MAX_LENGTH);
			top++;
		}
		return data;
	}
	static int findMax(int[] data) {
		// 최대값을 리턴
		int dataMax = data[0];
		for(int i = 0; i < data.length; i++) {
			dataMax = Math.max(dataMax ,data[i]);
		}
		return dataMax;
	}
	static boolean findValue(int[] data, int val) {
		// data[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for(int i = 0; i < data.length; i++) {
			if(data[i] == val)
				return true;
		}
		return false;
	}
	// reverse() 구현
	static void reverse(int[] data) {
		for(int i = 0; i < top/2; i++) {
			int tmp = data[i];
			data[i] = data[top-i-1];
			data[top-i-1] = tmp;
		}
	}
	
}
