package java_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14500_테트로미노 {

	public static int N, M, max = 0, tsum;
	public static int[][] board;
	public static boolean[][] visited;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] tx = { { 0, 0, 0, -1 }, { 0, 0, 0, 1 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 } };
	public static int[][] ty = { { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 0, 0, 0, -1 }, { 0, 0, 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
			}
		}
		getMaxFromTMino();

		System.out.println(max);
	}

	private static void dfs(int x, int y, int sum, int index) {
		if (index == 4) {
			max = Math.max(max, sum);

			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, sum + board[nx][ny], index + 1);
				visited[nx][ny] = false;
			}
		}
	}

	private static void getMaxFromTMino() {
		for (int t = 0; t < 4; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isAvailable(i, j, t)) {
						max = Math.max(max, tsum);
					}

				}
			}
		}
	}

	private static boolean isAvailable(int x, int y, int t) {
		boolean result = true;
		tsum = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + tx[t][i];
			int ny = y + ty[t][i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				result = false;
				break;
			} else {
				tsum += board[nx][ny];
			}
		}

		return result;
	}

}