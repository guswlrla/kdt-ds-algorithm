package ch01기본알고리즘;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 실습1_6_스트링토큰_과제 {
	
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
  
	private static String[] extractSortStrings(String msg) {
//		String result[] = msg.split(); // 이거 대신에 StringTokenizer() 사용
		StringTokenizer str = new StringTokenizer(msg);
		int count = str.countTokens();
		String tokenStr[] = new String[count];
		for(int i = 0; i < count; i++) { // nextTokens()를 호출하면 남아있는 개수가 줄어듦
			if (str.hasMoreTokens())
				tokenStr[i] = str.nextToken();
		}
		Arrays.sort(tokenStr);
		return tokenStr;
	}
	
	private static double[] convertSortToDouble(String[] sortedStringArray) {
		double doubleStr[] = new double[sortedStringArray.length]; 
		for(int i = 0; i < sortedStringArray.length; i++) {
			doubleStr[i] = Double.parseDouble(sortedStringArray[i]);
		}
		Arrays.sort(doubleStr);
		return doubleStr;
	}
  
	private static void printStringArray(String[] sortedStringArray) {
		System.out.println(Arrays.toString(sortedStringArray));
	}
	
	private static void printDoubleArray(double[] sortedDoubleArray) {
		System.out.println(Arrays.toString(sortedDoubleArray));
	}
	
    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }
}
