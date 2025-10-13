//package ch02기본자료구조;
//
//import java.util.Arrays;
//
//public class 실습2_06_스트링배열정렬 {
//	/*
//	 * 2장 실습과제4 - 스트링 배열 정렬 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가
//	 * 필요
//	 */
//	public static void main(String[] args) {
//		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };
//
//		showData("정렬전", data);
//		// Arrays.sort(data); // Internally uses String.compareTo()
//		// Arrays.sort(data, (s1, s2) -> s1.compareTo(s2));
//		sortData(data);
//		showData("정렬후", data);
//		String[] newData = insertString(data, "banana");
//		showData("삽입후 크기가 증가된 정렬 배열", newData);
//	}
//
//	private static String[] insertString(String[] data, String string) {
//		int len = data.length;
//		String arr[] = new String[len + 1];
//		
//		int i = 0;
//		while(data[i] <= ) { // 인덱스를 들고 나와야함
//			arr[i] = data[i];
//			i++;
//		}
//		arr[i] = string;
//		return arr;
//	}
//
//	private static void sortData(String[] data) {
//		for(int i = 0; i < data.length-1; i ++) {
//			for(int j = 0; j < data.length-1-i; j++) {
//				if(data[j].compareTo(data[j+1]) > 0) {
//					String temp = data[j];
//					data[j] = data[j+1];
//					data[j+1] = temp;
//				}
//			}
//		}
//	}
//
//	private static void showData(String str, String[] data) {
//		System.out.println(str + " : " + Arrays.toString(data));
//	}
//}
