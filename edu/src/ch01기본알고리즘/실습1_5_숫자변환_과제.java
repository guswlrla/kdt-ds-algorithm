package ch01기본알고리즘;

import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
	private static String[] splitSortString(String input) {
		String splitStr[] = input.split(" ");
		Arrays.sort(splitStr);
		return splitStr;
	}

	private static void printStringArray(String[] sortedStringArray) {
		System.out.println(Arrays.toString(sortedStringArray));
	}
	
	private static int[] convertSortToIntArray(String[] sortedStringArray) {
		int intStr[] = new int[sortedStringArray.length];
		for(int i = 0; i < intStr.length; i++) {
			intStr[i] = Integer.parseInt(sortedStringArray[i]);
		}
		Arrays.sort(intStr);
		return intStr;
	}
	
	private static void printIntArray(int[] sortedIntArray) {
		System.out.println(Arrays.toString(sortedIntArray));
	}
	
    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222"; // String 정렬 -> 111, 12, ...
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
