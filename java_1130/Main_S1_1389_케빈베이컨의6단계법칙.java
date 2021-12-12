package java_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1389_케빈베이컨의6단계법칙 {

	public static final int INF = (int) 1e9;

	public static int N, M;
	public static int[][] Bacon;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Bacon = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(Bacon[i], INF);
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					Bacon[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Bacon[A][B] = Bacon[B][A] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					Bacon[a][b] = Math.min(Bacon[a][b], Bacon[a][k] + Bacon[k][b]);
				}
			}
		}

		int min = INF, minPerson = 1;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += Bacon[i][j];
			}

			if (min > sum) {
				min = sum;
				minPerson = i;
			}
		}

		System.out.println(minPerson);
	}

}
