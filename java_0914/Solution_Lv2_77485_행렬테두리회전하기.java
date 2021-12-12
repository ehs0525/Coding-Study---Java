package java_0914;

import java.util.Arrays;

public class Solution_Lv2_77485_행렬테두리회전하기 {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } })));
		System.out.println(Arrays.toString(
				solution(3, 3, new int[][] { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } })));
		System.out.println(Arrays.toString(solution(100, 97, new int[][] { { 1, 1, 100, 97 } })));

	}

	private static int[] solution(int rows, int columns, int[][] queries) {
		int[][] matrix = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				matrix[i][j] = columns * (i - 1) + j;
			}
		}

		int count = queries.length;
		int[] answer = new int[count];
		for (int i = 0; i < count; i++) {
			int x1 = queries[i][0];
			int y1 = queries[i][1];
			int x2 = queries[i][2];
			int y2 = queries[i][3];
			int temp = matrix[x1][y1];
			int min = rows * columns;

			// swap 작업은 반시계 방향으로!
			for (int j = x1; j < x2; j++) {
				matrix[j][y1] = matrix[j + 1][y1];
				min = Integer.min(min, matrix[j][y1]);
			}

			for (int j = y1; j < y2; j++) {
				matrix[x2][j] = matrix[x2][j + 1];
				min = Integer.min(min, matrix[x2][j]);
			}

			for (int j = x2; j > x1; j--) {
				matrix[j][y2] = matrix[j - 1][y2];
				min = Integer.min(min, matrix[j][y2]);
			}

			for (int j = y2; j > y1 + 1; j--) {
				matrix[x1][j] = matrix[x1][j - 1];
				min = Integer.min(min, matrix[x1][j]);
			}

			matrix[x1][y1 + 1] = temp;
			min = Integer.min(min, matrix[x1][y1 + 1]);

			answer[i] = min;
		}

		return answer;
	}
}
