package java_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_2156_포도주시식 {

	static int n;
	static int[] wine, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		wine = new int[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(in.readLine());
		}

		dp[1] = wine[1];
		if (n > 1) {
			dp[2] = wine[1] + wine[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = Integer.max(dp[i - 3] + wine[i - 1] + wine[i], Integer.max(dp[i - 2] + wine[i], dp[i - 1]));
		}

		System.out.println(dp[n]);
	}

}
