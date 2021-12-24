package java_1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_11053_����������ϴºκм��� {

	public static int[] A, dp; // dp[i]�� A[i]�� ������ LIS�� ����
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		A = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dp[i] = Integer.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for (int len : dp) {
			max = Integer.max(max, len);
		}

		System.out.println(max);
	}

}
