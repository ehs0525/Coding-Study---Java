package java_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1182_부분수열의합 {

	static int N, S, subCnt = 0;
	static int[] seq;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		seq = new int[N];
		isSelected = new boolean[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			seq[i] = Integer.parseInt(st.nextToken());

		generateSubset(0);

		// S가 0일 경우 공집합을 빼준다.
		if (S == 0)
			subCnt--;
		System.out.println(subCnt);
	}

	private static void generateSubset(int count) {
		if (count == N) {
			int sum = 0;

			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					sum += seq[i];
			}

			if (sum == S)
				subCnt++;

			return;
		}

		isSelected[count] = true;
		generateSubset(count + 1);

		isSelected[count] = false;
		generateSubset(count + 1);
	}

}
