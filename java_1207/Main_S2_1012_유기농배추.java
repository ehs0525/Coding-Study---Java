package java_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1012_유기농배추 {

	public static int T, M, N, K, X, Y;
	public static boolean[][] cabbagePatch;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			cabbagePatch = new boolean[N][M];

			K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				cabbagePatch[Y][X] = true;
			}

			int earthworm = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dfs(i, j)) {
						earthworm++;
					}
				}
			}

			sb.append(earthworm).append("\n");
		}

		System.out.println(sb);
	}

	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}

		// 배추가 심어져 있으면
		if (cabbagePatch[x][y]) {
			cabbagePatch[x][y] = false; // 방문 처리

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				dfs(nx, ny);
			}
			return true;
		}
		return false;
	}

}
