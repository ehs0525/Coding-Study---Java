package java_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_6603_·Î¶Ç {

	static int k;
	static int[] S, lotto;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = in.readLine();

			if (line.charAt(0) == '0')
				break;

			StringTokenizer st = new StringTokenizer(line, " ");
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			lotto = new int[6];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);
			System.out.println();
		}

	}

	private static void combination(int count, int start) {
		if (count == 6) {
			for (int i : lotto)
				System.out.print(i + " ");
			System.out.println();

			return;
		}

		for (int i = start; i < k; i++) {
			lotto[count] = S[i];

			combination(count + 1, i + 1);
		}
	}

}
