package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14501_��� {

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
		for (int i = N; i > 0; i--) { // �迭�� �ڿ������� �Ųٷ� Ȯ��
			if (i + T[i] - 1 <= N) { // ����� �Ⱓ �ȿ� ������ ���
				// dp[i] : i��° ������ ������ ������ �� �� �ִ� �ִ� ����
				dp[i] = Math.max(P[i] + dp[i + T[i]], max);
				max = dp[i];
			} else {
				dp[i] = max;
			}
		}

		System.out.println(max);
	}

}
