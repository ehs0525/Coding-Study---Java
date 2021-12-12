package java_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_1699_제곱수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] sq = new int[318];
		for (int i = 1; i <= 317; i++)
			sq[i] = i * i;

		int N = Integer.parseInt(in.readLine());
		int[] d = new int[N + 1];

		// 다이나믹 프로그래밍 (보텀업)
		for (int i = 1; i <= N; i++) {
			d[i] = d[i - 1] + 1;

			int j = 1;
			while (true) {
				if (sq[j] > i)
					break;
				d[i] = Math.min(d[i], d[i - sq[j]] + 1);
				j++;
			}
		}

		System.out.println(d[N]);
	}

}
