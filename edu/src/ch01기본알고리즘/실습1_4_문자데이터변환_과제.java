package ch01기본알고리즘;

import java.util.Arrays;

public class 실습1_4_문자데이터변환_과제 {
/*
 * valueOf(boolVal)
 * Arrays.sort(array)
 */

    // 값을 문자열로 변환하여 배열에 저장하는 함수
    public static String[] convertValuesToString(boolean boolVal, char charVal, double doubleVal, int intVal, float floatVal) {
    	String val[] = new String[5];
    	val[0] = String.valueOf(boolVal);
    	val[1] = String.valueOf(charVal);
    	val[2] = String.valueOf(doubleVal);
    	val[3] = String.valueOf(intVal);
    	val[4] = String.valueOf(floatVal);
    	return val;
    }

    // 배열을 정렬하는 함수
    public static void sortStringArray(String[] array) {
    	Arrays.sort(array);
    }

    // 배열을 출력하는 함수
    public static void showAllString(String[] array) {
    	System.out.print(Arrays.toString(array));
    }
 
    public static void main(String[] args) {
        // 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
        String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);
        
        // 정렬 전 배열 출력
        System.out.println("정렬 전:");
        showAllString(stringArray); // 호출 전의 상태
        
        // 배열 정렬
        sortStringArray(stringArray);
        
        // 정렬 후 배열 출력
        // 같은 출력 함수인데 정렬 전후가 어떻게 적용되는 거지? - 호출 전과 후로 바뀌나봄
        System.out.println("\n정렬 후:");
        showAllString(stringArray); // 호출 후 배열이 정렬 됨
    }
}

