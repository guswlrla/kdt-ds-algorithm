package 실습과제;

import java.util.Random;

/*
 * 문제1) 조세푸스 문제(Josephus Problem)
 * 
 * 단일 linked List로 풀기!!
 * 문제 설명:
 * N명의 사람이 원형으로 앉아 있다.
 * K번째 사람을 반복적으로 제거한다.
 * 이 과정을 N-1명이 제거될 때까지 반복한다. 3번째가 제거 대상이면 2명(A> B)이면 A가 자살 대상이다.
 * 마지막으로 남는 사람의 위치를 구하는 문제이다.
 * 
 * 입력:
 * N: 사람의 수(각 사람의 id는 정수 난수로 생성- 생성 순서로 원형 singly linked list에 id의 올림차순으로 정렬되게 삽입)
 * K: 제거할 사람의 순서
 * 
 * 출력:
 * 1.	올림차순으로 정렬된 사람 id 순서를 출력
 * 2.	제거되는 k 번째 id 순서대로 출력
 * 3.	마지막으로 남는 사람의 id를 출력
*/

/*
 * 1 stack, 2. queue, 3. LinkedList
 * 입력 : 1. push(item), 2. enqueue(item), 3. add(item), insert(index, item)
 * 삭제 : 1. pop(), 2. dequeue(), 3. remove(item), remove(), delete(index, item)
 * 조회 : 1. peek(), 2. top(), peek(), 3. front(), get(item)
 * 검색 : 3. search(item)
 * 크기 : 1. size(), 2. size(), 3. size()
 * 상태 : 1. isEmpty(), 2. isEmpty(), 3. isEmpty()
 * */

class Node {
	int id;
	// Node prev; // 양방향 연결리스트
	Node next; // 단방향 연결리스트
	
	Node(int id) {
		this.id = id;
	}
}

class CircularLinkedList {
	Node head; // 연산의 기준점

	public void insertSorted(int id) {
		Node newNode = new Node(id);
		// 1) head == null
		// 2) 새 head가 기존의 head 앞에 위치
		// 3) 중간 어딘가에 추가
	}
	
	public void showList() {}
}

public class 실습8_01_요세푸스문제 {
	public static void main(String[] args) {
		// 출력 : 조세푸스 (7, 3) 문제
		// singleLinkedList = new SinglyLinkedList();
		// 1. for(int i = 0; i < N; i++) { /* id를 정렬해서 추가 */ }
		// LinkedList는 정렬 안함(입출력이 장점이기에) - 근데 정렬할거임, add를 연습시켜볼 의향
		// 2. 제거 순서를 출력
		// 3. item solve(K, N) { /* ... */}
		System.out.println("조세푸스 (7, 3)");
		
		int n = 7;
		int k = 3;
		
		Random random = new Random(42); // 시드 값 줘서 난수 고정
		
		CircularLinkedList sll = new CircularLinkedList();
		
		for(int i = 0; i < n; i++) {
			int id = random.nextInt(1000)+1;
			sll.insertSorted(id);
		}
		
		sll.showList();
	}
}
