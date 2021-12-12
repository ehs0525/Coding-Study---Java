package java_0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2578_빙고 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int host = Integer.parseInt(st.nextToken());

				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (board[k][l] == host) {
							board[k][l] = 0;

							if (countBingo(board) >= 3) {
								System.out.println(5 * i + (j + 1));
								return;
							}
						}
					}
				}
			}
		}

	}

	private static int countBingo(int[][] board) {
		int count = 0;
		boolean bingo = true;

		// 행 체크
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] != 0)
					continue outer;
			}
			count++;
		}

		// 열 체크
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[j][i] != 0)
					continue outer;
			}
			count++;
		}

		// 좌상-우하 대각선 체크
		for (int i = 0; i < 5; i++) {
			if (board[i][i] != 0) {
				bingo = false;
				break;
			}
		}
		if (bingo)
			count++;
		bingo = true;

		// 우상-좌하 대각선 체크
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] != 0) {
				bingo = false;
				break;
			}
		}
		if (bingo)
			count++;

		return count;
	}

}
