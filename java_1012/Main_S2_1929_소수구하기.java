package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_1929_�Ҽ����ϱ� {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true); // ó���� ��� ���� �Ҽ��� ������ �ʱ�ȭ

		// 2���� N�� �����ٱ����� �����ϸ� �ȴ�.
		for (int i = 2; i <= Math.sqrt(N); i++) {
			// i�� �Ҽ����
			if (isPrime[i]) {
				// i�� ������� ��� �ռ����̴�.
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
