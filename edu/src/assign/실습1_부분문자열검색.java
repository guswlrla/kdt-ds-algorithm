package assign;

import java.util.ArrayList;

/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 */
public class 실습1_부분문자열검색 {

	private static void searchSubstring(String text, String pattern) {
		ArrayList<Integer> val = new ArrayList<>();
		
		int pos = text.indexOf(pattern); // indexOf() - 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환
		while(pos != -1) { // 찾지 못했을 경우 -1을 반환
			val.add(pos);
			pos = text.indexOf(pattern, pos+1); 
		}
		System.out.println("출력 : " + val);
	}

	public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";

		searchSubstring(text, pattern);
		text = "abxabcabcabyabcaby";
		pattern = "abcaby";
		searchSubstring(text, pattern);
	}

}
