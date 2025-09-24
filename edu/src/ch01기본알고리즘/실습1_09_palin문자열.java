package ch01기본알고리즘;

/*
* 문자열이 palindrome(앞뒤로 동일하게 읽히는지)인지를 판별
* Palindrome은 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어, 문장, 숫자, 문자열 등을 뜻하는 영어 단어이며, 한국어로는 **회문(回文)**이라고 합니다. 
* '기러기', '동교동', '소주 만병만 주소' 등이 한국어 회문의 예시이며, 영어로는 'civic', 'madam', 'radar' 등이 팰린드롬에 해당
*/

/* 다른 사람에게 코드를 공개하기 전까지는 private가 default
 * main 메서드는 static이기 때문에, 호출할 함수도 static이어야 함
 * 삼항 연산자는 boolean return
 * 메서드 시그니처 : 메서드 이름 + 매개변수 타입 리스트
 * 오버로딩 - 같은 이름, 다른 시그니처로 여러 메서드 정의
 * 오버라이딩 - 상속 관계에서 같은 시그니처로 재정의
 * 인터페이스에 선언된 메서드는 시그니처만 포함
 * 안정성을 위해 조기 탈출(early stop)코드 중요
 * 사용자가 어떤 값을 줄 지 알 수 없기 때문에 잘못되면 일단 나가야 함
 * */


public class 실습1_09_palin문자열 {
	
	private static boolean isPalindrome(String s) { // charAt() 쓰면 편함...
		int len = s.length();
		String elements[] = new String[len];
		for(int i = 0; i < len; i++) {
			elements[i] = s.substring(i, i + 1); // subString() - 파라미터로 전달된 인덱스부터 값을 추출
		}
		
		for(int i = 0; i < len / 2; i++) {
			for(int j = len-1; j > len / 2; j--) {
				if(elements[i].equals(elements[j])) // elements[i] == elements[j]랑은 다름
					return true;
			}
		}
		return false;
	}
	
	private static boolean isPalindrome2(String s) {
		int len = s.length();
		for(int i = 0; i < len/2; i++) {
			if(s.charAt(i) != s.charAt(len-1-i)) { // charAt() - String 타입의 데이터(문자열)에서 특정 문자를 char 타입으로 변환
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// 테스트 케이스로 사용할 예제 문자열들
		String[] testStrings = { "racecar", // 팰린드롬
								"level", // 팰린드롬
								"tattarrattat", // 팰린드롬, 12글자
								"detartrated", // 팰린드롬, 11글자
								"redivider", // 팰린드롬, 9글자
								"hello", // 팰린드롬 아님
								"java" // 팰린드롬 아님
		};

		// 각 문자열에 대해 팰린드롬 여부 출력
		for (String s : testStrings) {
			System.out.println(s + " -> " + (isPalindrome2(s) ? "팰린드롬" : "팰린드롬 아님"));
		}
	}
}
