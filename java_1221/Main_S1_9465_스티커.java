package java_1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_9465_½ºÆ¼Ä¿ {

	public static int T, n;
	public static int[][] stickers, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(in.readLine());
			stickers = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(getMaxScore()).append("\n");
		}

		System.out.println(sb);
	}

	public static int getMaxScore() {
		dp[0][1] = stickers[0][1];
		dp[1][1] = stickers[1][1];

		for (int i = 2; i <= n; i++) {
			dp[0][i] = Integer.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
			dp[1][i] = Integer.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
		}

		return Integer.max(dp[0][n], dp[1][n]);
	}

}
