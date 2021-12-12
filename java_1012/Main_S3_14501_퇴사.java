package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14501_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = N; i > 0; i--) { // 배열을 뒤에서부터 거꾸로 확인
			if (i + T[i] - 1 <= N) { // 상담이 기간 안에 끝나는 경우
				// dp[i] : i번째 날부터 마지막 날까지 낼 수 있는 최대 이익
				dp[i] = Math.max(P[i] + dp[i + T[i]], max);
				max = dp[i];
			} else {
				dp[i] = max;
			}
		}

		System.out.println(max);
	}

}
