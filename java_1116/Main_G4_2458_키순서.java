package java_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_2458_키순서 {

	static final int INF = (int) 1e9;
	static int N, M;
	static int[][] height;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		height = new int[N + 1][N + 1];

		// 최단 거리 테이블을 모두 무한, 자기 자신은 0으로 초기화
		for (int i = 1; i <= N; i++) {
			Arrays.fill(height[i], INF);
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					height[i][j] = 0;
					break;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			height[a][b] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					height[i][j] = Math.min(height[i][j], height[i][k] + height[k][j]);
				}
			}
		}

		int count = 0;
		outer: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (height[i][j] == INF && height[j][i] == INF) {
					continue outer;
				}
			}
			count++;
		}

		System.out.println(count);
	}

}
