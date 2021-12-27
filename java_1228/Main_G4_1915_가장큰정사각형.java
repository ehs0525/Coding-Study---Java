package java_1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1915_가장큰정사각형 {

	public static int n, m;
	public static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		int max = 0;
		for (int i = 1; i <= n; i++) {
			char[] row = in.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = row[j - 1] - '0';

				if (arr[i][j] == 1) {
					dp[i][j] = Integer.min(dp[i - 1][j - 1], Integer.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Integer.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max * max);
	}

}
