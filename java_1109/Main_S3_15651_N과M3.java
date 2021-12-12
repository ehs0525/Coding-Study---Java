package java_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15651_N°úM3 {

	static int N, M;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[M];

		getSequence(0);
	}

	private static void getSequence(int index) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			seq[index] = i;
			getSequence(index + 1);
		}

	}

}
