package 실습과제;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen2 {
	private static final int BOARD_SIZE = 8;
	private int solutionCount = 0;
	private List<List<Integer>> allSolutions = new ArrayList<>();

	private List<Integer> queens = new ArrayList<>();

	// 충돌 체크를 위한 Set들
	private Set<Integer> usedCols = new HashSet<>();
	private Set<Integer> usedDiag1 = new HashSet<>();
	private Set<Integer> usedDiag2 = new HashSet<>();

	private void solve() {
		backtrack(0);
	}

	// 재귀구문
	private void backtrack(int row) {
		if(row == BOARD_SIZE) {
			solutionCount++;
			saveSolution();
			printSolution();
			return;
		}
		for(int col = 0; col < BOARD_SIZE; col++) {
			if(isSafe(row, col)) {
				placeQueen(row, col);
				backtrack(row+1);
				removeQueen(row, col);
			}
		}
	}

	// O(1)
	// Set의 가장 큰 특징 : 중복을 허용하지 않음, 문제에 중복을 배제한다라고 나와있으면 Set 쓰란 것임
	// Collection을 쓰도록 노력!!!!!
	private boolean isSafe(int row, int col) {
		return !usedCols.contains(col) && !usedDiag1.contains(row - col) && !usedDiag2.contains(row + col);
	}

	private void placeQueen(int row, int col) {
		queens.add(col);
		usedCols.add(col);
		usedDiag1.add(row - col);
		usedDiag2.add(row + col);
	}
	
	private void removeQueen(int row, int col) {
		queens.remove(queens.size() - 1);
		usedCols.remove(col);
		usedDiag1.remove(row - col);
		usedDiag2.remove(row + col);
	}
	
	public void saveSolution() {
		allSolutions.add(new ArrayList<>(queens));
	}
	
	public void printSolution() {
		System.out.println("해 " + solutionCount + ":");
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if(queens.get(row) == col) {
					System.out.print("Q ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}

		// 퀸의 위치를 리스트로 출력
		System.out.println("퀸 위치 (행별 열 번호): " + queens);
		System.out.println();
	}
	
	public List<List<Integer>> getAllSolutions() {
		return new ArrayList<>(allSolutions);
	}
	
	public int getSolutionCount() {
		return solutionCount;
	}

	public static void main(String[] args) {
		System.err.println("NQueen");
		NQueen2 solver = new NQueen2();
		solver.solve();
		List<List<Integer>> solutions = solver.getAllSolutions();
		System.out.println("총 해의 개수: " + solutions.size());
	}
}
