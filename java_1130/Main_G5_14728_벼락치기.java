package java_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14728_º­¶ôÄ¡±â {

	public static int N, T;
	public static int[] K, S;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = new int[N + 1];
		S = new int[N + 1];
		dp = new int[N + 1][T + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= T; j++) {
				if (j < K[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - K[i]] + S[i]);
				}
			}
		}

		System.out.println(dp[N][T]);
	}

}
