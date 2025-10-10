//package ch02기본자료구조;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class 실습2_03_다차원배열 {
//	/*
//	 * 3번째 실습 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 함수에서 배열을 리턴할 때 리턴 타입 정의할 수
//	 * 있어야 한다
//	 */
//	public static void main(String[] args) {
//		int[][] A = new int[2][3];
//		int[][] B = new int[3][4];
//		int[][] C = new int[2][4];
//
//		inputData(A);
//		inputData(B);
//		int[][] D = A.clone(); // 교재83 - 배열 복제
//		System.out.println("A[2][3] = ");
//		showData("행렬 A", A);
//		System.out.println("D[2][3] = ");
//		showData("행렬 D", D);
//		System.out.println();
//		System.out.println("B[3][4] = ");
//		showData("행렬 B", B);
//		int[][] E = addMatrix(A, D);
//		System.out.println("E[2][3] = ");
//		showData("행렬 E", E);
//		C = multiplyMatrix(A, B);
//		System.out.println("C[2][4] = ");
//		showData("행렬 C", C);
//
////		int[][] F = transposeMatrix(B);
////		System.out.println("F[3][2] = ");
////		showData("행렬 F", F);
////		C = multiplyMatrixTransposed(A, F);
////		showData("행렬 곱셈 결과-전치행렬 사용", C);
////		boolean result = equals(A, C);
////		if (result)
////			System.out.println("행렬 A,C는 equal이다");
////		else
////			System.out.println("행렬 A,C는 equal 아니다");
//	}
//
//	private static int[][] multiplyMatrix(int[][] a, int[][] b) {
//		for(int i = 0; i < a[0].length; i++) {
//			for(int j = 0; j < b.length; j++) {
//				a[i][j] * b[j][i];
//			}
//		}
//		return null;
//	}
//
//	private static int[][] addMatrix(int[][] a, int[][] d) {
//		int e[][] = new int[a.length][a[0].length];
//		for(int i = 0; i < a.length; i++) {
//			for(int j = 0; j < a[i].length; j++) {
//				e[i][j] = a[i][j] + d[i][j];
//			}
//		}
//		return e;
//	}
//
//	private static void showData(String string, int[][] arr) {
//		System.out.println(string + " : " + Arrays.deepToString(arr)); // Arrays.toString()은 다차원까진 안보여줌
//	}
//
//	private static int[][] inputData(int[][] arr) {
//		Random rnd = new Random();
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = rnd.nextInt(10) + 1; // 범위값 잡아줬음
//			}
//		}
//		return arr;
//	}
//
//}
