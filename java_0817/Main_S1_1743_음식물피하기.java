package java_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1743_음식물피하기 {

	static int N, M, food_waste;
	static int[][] koresco;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		koresco = new int[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			koresco[r][c] = 1;
		}

		int max = Integer.MIN_VALUE;
		// 모든 위치에 대하여 음식물 세기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				food_waste = 0;
				// 현재 위치에서 DFS 수행
				dfs(i, j);
				max = Integer.max(max, food_waste);
			}
		}
		
		System.out.println(max);
	}

	// DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	private static void dfs(int x, int y) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료
		if (x < 1 || x > N || y < 1 || y > M)
			return;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 현재 위치에 음식물 쓰레기가 있다면
		if (koresco[x][y] == 1) {
			// 해당 위치의 음식물 쓰레기 줍기(방문 처리같은 느낌)
			koresco[x][y] = 0;
			food_waste++;

			// 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				dfs(nx, ny);
			}
		}
	}

}
