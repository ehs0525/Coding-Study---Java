package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] house = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp[i][j][0] : 직전 방향이 가로인 파이프로 (i, j)로 이동시키는 방법의 개수
		// dp[i][j][1] : 직전 방향이 세로인 파이프로 (i, j)로 이동시키는 방법의 개수
		// dp[i][j][2] : 직전 방향이 대각선인 파이프로 (i, j)로 이동시키는 방법의 개수

		// 가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다.
		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				// if (state[i][j] == 0) {
				// 가로로 도착한 경우의 수
				if (j - 1 > 0 && house[i][j] == 0) // 집 범위 내이고 빈 칸일 때 옮길 수 있다.
					// 직전 파이프는 가로 또는 대각선으로 연결되었을 것이다(그림의 노란색 경우)
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

				// 세로로 도착한 경우의 수
				if (i - 1 > 0 && house[i][j] == 0)
					// 직전 파이프는 세로 또는 대각선으로 연결되었을 것이다(그림의 초록색 경우)
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

				// 대각선으로 도착한 경우의 수
				if (i - 1 > 0 && j - 1 > 0 && house[i][j] == 0 && house[i][j - 1] == 0 && house[i - 1][j] == 0)
					// 직전 파이프는 가로, 세로 또는 대각선으로 연결되었을 것이다(그림의 파란색 경우)
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				// }
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}

}
