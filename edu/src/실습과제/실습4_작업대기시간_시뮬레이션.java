package 실습과제;

/*
문제 예시: timeslot 기반의 작업 scheduling 시스템
문제 설명:
1. 리스트에 작업이 추가됨
2-1. 테스트에선 시간 고정(3)
2-2. 단, 실무에선 난수로 배정해서 변경할 것
3. 각 작업은 주어진 time slot(3) 단위로 나눠서 처리
4. if 작업이 완료되면, 큐에서 제거
5. else 남은 작업시간을 가장 뒷부분에 추가
6. 반복문이 끝나면(queue가 empty가 되면) 종료 

제약 조건:
1 ≤ T ≤ 10
1 ≤ 작업의 개수 ≤ 100
각 작업의 남은 시간은 1 이상 100 이하
*/

// 라운드 로빈
// time slot : 한 번에 처리할 수 있는 작업량
public class 실습4_작업대기시간_시뮬레이션 {
	static class Job {
		String name;
		int remainingTime;

		private Job(String name, int remainingTime) {
			this.name = name;
			this.remainingTime = remainingTime;
		}
	}
	
	static class CircularQueue {
		Job[] queue;
		int front;
		int rear;
		int size;
		int capacity;
		
		public CircularQueue(int capacity) {
			this.capacity = capacity;
			this.queue = new Job[capacity];
			this.front = 0;
			this.rear = -1;
			this.size = 0;
		}
		
		boolean isEmpty() {
			return size == 0;
		}
		
		boolean isFull() {
			return size == capacity;
		}
		
		private void enqueue(Job job) {
			if(isFull()) {
				System.out.println("큐가 가득 찼습니다.");
				return;
			}
			rear = (rear + 1) % capacity;
			queue[rear] = job;
			size++;
		}
		
		Job dequeue() {
			if(isEmpty()) {
				return null;
			}
			Job job = queue[front];
			front = (front + 1) % capacity;
			size--;
			return job;
		}
	}

	public static void main(String[] args) {
		System.out.println("=== 테스트 케이스1 (계산됨) ===");
		int timeSlot = 3;
		String[][] jobData = { { "A", "10" }, { "B", "5" }, { "C", "8" } };
		
		CircularQueue queue = new CircularQueue(100);
		for(String[] data : jobData) {
			queue.enqueue(new Job(data[0], Integer.parseInt(data[1])));
		}
		int currentTime = 0;
		while (!queue.isEmpty()) {
			Job currentJob = queue.dequeue();
			
			int processTime = Math.min(timeSlot, currentJob.remainingTime);
			currentJob.remainingTime -= processTime;
			currentTime += processTime;
			
			System.out.println("처리 중 : " + currentJob.name + ", 남은 시간 : " + currentJob.remainingTime);
			
			if(currentJob.remainingTime == 0) {
				System.out.println(currentJob.name + " 완료, " + "시간 " + currentTime);
			} else {
				queue.enqueue(currentJob);
			}
		}
	}
}
