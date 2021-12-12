package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true); // 처음엔 모든 수가 소수인 것으로 초기화

		// 2부터 N의 제곱근까지만 수행하면 된다.
		for (int i = 2; i <= Math.sqrt(N); i++) {
			// i가 소수라면
			if (isPrime[i]) {
				// i의 배수들은 모두 합성수이다.
				int j = 2;
				while (i * j <= N) {
					isPrime[i * j] = false;
					j++;
				}
			}
		}

		for (int i = Math.max(2, M); i <= N; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}

}
